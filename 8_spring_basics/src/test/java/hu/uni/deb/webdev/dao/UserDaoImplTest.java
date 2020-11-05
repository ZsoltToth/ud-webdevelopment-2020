package hu.uni.deb.webdev.dao;

import hu.uni.deb.webdev.dao.exception.UserNotFoundException;
import hu.uni.deb.webdev.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoImplTest {

    private UserDao dao;

    @BeforeEach
    void setUp() {
        this.dao = new UserDaoImpl(Arrays.asList(
                new User("John Doe", "john",42),
                new User("Jane Doe", "jane",42)
                ));
    }

    @Test
    public void  testReadExistingUser() throws UserNotFoundException {
        final User expected = new User("John Doe", "john",42);
        final String username = "john";
        final User actual = dao.readByUsername(username);

        assertEquals(expected, actual);
    }
}