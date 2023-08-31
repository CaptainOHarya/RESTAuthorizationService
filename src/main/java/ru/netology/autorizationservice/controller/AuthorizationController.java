package ru.netology.autorizationservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.autorizationservice.authorities.Authorities;
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
    public List<Authorities> getAuthorities(@RequestParam("user") String user, @RequestParam("password") String password) {
        return service.getAuthorities(user, password);
    }
}
