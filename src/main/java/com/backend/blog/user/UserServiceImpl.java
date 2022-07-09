package com.backend.blog.user;

import com.backend.blog.security.JWTTokenProvider;
import com.backend.blog.security.dto.SignUpDTO;
import com.backend.blog.role.Role;
import com.backend.blog.user.dto.UserDTO;
import com.backend.blog.exception.EmailInUseException;
import com.backend.blog.exception.LoginInUseException;
import com.backend.blog.role.RoleRepository;
import com.backend.blog.utils.AppConstants;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private static final String CITY = "Default value";
    private static final String DESCRIPTION = "Default value";

    private PasswordEncoder passwordEncoder;

    private UserRepository userRepository;

    private RoleRepository roleRepository;

    private ModelMapper modelMapper;

    private JWTTokenProvider jwtTokenProvider;


    @Override
    public UserDTO registerUser(SignUpDTO signUpDto) {
        var email = signUpDto.getEmail();

        if (userRepository.existsByEmail(email)) {
            throw new EmailInUseException(email);
        }

        var login = signUpDto.getUsername();

        if (userRepository.existsByUsername(login)) {
            throw new LoginInUseException(login);
        }

        User user = User.builder()
                .name(signUpDto.getName())
                .username(signUpDto.getUsername())
                .email(signUpDto.getEmail())
                .password(passwordEncoder.encode(signUpDto.getPassword()))
                .gender(signUpDto.getGender())
                .userDetails(userDetails.builder()
                        .age(signUpDto.getAge())
                        .city(CITY)
                        .description(DESCRIPTION)
                        .build())
                .build();

        Role role = roleRepository.findByName(AppConstants.ROLE_PREFIX + "USER").get();
        user.setRoles(Collections.singleton(role));

        userRepository.save(user);

        return modelMapper.map(user, UserDTO.class);
    }

    @Override
    public User currentLoggedUser(String token) {
        String email = jwtTokenProvider.getUsernameFromJwt(token);
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(email));
    }
}