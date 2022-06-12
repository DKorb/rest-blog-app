package com.backend.blog.service;

import com.backend.blog.dto.PostDto;
import org.springframework.stereotype.Service;

@Service
public interface PostService {
    PostDto createPost(PostDto postDto);
}
