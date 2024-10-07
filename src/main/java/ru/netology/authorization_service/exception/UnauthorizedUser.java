package ru.netology.authorization_service.exception;

import org.springframework.stereotype.Component;

public class UnauthorizedUser extends RuntimeException {
    public UnauthorizedUser(String msg) {
        super(msg);
    }
}
