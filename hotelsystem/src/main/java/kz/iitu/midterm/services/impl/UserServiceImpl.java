package kz.iitu.midterm.services.impl;

import kz.iitu.midterm.entities.user.User;
import kz.iitu.midterm.repository.ReservationRepository;
import kz.iitu.midterm.repository.RoomRepository;
import kz.iitu.midterm.repository.UserRepository;
import kz.iitu.midterm.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void createUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void delelteUser(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public Optional<User> findById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public User verificationUser(String login, String password) {

        User user = userRepository.findByUsernameAndPassword(login, password);
        return user;
    }
}
