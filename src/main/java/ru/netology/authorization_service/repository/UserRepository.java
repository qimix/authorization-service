package ru.netology.authorization_service.repository;

import org.springframework.stereotype.Repository;
import ru.netology.authorization_service.permissions.Authorities;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    private List<Authorities> authoritiesList = new ArrayList<>();

    public List<Authorities> getUserAuthorities(String user, String password) {
        return List.of(Authorities.values());
    }
}
