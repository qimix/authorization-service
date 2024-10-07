package ru.netology.authorization_service.repository;

import org.springframework.stereotype.Repository;
import ru.netology.authorization_service.model.Credentials;
import ru.netology.authorization_service.permissions.Authorities;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class UserRepository {
    private ConcurrentHashMap<Credentials, Authorities> concurrentHashMap = new ConcurrentHashMap<>();

    public List<Authorities> getUserAuthorities(String user, String password) {
        Credentials credentials = new Credentials(user, password);
        for (Map.Entry<Credentials, Authorities> entryMap : concurrentHashMap.entrySet()) {
            if (entryMap.getKey().equals(credentials)) {
                return List.of(entryMap.getValue());
            }
        }
        return new ArrayList<Authorities>();
    }
}
