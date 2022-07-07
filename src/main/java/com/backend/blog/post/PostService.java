package com.backend.blog.post;

import com.backend.blog.post.dto.PostDto;
import com.backend.blog.post.dto.PostResponse;


public interface PostService {
    PostDto createPost(String token, PostDto postDto);

    PostResponse getAllPosts(int pageNo, int pageSize, String sortBy, String sortDir);

    PostDto getPostById(long id);

    PostDto updatePost(PostDto postDto, long id);

    void deletePostById(long id);

    String removeHeaderPrefix(String token);
}
