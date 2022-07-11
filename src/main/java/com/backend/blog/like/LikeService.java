package com.backend.blog.like;

import com.backend.blog.like.dto.LikeDTO;

public interface LikeService {

    LikeDTO giveForPostById(String token, long postId);

    LikeDTO removeFromPostById(String token, long postId);

    LikeDTO giveForCommentById(String token, long postId);

}