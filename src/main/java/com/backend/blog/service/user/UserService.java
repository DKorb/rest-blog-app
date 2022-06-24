package com.backend.blog.service.user;

import com.backend.blog.dto.auth.SignUpDto;
import com.backend.blog.entity.user.UserDto;

public interface UserService {

    UserDto registerUser(SignUpDto signUpDto);

}