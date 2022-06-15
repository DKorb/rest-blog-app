package com.backend.blog.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Set;

@Data
public class PostDto {

    private Long Id;

    @NotEmpty
    @Size(min = 4, message = "Post title should have at least 4 characters")
    private String title;

    @NotEmpty
    @Size(min = 16, message = "Post description should have at least 16 characters")
    private String description;

    @NotEmpty
    @Size(min = 16, message = "Post content should have at least 16 characters")
    private String content;

    private Set<CommentDto> comments;

}