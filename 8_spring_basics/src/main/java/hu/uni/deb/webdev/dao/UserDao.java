package hu.uni.deb.webdev.dao;

import hu.uni.deb.webdev.dao.exception.UserNotFoundException;
import hu.uni.deb.webdev.model.User;

import java.util.Collection;

/**
 * DAO = Data Access Object
 * CRUD Methods:
 *  - Create -> Insert
 *  - Read -> Select
 *  - Update -> Update
 *  - Delete -> Delete
 */
public interface UserDao {

    void createUser(User user);

    Collection<User> readAll();
    User readByUsername(String username) throws UserNotFoundException;
}
