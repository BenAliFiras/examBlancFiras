package com.example.examblancfiras.repositories;

import com.example.examblancfiras.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByFnameAndLname(String fn, String ln);
}
