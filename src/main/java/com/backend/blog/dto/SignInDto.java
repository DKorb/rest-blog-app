package com.backend.blog.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value = "login model information")
@Data
public class SignInDto {

    @ApiModelProperty(value = "username or email to login")
    private String usernameOrEmail;

    @ApiModelProperty(value = "password to login")
    private String password;

}