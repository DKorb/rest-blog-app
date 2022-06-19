package com.backend.blog.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@ApiModel(value = "Pagination model information")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostResponse {


    private List<PostDto> content;

    @ApiModelProperty(value = "Blog page number")
    private Integer pageNo;

    @ApiModelProperty(value = "Blog number of posts per page")
    private Integer pageSize;

    @ApiModelProperty(value = "Blog total number of posts")
    private Long totalElements;

    @ApiModelProperty(value = "Blog total number of pages")
    private Integer totalPages;

    @ApiModelProperty(value = "Blog is this last page")
    private Boolean last;

}