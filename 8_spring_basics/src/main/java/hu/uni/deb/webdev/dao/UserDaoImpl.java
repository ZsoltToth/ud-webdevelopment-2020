package hu.uni.deb.webdev.dao;

import hu.uni.deb.webdev.dao.exception.UserNotFoundException;
import hu.uni.deb.webdev.model.User;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;

@Service
public class UserDaoImpl implements  UserDao{

    private Collection<User> database;

    public UserDaoImpl() {
        this.database = new HashSet<>();
    }

    @Override
    public void createUser(User user) {
        this.database.add(user);
    }

    @Override
    public Collection<User> readAll() {
        return new HashSet<>(database);
    }

    @Override
    public User readByUsername(String username) throws UserNotFoundException {
        return this.database.stream()
                .filter(user -> user.getUsername().equals(username))
                .findFirst()
                .orElseThrow(UserNotFoundException::new);
    }
}
