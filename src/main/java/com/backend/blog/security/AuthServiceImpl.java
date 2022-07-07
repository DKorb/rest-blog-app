package com.backend.blog.security;

import com.backend.blog.security.dto.JWTAuthResponse;
import com.backend.blog.security.dto.SignInDto;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private JWTTokenProvider tokenProvider;

    private AuthenticationManager authenticationManager;


    public AuthServiceImpl(JWTTokenProvider tokenProvider, AuthenticationManager authenticationManager) {
        this.tokenProvider = tokenProvider;
        this.authenticationManager = authenticationManager;
    }

    @Override
    public JWTAuthResponse createToken(SignInDto signInDto) {
        String token = generateToken(signInDto);
        return new JWTAuthResponse(token);
    }

    private String generateToken(SignInDto signInDto) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                signInDto.getUsernameOrEmail(),
                signInDto.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = tokenProvider.generateToken(authentication);

        return token;
    }

}