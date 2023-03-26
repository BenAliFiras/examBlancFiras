package com.example.examblancfiras.controllers;

import com.example.examblancfiras.entities.User;
import com.example.examblancfiras.services.IUserServices;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController {
    private final IUserServices iUserServices;
    @PostMapping()
    public User ajouterUser(@RequestBody User user){
        return iUserServices.ajouterUser(user);
    }
}
