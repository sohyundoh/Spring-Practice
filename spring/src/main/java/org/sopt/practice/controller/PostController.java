package org.sopt.practice.controller;

import lombok.RequiredArgsConstructor;
import org.sopt.practice.common.dto.SuccessDataResponse;
import org.sopt.practice.common.dto.SuccessStatusResponse;
import org.sopt.practice.dto.PostCreateRequest;
import org.sopt.practice.dto.PostGetResponse;
import org.sopt.practice.dto.PostUpdateRequest;
import org.sopt.practice.exception.message.SuccessMessage;
import org.sopt.practice.service.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/api/v1/post")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping
    public ResponseEntity<SuccessStatusResponse> createPost(PostCreateRequest createRequest) {
        return ResponseEntity.created(URI.create("post/" + postService.createPost(createRequest)))
                .body(SuccessStatusResponse.of(SuccessMessage.POST_CREATE_SUCCESS));
    }


    @PutMapping("/{postId}")
    public ResponseEntity<SuccessStatusResponse> updatePost(@PathVariable Long postId, PostUpdateRequest updateRequest) {
        postService.updatePost(postId, updateRequest);
        return ResponseEntity.ok(SuccessStatusResponse.of(SuccessMessage.POST_UPDATE_SUCCESS));
    }

    @GetMapping("/{postId}")
    public ResponseEntity<SuccessDataResponse<PostGetResponse>> getPost(@PathVariable Long postId) {
        return ResponseEntity.ok(SuccessDataResponse.of(SuccessMessage.POST_GET_SUCCESS, postService.getPostById(postId)))
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<SuccessStatusResponse> deletePost(@PathVariable Long postId) {
        postService.deletePost(postId);
        return ResponseEntity.ok(SuccessStatusResponse.of(SuccessMessage.POST_DELETE_SUCCESS));
    }
}
