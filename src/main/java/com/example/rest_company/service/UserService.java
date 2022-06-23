package com.example.rest_company.service;

import com.example.rest_company.entity.Role;
import com.example.rest_company.entity.User;
import com.example.rest_company.repository.RoleRepo;
import com.example.rest_company.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * author: Ulansky
 */
@Component
@RequiredArgsConstructor
public class UserService {

    private final UserRepo repo;
    private final PasswordEncoder encoder;

    public User saveUser(User user) {
        Role userRole = new Role();
        userRole.setRoleName("ADMIN");
        user.setRole(userRole);
        user.setPassword(encoder.encode(user.getPassword()));
        return repo.save(user);
    }

    public User findByEmail(String email) {
        return repo.finByEmail(email);

    }

    public User findByEmailAndPassword(String email, String password) {
        User user = findByEmail(email);
        if (user != null) {
            if (encoder.matches(password, user.getPassword())) {
                return user;
            } else {
                throw new BadCredentialsException("BadException");
            }
        }
        throw new BadCredentialsException("BadException");
    }
}
