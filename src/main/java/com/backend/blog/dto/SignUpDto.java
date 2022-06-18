package com.backend.blog.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value = "Register model information")
@Data
public class SignUpDto {

    @ApiModelProperty(value = "user first name")
    private String name;

    private String username;

    @ApiModelProperty(value = "user e-mail")
    private String email;

    @ApiModelProperty(value = "user password")
    private String password;

}