package com.example.examblancfiras.services;

import com.example.examblancfiras.entities.User;
import com.example.examblancfiras.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class IUserServiceImp implements IUserServices {

    @Autowired
    private UserRepository userRepository;
    @Override
    public User ajouterUser(User user) {
        return userRepository.save(user);
    }
}

