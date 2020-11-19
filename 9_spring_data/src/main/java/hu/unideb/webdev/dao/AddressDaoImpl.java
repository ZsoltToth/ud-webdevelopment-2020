package hu.unideb.webdev.dao;

import hu.unideb.webdev.dao.entity.AddressEntity;
import hu.unideb.webdev.dao.entity.CityEntity;
import hu.unideb.webdev.dao.entity.CountryEntity;
import hu.unideb.webdev.exceptions.UnknownAddressException;
import hu.unideb.webdev.exceptions.UnknownCountryException;
import hu.unideb.webdev.model.Address;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Slf4j
@RequiredArgsConstructor
public class AddressDaoImpl implements AddressDao{

    private final AddressRepository addressRepository;
    private final CityRepository cityRepository;
    private final CountryRepository countryRepository;

    @Override
    public void createAddress(Address address) throws UnknownCountryException {
        AddressEntity addressEntity;
        GeometryFactory geometryFactory = new GeometryFactory();

        addressEntity = AddressEntity.builder()
                .address(address.getAddress())
                .address2(address.getAddress2())
                .district(address.getDistrict())
                .postalCode(address.getPostalCode())
                .phone(address.getPhone())
                .location(geometryFactory.createPoint(new Coordinate()))
                .lastUpdate(new Timestamp((new Date()).getTime()))
                .city(queryCity(address.getCity(), address.getCountry()))
                .build();
        log.info("AddressEntity: {}", addressEntity);
        try {
            addressRepository.save(addressEntity);
        }
        catch(Exception e){
            log.error(e.getMessage());
        }
    }

    protected CityEntity queryCity(String city, String country) throws UnknownCountryException {

        Optional<CityEntity> cityEntity = cityRepository.findByName(city).stream()
                .filter(entity -> entity.getCountry().getName().equals(country))
                .findFirst();
        if(!cityEntity.isPresent()){
            Optional<CountryEntity> countryEntity = countryRepository.findByName(country);
            if(!countryEntity.isPresent()){
                throw new UnknownCountryException(country);
            }
            cityEntity = Optional.ofNullable(CityEntity.builder()
                    .name(city)
                    .country(countryEntity.get())
                    .lastUpdate(new Timestamp((new Date()).getTime()))
                    .build());
            cityRepository.save(cityEntity.get());
            log.info("Recorded new City: {}, {}", city, country);
        }
        log.trace("City Entity: {}", cityEntity);
        return cityEntity.get();
    }

    @Override
    public Collection<Address> readAll() {
        return StreamSupport.stream(addressRepository.findAll().spliterator(),false)
                .map(entity -> new Address(
                        entity.getAddress(),
                        entity.getAddress2(),
                        entity.getDistrict(),
                        entity.getCity().getName(),
                        entity.getCity().getCountry().getName(),
                        entity.getPostalCode(),
                        entity.getPhone()
                ))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteAddress(Address address) throws UnknownAddressException {
        Optional<AddressEntity> addressEntity = StreamSupport.stream(addressRepository.findAll().spliterator(),false).filter(
                entity ->{
                    return address.getAddress().equals(entity.getAddress())  &&
                    address.getAddress2().equals(entity.getAddress2()) &&
                    address.getDistrict().equals(entity.getDistrict()) &&
                    address.getCity().equals(entity.getCity().getName()) &&
                    address.getCountry().equals(entity.getCity().getCountry().getName());
                }
        ).findAny();
        if(!addressEntity.isPresent()){
            throw new UnknownAddressException(String.format("Address Not Found %s",address), address);
        }
        addressRepository.delete(addressEntity.get());
    }


}
