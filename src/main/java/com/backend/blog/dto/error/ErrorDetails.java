package com.backend.blog.dto.error;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@ApiModel(value = "Error details model information")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDetails {

    @ApiModelProperty(value = "time of error occurrence")
    private Date timestamp;

    @ApiModelProperty(value = "return message")
    private String message;

    @ApiModelProperty(value = "detailed information about error")
    private String details;

    @ApiModelProperty(value = "error code")
    private Integer errorCode;

}