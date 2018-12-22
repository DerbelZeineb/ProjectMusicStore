package com.example.demo.service;

import com.example.demo.Repositories.UserRepository;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    @Autowired
    UserRepository userRepository;

    public void save(User user) {
        userRepository.save(user);
    }

    public User findByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    public User findByLoginAndPasswd(String login, String passwd) {
        return userRepository.findByLoginAndPasswd(login,passwd);
    }
}

