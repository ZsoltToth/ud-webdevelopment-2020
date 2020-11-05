package hu.uni.deb.webdev.service;

import hu.uni.deb.webdev.dao.UserDao;
import hu.uni.deb.webdev.dao.exception.UserNotFoundException;
import hu.uni.deb.webdev.model.User;
import hu.uni.deb.webdev.service.expcetion.UnknownUserException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class GreetingsServiceImpl implements GreetingsService{

    private final UserDao dao;

    @Override
    public void welcome(User user) {
        System.out.println(String.format("Hello %s!", user.getName()));
    }

    @Override
    public void welcome(String username) throws UnknownUserException {
        try{
            welcome(dao.readByUsername(username));
        } catch (UserNotFoundException e) {
            log.error("User not found with userneme: {}",username);
            throw new UnknownUserException(String.format("User not found with username: %s", username), e);
        }
    }
}
