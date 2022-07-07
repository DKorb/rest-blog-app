package com.backend.blog.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.Embeddable;

@Embeddable
@lombok.Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class userDetails {

    private Integer age;

    private String city;

    @Type(type = "text")
    private String description;

}