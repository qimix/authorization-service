package ru.netology.authorization_service.repository;

import ru.netology.authorization_service.permissions.Authorities;

import java.util.List;

public class UserRepository {
    public List<Authorities> getUserAuthorities(String user, String password) {
        return ...;
    }
}
