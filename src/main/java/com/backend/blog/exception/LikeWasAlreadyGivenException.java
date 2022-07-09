package com.backend.blog.exception;

public class LikeWasAlreadyGivenException extends RuntimeException {

    private static final String MESSAGE = "Error when trying to like post with id %d, you probably already gave it a like!";

    public LikeWasAlreadyGivenException(long postId) {
        super(MESSAGE.formatted(postId));
    }
}
