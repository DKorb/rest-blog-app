package com.backend.blog.security;

import com.backend.blog.security.dto.JWTAuthResponse;
import com.backend.blog.security.dto.SignInDto;
import com.backend.blog.security.dto.SignUpDto;
import com.backend.blog.user.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Api(value = "Auth controller exposes signing and signup REST API")
@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private UserService userService;

    private AuthService authService;

    public AuthController(UserService userService, AuthServiceImpl authService) {
        this.userService = userService;
        this.authService = authService;
    }

    @ApiOperation(value = "REST API to login user to application")
    @PostMapping("/signin")
    public ResponseEntity<JWTAuthResponse> authenticateUser(@RequestBody SignInDto signInDto) {
        return ResponseEntity.ok(authService.createToken(signInDto));
    }

    @ApiOperation(value = "REST API to register new user to application")
    @PostMapping("/signup")
    public ResponseEntity<String> registerUser(@RequestBody SignUpDto signUpDto) {
        userService.registerUser(signUpDto);
        return new ResponseEntity<>("User registered successfully", HttpStatus.CREATED);
    }
}