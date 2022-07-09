package com.backend.blog.exception;

public class PostNotExistsException extends RuntimeException {

    private static final String MESSAGE = "Post with id %d, does not exist";

    public PostNotExistsException(long postId) {
        super(MESSAGE.formatted(postId));
    }
}
