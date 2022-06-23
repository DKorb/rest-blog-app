package com.backend.blog.entity.user;

import com.backend.blog.entity.role.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private String name;

    private userDetails userDetails;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String username;

    private String email;

    private String password;

    private Set<Role> roles;

}