package hu.uni.deb.webdev.service;

import hu.uni.deb.webdev.model.User;
import hu.uni.deb.webdev.service.expcetion.UnknownUserException;

public interface GreetingsService {

    void welcome(User user);
    void welcome(String username) throws UnknownUserException;
}
