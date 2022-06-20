package com.example.rest_company.Security;

import com.example.rest_company.entity.CustomUserDetails;
import com.example.rest_company.entity.Role;
import com.example.rest_company.entity.User;
import com.example.rest_company.repository.RoleRepo;
import com.example.rest_company.repository.UserRepo;
import com.example.rest_company.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * author: Ulansky
 */
@Component

public class CustomUserDetService implements UserDetailsService {

    @Autowired
    private UserService service;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
       User user = service.findByEmail(email);
        return CustomUserDetails.fromEntityToCustom(user);
    }
}
