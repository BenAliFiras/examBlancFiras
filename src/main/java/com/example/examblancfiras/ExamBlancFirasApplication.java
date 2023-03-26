package com.example.examblancfiras;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableAspectJAutoProxy
@EnableScheduling
@SpringBootApplication
public class ExamBlancFirasApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExamBlancFirasApplication.class, args);
    }

}

