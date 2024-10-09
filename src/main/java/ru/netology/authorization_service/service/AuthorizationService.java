package ru.netology.authorization_service.service;

import org.springframework.stereotype.Service;
import ru.netology.authorization_service.exception.InvalidCredentials;
import ru.netology.authorization_service.exception.UnauthorizedUser;
import ru.netology.authorization_service.model.Credentials;
import ru.netology.authorization_service.permissions.Authorities;
import ru.netology.authorization_service.repository.UserRepository;

import java.util.List;

@Service
public class AuthorizationService {
    UserRepository userRepository;

    public AuthorizationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Authorities> getAuthorities(Credentials credentials) {
        if (isEmpty(credentials.getUsername()) || isEmpty(credentials.getPassword())) {
            throw new InvalidCredentials("User name or password is empty");
        }
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(credentials);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + credentials.getUsername());
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
