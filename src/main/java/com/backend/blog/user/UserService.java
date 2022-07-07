package com.backend.blog.user;

import com.backend.blog.security.dto.SignUpDto;
import com.backend.blog.user.dto.UserDto;

public interface UserService {

    UserDto registerUser(SignUpDto signUpDto);

}