package com.backend.blog.service.post;

import com.backend.blog.dto.post.PostDto;
import com.backend.blog.dto.post.PostResponse;
import org.springframework.stereotype.Service;


@Service
public interface PostService {
    PostDto createPost(PostDto postDto);

    PostResponse getAllPosts(int pageNo, int pageSize, String sortBy, String sortDir);

    PostDto getPostById(long id);

    PostDto updatePost(PostDto postDto, long id);

    void deletePostById(long id);
}
