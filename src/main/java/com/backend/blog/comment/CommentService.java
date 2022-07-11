package com.backend.blog.comment;

import com.backend.blog.comment.dto.CommentDto;
import com.backend.blog.like.dto.LikeDTO;

import java.util.List;

public interface CommentService {

    CommentDto createComment(String token, long postId, CommentDto commentDto);

    List<CommentDto> getCommentsByPostId(long postId);

    CommentDto getCommentById(long postId, long commentId);

    Comment getComment(long id);

    CommentDto updateCommentById(CommentDto commentDto, long postId, long commentId);

    void deleteCommentById(long postId, long commentId);

    LikeDTO giveLikeByCommentId(String token, long commentId);

}