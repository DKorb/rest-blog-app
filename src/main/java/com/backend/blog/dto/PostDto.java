package com.backend.blog.dto;

import lombok.Data;

import java.util.Set;

@Data
public class PostDto {

    private Long Id;
    private String title;
    private String description;
    private String content;
    private Set<CommentDto> comments;

}