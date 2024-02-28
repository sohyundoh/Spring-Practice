package org.sopt.practice.controller;

import lombok.RequiredArgsConstructor;
import org.sopt.practice.common.dto.SuccessDataResponse;
import org.sopt.practice.common.dto.SuccessStatusResponse;
import org.sopt.practice.dto.BlogCreateRequest;
import org.sopt.practice.exception.message.SuccessMessage;
import org.sopt.practice.service.BlogService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/blog")
@RequiredArgsConstructor
public class BlogController {

    private final BlogService blogService;

    @PostMapping
    public SuccessStatusResponse createBlog(BlogCreateRequest blogCreateRequest) {
        blogService.createBlog(blogCreateRequest);
        return SuccessStatusResponse.of(SuccessMessage.BLOG_CREATE_SUCCESS);
    }
}
