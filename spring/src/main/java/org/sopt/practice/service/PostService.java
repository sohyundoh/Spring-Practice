package org.sopt.practice.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.sopt.practice.domain.Blog;
import org.sopt.practice.domain.Post;
import org.sopt.practice.dto.PostCreateRequest;
import org.sopt.practice.dto.PostGetResponse;
import org.sopt.practice.dto.PostUpdateRequest;
import org.sopt.practice.exception.NotFoundException;
import org.sopt.practice.exception.message.ErrorMessage;
import org.sopt.practice.repository.PostRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final BlogService blogService;

    @Transactional
    public Long createPost(PostCreateRequest createRequest) {
        Blog blog = blogService.findBlogById(createRequest.blogId());
        Post post = Post.create(createRequest, blog);
        postRepository.save(post);
        return post.getId();
    }

    @Transactional
    public void updatePost(Long postId ,PostUpdateRequest updateRequest) {
        findById(postId).update(updateRequest);
    }

    public PostGetResponse getPostById(Long postId) {
        return PostGetResponse.of(findById(postId));
    }

    private Post findById(Long postId) {
        return postRepository.findById(postId).orElseThrow(
                () -> new NotFoundException(ErrorMessage.POST_NOT_FOUND_BY_ID_EXCEPTION)
        );
    }

    @Transactional
    public void deletePost(Long postId) {
        postRepository.delete(findById(postId));
    }
}
