package ru.netology.authorization_service.exception;

import org.springframework.stereotype.Component;

@Component
public class InvalidCredentials extends RuntimeException {
    public InvalidCredentials(String msg) {
        super(msg);
    }
}