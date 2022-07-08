package com.backend.blog.user;

import com.backend.blog.security.dto.SignUpDTO;
import com.backend.blog.user.dto.UserDTO;

public interface UserService {

    UserDTO registerUser(SignUpDTO signUpDto);

    User currentLoggedUser(String token);

}