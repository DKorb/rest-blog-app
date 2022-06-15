package com.backend.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostResponse {

    private List<PostDto> content;
    private Integer pageNo;
    private Integer pageSize;
    private Long totalElements;
    private Integer totalPages;
    private Boolean last;

}