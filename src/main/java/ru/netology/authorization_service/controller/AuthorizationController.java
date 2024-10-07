package ru.netology.authorization_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.authorization_service.service.AuthorizationService;
import ru.netology.authorization_service.permissions.Authorities;
import java.util.List;

@RestController
public class AuthorizationController {
    AuthorizationService service;
    public AuthorizationController(AuthorizationService authorizationService){
        this.service = authorizationService;
    }

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@RequestParam("user") String user, @RequestParam("password") String password) {
        return service.getAuthorities(user, password);
    }
}
