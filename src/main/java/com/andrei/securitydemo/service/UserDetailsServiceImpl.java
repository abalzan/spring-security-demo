package com.andrei.securitydemo.service;

import com.andrei.securitydemo.domain.User;
import com.andrei.securitydemo.repository.UserRepository;
import com.andrei.securitydemo.security.CustomSecurityUser;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(s);

        if(user == null) {
            throw new UsernameNotFoundException("Username or password are incorrect");
        }

        return new CustomSecurityUser(user);
    }

}
