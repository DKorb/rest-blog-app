package com.backend.blog.exception;

public class LoginInUseException extends RuntimeException {

    private static final String MESSAGE = "Error while creating user, probably user with login %s exists in base!";

    public LoginInUseException(String value) {
        super(MESSAGE.formatted(value));
    }
}
