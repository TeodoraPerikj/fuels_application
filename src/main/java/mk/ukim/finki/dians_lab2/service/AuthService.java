package mk.ukim.finki.dians_lab2.service;

import mk.ukim.finki.dians_lab2.model.User;

public interface AuthService {

    User login(String username, String password);

    User register(String username, String password, String repeatPassword, String name, String surname);

}
