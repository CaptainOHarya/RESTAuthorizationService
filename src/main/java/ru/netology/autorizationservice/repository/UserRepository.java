package ru.netology.autorizationservice.repository;

import org.springframework.stereotype.Repository;
import ru.netology.autorizationservice.authorities.Authorities;
import ru.netology.autorizationservice.model.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
@Repository
public class UserRepository {
    private final Map<User, List<Authorities>> listUser;
    private final List<Authorities> authoritiesList;

    public UserRepository() {
        listUser = new ConcurrentHashMap<>();
        authoritiesList = new ArrayList<>();
        User katya = new User("Екатерина", "katya26");
        User marina = new User("Марина", "12345");
        User alienKesha = new User("ИнопланетянинКеша", "LOM");
        User banni = new User("БанниКарвахаль", "forward");
        User ivanO = new User("Олень1987", "kdfg");
        User error1 = new User("Vitya", "kh");
        User error2 = new User("Petya", "");

        listUser.put(katya, Arrays.asList(Authorities.values()));
        listUser.put(marina, Arrays.asList(Authorities.values()));
        listUser.put(alienKesha, Arrays.asList(Authorities.READ));
        listUser.put(banni, Arrays.asList(Authorities.READ, Authorities.WRITE));
        listUser.put(ivanO, Arrays.asList(Authorities.DELETE));
        listUser.put(error1, Arrays.asList(Authorities.DELETE));

    }
    public List<Authorities> getUserAuthorities(String user, String password) {
        for (Map.Entry<User, List<Authorities>> entry : listUser.entrySet()) {
            if (entry.getKey().getName().equals(user) && entry.getKey().getPassword().equals(password)) {
                return entry.getValue();
            }
        }
        return authoritiesList;
    }

}
