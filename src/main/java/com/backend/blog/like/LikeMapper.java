package com.backend.blog.like;

import com.backend.blog.like.dto.LikeDTO;

public class LikeMapper {

    public static LikeDTO buildForPost(Like like){
        var post = like.getPost();
        var user = like.getUser();
        return LikeDTO.builder()
                .post(post.getId())
                .user(user.getId())
                .build();
    }

    public static LikeDTO buildForComment(Like like){
        var comment = like.getComment();
        var user = like.getUser();
        return LikeDTO.builder()
                .comment(comment.getId())
                .user(user.getId())
                .build();
    }


}