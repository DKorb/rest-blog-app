package com.backend.blog.security;

import com.backend.blog.security.dto.JWTAuthResponse;
import com.backend.blog.security.dto.SignInDTO;

public interface AuthService {

    JWTAuthResponse createToken(SignInDTO signInDto);

}