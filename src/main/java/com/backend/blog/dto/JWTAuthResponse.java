package com.backend.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JWTAuthResponse {

    private String accessToken;
    private final String tokenType = "Bearer";

}