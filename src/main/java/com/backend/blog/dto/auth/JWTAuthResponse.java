package com.backend.blog.dto.auth;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@ApiModel(value = "JWT response")
@Data
@AllArgsConstructor
public class JWTAuthResponse {

    @ApiModelProperty(value = "token to access")
    private String accessToken;

    @ApiModelProperty(value = "typ of access token")
    private static final String TOKEN_TYPE = "Bearer";

}