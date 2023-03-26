package com.example.examblancfiras.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class Logging {
    @After("execution(* com.example.examblancfiras.services.*.get*(..))")
    public void apres(JoinPoint thisJoinPoint) {
        log.info("Out of the method (After)" + thisJoinPoint.getSignature().getName());
    }
}
