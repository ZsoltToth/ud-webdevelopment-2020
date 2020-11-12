package hu.unideb.webdev.dao;

import hu.unideb.webdev.model.Address;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class AddressDaoImpl implements AddressDao{

    private final AddressRepository addressRepository;
    private final CityRepository cityRepository;
    private final CountryRepository countryRepository;

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
}
