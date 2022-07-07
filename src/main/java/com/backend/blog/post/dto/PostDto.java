package com.backend.blog.post.dto;

import com.backend.blog.comment.dto.CommentDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Set;

@ApiModel(value = "Post model information")
@Data
public class PostDto {

    @ApiModelProperty(value = "Blog post id")
    private Long Id;

    @ApiModelProperty(value = "Blog post title")
    @NotEmpty
    @Size(min = 4, message = "Post title should have at least 4 characters")
    private String title;

    @ApiModelProperty(value = "Blog post description")
    @NotEmpty
    @Size(min = 16, message = "Post description should have at least 16 characters")
    private String description;

    @ApiModelProperty(value = "Blog post content")
    @NotEmpty
    @Size(min = 16, message = "Post content should have at least 16 characters")
    private String content;

    @ApiModelProperty(value = "Blog post comments")
    private Set<CommentDto> comments;

}