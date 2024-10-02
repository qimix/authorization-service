package ru.netology.authorization_service.service;

import ru.netology.authorization_service.exception.InvalidCredentials;
import ru.netology.authorization_service.exception.UnauthorizedUser;
import ru.netology.authorization_service.permissions.Authorities;
import ru.netology.authorization_service.repository.UserRepository;
import java.util.List;

public class AuthorizationService {
    UserRepository userRepository;

    List<Authorities> getAuthorities(String user, String password) {
        if (isEmpty(user) || isEmpty(password)) {
            throw new InvalidCredentials("User name or password is empty");
        }
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user, password);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + user);
        }
        return userAuthorities;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }
}
