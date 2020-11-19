package hu.unideb.webdev.service;

import hu.unideb.webdev.dao.AddressDao;
import hu.unideb.webdev.exceptions.UnknownAddressException;
import hu.unideb.webdev.exceptions.UnknownCountryException;
import hu.unideb.webdev.model.Address;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService{

    private final AddressDao addressDao;

    @Override
    public Collection<Address> getAllAddress() {
        return addressDao.readAll();
    }

    @Override
    public Collection<Address> getAddressInCity(String city) {
        return addressDao.readAll().stream()
                .filter(address -> city.equals(address.getCity()))
                .collect(Collectors.toList());
    }

    @Override
    public void recordAddress(Address address) throws UnknownCountryException {
        addressDao.createAddress(address);
    }

    @Override
    public void deleteAddress(Address address) throws UnknownAddressException {
        addressDao.deleteAddress(address);
    }
}
