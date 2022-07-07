package com.backend.blog.security;

import com.backend.blog.security.dto.JWTAuthResponse;
import com.backend.blog.security.dto.SignInDto;

public interface AuthService {

    JWTAuthResponse createToken(SignInDto signInDto);

}