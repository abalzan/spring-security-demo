package com.andrei.securitydemo;

import com.andrei.securitydemo.domain.Authorities;
import com.andrei.securitydemo.domain.User;
import com.andrei.securitydemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.LinkedHashSet;
import java.util.Set;

@Component
public class Bootstrap implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        User user = new User();
        user.setUsername("test@test.com");
        user.setPassword("$2a$10$/DvrrGIOxHsYb4q9PR8no.M/LitaWEhkdgRyRMqZySRwBBqqyOMHK");

        Authorities userAuthorities = new Authorities();
        userAuthorities.setAuthority("ROLE_USER");
        userAuthorities.setUser(user);
        Set<Authorities> authorities = new LinkedHashSet<>();
        authorities.add(userAuthorities);

        user.setAuthorities(authorities);
        userRepository.save(user);

    }
}
