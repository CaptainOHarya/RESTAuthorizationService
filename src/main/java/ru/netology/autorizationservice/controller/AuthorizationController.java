package ru.netology.autorizationservice.controller;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.autorizationservice.authorities.Authorities;
import ru.netology.autorizationservice.model.User;
import ru.netology.autorizationservice.service.AutorizationService;

import java.util.List;

@RestController
@RequestMapping("/")
public class AuthorizationController {
    AutorizationService service;

    public AuthorizationController(AutorizationService service) {
        this.service = service;
    }

    @GetMapping("authorize")
    public List<Authorities> getAuthorities(@Valid User user) {
        return service.getAuthorities(user);
    }
}
