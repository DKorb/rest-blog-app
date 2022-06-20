package com.backend.blog.dto.comment;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@ApiModel(value = "Comment model information")
@Data
public class CommentDto {

    @ApiModelProperty(value = "Blog comment id")
    private Long id;

    @ApiModelProperty(value = "Blog comment name")
    @NotEmpty(message = "Name should not be null or empty")
    @Size(min = 3, message = "Name should have at least 3 characters")
    private String name;

    @ApiModelProperty(value = "Blog comment e-mail")
    @NotEmpty(message = "Email should not be null or empty")
    @Email
    private String email;

    @ApiModelProperty(value = "Blog comment body")
    @NotEmpty
    @Size(min = 16, message = "Comment body should have at least 16 characters")
    private String body;

}