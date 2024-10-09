package ru.netology.authorization_service.controller;

import org.springframework.web.bind.annotation.*;
import ru.netology.authorization_service.model.Credentials;
import ru.netology.authorization_service.service.AuthorizationService;
import ru.netology.authorization_service.permissions.Authorities;

import java.util.List;

@RestController
public class AuthorizationController {
    AuthorizationService service;

    public AuthorizationController(AuthorizationService authorizationService) {
        this.service = authorizationService;
    }

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@RequestParam("user") String user, @RequestParam("password") String password) {
        return service.getAuthorities(new Credentials(user, password));
    }
}
