package com.example.rest_company.api;

import com.example.rest_company.Security.JwtProvider;
import com.example.rest_company.dto.request.RegisterRequest;
import com.example.rest_company.dto.response.AuthResponse;
import com.example.rest_company.entity.User;
import com.example.rest_company.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * author: Ulansky
 */
@RestController
public class AutApi {
    @Autowired
    private UserService userService;
    @Autowired
    private JwtProvider provider;

    @PostMapping("/register")
    public String registerUser(@RequestBody RegisterRequest request) {
        User user = new User();
        user.setPassword(request.getPassword());
        user.setEmail(request.getEmail());
        userService.saveUser(user);
        return "ok";
    }

    @PostMapping("/auth")
    public AuthResponse auth(@RequestBody RegisterRequest request) {
        System.out.println(1);
        User user = userService.findByEmailAndPassword(request.getEmail(), request.getPassword());
        System.out.println(2);
        System.out.println(user);
        String token = provider.generaToken(user.getEmail());
        System.out.println(3);
        return new AuthResponse(token);
    }
}