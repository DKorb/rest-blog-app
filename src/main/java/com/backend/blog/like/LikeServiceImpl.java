package com.backend.blog.like;


import com.backend.blog.like.dto.LikeDTO;
import com.backend.blog.post.Post;
import com.backend.blog.post.PostService;
import com.backend.blog.user.User;
import com.backend.blog.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor(onConstructor = @__(@Lazy))
public class LikeServiceImpl implements LikeService {


    private final LikeRepository likeRepository;

    private final UserService userService;

    private final PostService postService;


    @Override
    public LikeDTO giveForPostById(String token, long post_id) {
        User user = getUser(token);
        Post post = getPost(post_id);

        Like like = likeRepository.save(buildLikeForPost(user, post));

        return LikeMapper.buildForPost(like);
    }

    private Like buildLikeForPost(User user, Post post) {
        return Like.builder()
                .user(user)
                .post(post)
                .build();
    }

    private User getUser(String token){
        return userService.currentLoggedUser(token);
    }

    private Post getPost(long id){
        return postService.getPost(id);
    }
}