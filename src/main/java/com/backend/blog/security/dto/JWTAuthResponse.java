package com.backend.blog.security.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value = "JWT response")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JWTAuthResponse {

    @ApiModelProperty(value = "token to access")
    private String accessToken;

    @ApiModelProperty(value = "typ of access token")
    private static final String TOKEN_TYPE = "Bearer";

}