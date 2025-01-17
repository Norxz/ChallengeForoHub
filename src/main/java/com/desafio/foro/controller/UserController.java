package com.desafio.foro.controller;

import com.desafio.foro.domain.user.User;
import com.desafio.foro.repository.UserRepository;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@SecurityRequirement (name = "bearer-key")
public class UserController {
    
    @Autowired
    private UserRepository userRepository;
    
    
    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

}
