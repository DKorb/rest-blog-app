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
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private static final String CITY = "Default value";
    private static final String DESCRIPTION = "Default value";

    private static final Integer AGE = 18;

    private final PasswordEncoder passwordEncoder;

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

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


        var user = userRepository.save(buildUser(
                signUpDto.getName(),
                signUpDto.getUsername(),
                signUpDto.getEmail(),
                signUpDto.getPassword(),
                signUpDto.getGender()));

        return mapFromUser(user);
    }

    private User buildUser(String name,
                           String username,
                           String email,
                           String password,
                           Gender gender) {
        Role role = roleRepository.findByName(AppConstants.ROLE_PREFIX + "USER");
        return User.builder()
                .name(name)
                .username(username)
                .email(email)
                .password(passwordEncoder.encode(password))
                .gender(gender)
                .userDetails(UserDetails.builder()
                        .age(AGE)
                        .city(CITY)
                        .description(DESCRIPTION)
                        .build())
                .roles(Collections.singleton(role))
                .build();
    }

    private UserDTO mapFromUser(User user) {
        return UserMapper.mapUserDTOFromUser(user);
    }

    @Override
    public User currentLoggedUser(String token) {
        String email = jwtTokenProvider.getUsernameFromJwt(token);
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(email));
    }
}