package com.example.rest_company.Security;

import com.example.rest_company.entity.CustomUserDetails;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.thymeleaf.extras.springsecurity5.auth.Authorization;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.util.StringUtils.hasText;

/**
 * author: Ulansky
 */
@Component
@Log
public class JwtFilter extends GenericFilter {


    private static  final  String AUTHORIZATION = "Authorization";
    @Autowired
    private JwtProvider jwtProvider;

    @Autowired
    private CustomUserDetService userDetService;



    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        String token = getTokenFromRequest((HttpServletRequest) servletRequest);
        {
            if (token != null && jwtProvider.validateToken(token)) {
                String email = jwtProvider.getEmailFromToken(token);
                CustomUserDetails customUserDetails = (CustomUserDetails) userDetService.loadUserByUsername(email);
                UsernamePasswordAuthenticationToken aut =
                        new UsernamePasswordAuthenticationToken(customUserDetails, customUserDetails, customUserDetails.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(aut);
            }
            filterChain.doFilter(servletRequest, servletResponse);
        }

    }

    public String getTokenFromRequest(HttpServletRequest request){
        String bear = request.getHeader(AUTHORIZATION);
        if(hasText(bear)&&bear.startsWith("Bearer ")){
            return bear.substring(7);
        }
        return  null;
    }
}
