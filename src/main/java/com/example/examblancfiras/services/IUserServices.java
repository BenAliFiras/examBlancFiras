package com.example.examblancfiras.services;

import com.example.examblancfiras.entities.User;
import org.springframework.stereotype.Service;

@Service
public interface IUserServices {
    User ajouterUser(User user);
}
