package com.backend.blog.service;

import com.backend.blog.dto.CommentDto;

public interface CommentService {

    CommentDto createComment(long postId, CommentDto commentDto);
}