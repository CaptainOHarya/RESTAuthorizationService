package ru.netology.autorizationservice.service;

import org.springframework.stereotype.Service;
import ru.netology.autorizationservice.authorities.Authorities;
import ru.netology.autorizationservice.exception.InvalidCredentials;
import ru.netology.autorizationservice.exception.UnauthorizedUser;
import ru.netology.autorizationservice.model.User;
import ru.netology.autorizationservice.repository.UserRepository;

import java.util.List;

@Service
public class AutorizationService {
    UserRepository userRepository;

    public AutorizationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Authorities> getAuthorities(User user) {
        System.out.println(user.getName());
        if (isEmpty(user.getName()) || isEmpty(user.getPassword())) {
            throw new InvalidCredentials("User name or password is empty");
        }
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user.getName(), user.getPassword());
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
