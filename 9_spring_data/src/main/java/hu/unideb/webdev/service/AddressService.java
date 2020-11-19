package hu.unideb.webdev.service;

import hu.unideb.webdev.exceptions.UnknownAddressException;
import hu.unideb.webdev.exceptions.UnknownCountryException;
import hu.unideb.webdev.model.Address;

import java.util.Collection;

public interface AddressService {

    Collection<Address> getAllAddress();
    Collection<Address> getAddressInCity(String city);

    void recordAddress(Address address) throws UnknownCountryException;
    void deleteAddress(Address address) throws UnknownAddressException;
}
