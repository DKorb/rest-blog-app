package com.backend.blog.like;


import com.backend.blog.comment.Comment;
import com.backend.blog.comment.CommentService;
import com.backend.blog.exception.CommentLikeWasAlreadyGivenException;
import com.backend.blog.exception.LikeNotOwnerException;
import com.backend.blog.exception.PostLikeWasAlreadyGivenException;
import com.backend.blog.exception.PostNotExistsException;
import com.backend.blog.like.dto.LikeDTO;
import com.backend.blog.post.Post;
import com.backend.blog.post.PostService;
import com.backend.blog.user.User;
import com.backend.blog.user.UserService;
import com.backend.blog.utils.AppConstants;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@Transactional
@AllArgsConstructor(onConstructor = @__(@Lazy))
public class LikeServiceImpl implements LikeService {


    private final LikeRepository likeRepository;

    private final UserService userService;

    private final PostService postService;

    private final CommentService commentService;


    @Override
    public LikeDTO giveForPostById(String token, long post_id) {
        User user = getUser(token);
        Post post = getPost(post_id);

        if (isLikeInPost(user, post)) {
            throw new PostLikeWasAlreadyGivenException(post_id);
        }

        Like like = likeRepository.save(buildLikeForPost(user, post));

        return LikeMapper.buildForPost(like);
    }

    @Override
    public LikeDTO removeFromPostById(String token, long postId) {
        Like likeFromPost = getLikeFromPost(token, postId);
        likeRepository.delete(likeFromPost);
        return LikeMapper.buildForPost(likeFromPost);
    }

    @Override
    public LikeDTO giveForCommentById(String token, long commentId) {
        User user = getUser(token);
        Comment comment = getComment(commentId);

        if (isLikeInComment(user, comment)) {
            throw new CommentLikeWasAlreadyGivenException(commentId);
        }

        Like like = likeRepository.save(buildLikeForComment(user, comment));

        return LikeMapper.buildForComment(like);
    }

    private Like getLikeFromPost(String token, long id) {
        return getPost(id).getMyLikes().stream()
                .filter(like -> isOwnerOfLike(like, getUser(token.replace(AppConstants.HEADER_VALUE, ""))))
                .findFirst()
                .orElseThrow(() -> new PostNotExistsException(id));
    }

    private Like buildLikeForPost(User user, Post post) {
        return Like.builder()
                .user(user)
                .post(post)
                .build();
    }

    private Like buildLikeForComment(User user, Comment comment) {
        return Like.builder()
                .user(user)
                .comment(comment)
                .build();
    }

    private boolean isLikeInPost(User user, Post post) {
        return post.getMyLikes().stream()
                .anyMatch(like -> isOwnerOfLike(like, user));
    }

    private boolean isLikeInComment(User user, Comment comment) {
        return comment.getMyLikes().stream()
                .anyMatch(like -> isOwnerOfLike(like, user));
    }

    private boolean isOwnerOfLike(Like like, User user) {
        if (Objects.equals(like.getUser(), user)) {
            return true;
        } else {
            throw new LikeNotOwnerException();
        }
    }

    private User getUser(String token) {
        return userService.currentLoggedUser(token);
    }

    private Post getPost(long id) {
        return postService.getPost(id);
    }

    private Comment getComment(long id) {
        return commentService.getComment(id);
    }

}