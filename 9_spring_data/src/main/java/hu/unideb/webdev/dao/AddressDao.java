package hu.unideb.webdev.dao;

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

    Collection<Address> readAll();
}
