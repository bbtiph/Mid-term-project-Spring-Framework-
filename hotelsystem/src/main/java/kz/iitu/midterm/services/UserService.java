package kz.iitu.midterm.services;

import kz.iitu.midterm.entities.user.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

public interface UserService {
    Optional<User> findById(int id);
    void createUser(User user);
    User verificationUser(String login, String password);
    void delelteUser(int id);
}
