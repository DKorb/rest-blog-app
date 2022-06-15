package com.backend.blog.exception;

import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BlogAPIException extends RuntimeException {

    private HttpStatus status;
    private String message;

    @Override
    public String getMessage() {
        return message;
    }
}