package com.backend.blog.exception;

public class PostLikeWasAlreadyGivenException extends RuntimeException {

    private static final String MESSAGE = "Error when trying to like post with id %d, you probably already gave it a like!";

    public PostLikeWasAlreadyGivenException(long postId) {
        super(MESSAGE.formatted(postId));
    }
}
