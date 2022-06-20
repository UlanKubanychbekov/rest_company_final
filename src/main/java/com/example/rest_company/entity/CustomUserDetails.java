package com.example.rest_company.entity;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

/**
 * author: Ulansky
 */
@ToString
public class CustomUserDetails implements UserDetails {

    private String email;
    private String password;
    private Collection<?extends  GrantedAuthority> grantedAuthorities;

    public static  CustomUserDetails fromEntityToCustom(User user){
        CustomUserDetails userDetails = new CustomUserDetails();
        userDetails.email = user.getEmail();
        userDetails.password = user.getPassword();
        userDetails.grantedAuthorities = Collections.singletonList(new SimpleGrantedAuthority(user.getRole().getRoleName()));

        return userDetails;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
