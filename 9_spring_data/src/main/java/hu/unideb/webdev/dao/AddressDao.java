package hu.unideb.webdev.dao;

import hu.unideb.webdev.exceptions.UnknownAddressException;
import hu.unideb.webdev.exceptions.UnknownCountryException;
import hu.unideb.webdev.model.Address;

import java.util.Collection;

/**
 * DAO = Data Access Object
 *
 * CRUD Methods:
 *  - Create
 *  - Read
 *  - Update
 *  - Delete
 */
public interface AddressDao {

    void createAddress(Address address) throws UnknownCountryException;
    Collection<Address> readAll();

    void deleteAddress(Address address) throws UnknownAddressException;
}
