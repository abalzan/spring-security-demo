package com.andrei.securitydemo.service;

import com.andrei.securitydemo.domain.User;
import com.andrei.securitydemo.repository.UserRepository;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    private final UserRepository userRepository;

    public AdminService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Secured({"ROLE_ADMIN"})
    public List<User> getAllUserAccounts(){
        return userRepository.findAll();
    }
}
