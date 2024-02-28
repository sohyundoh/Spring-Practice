package org.sopt.practice.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.sopt.practice.domain.Blog;
import org.sopt.practice.domain.Member;
import org.sopt.practice.dto.BlogCreateRequest;
import org.sopt.practice.exception.NotFoundException;
import org.sopt.practice.exception.message.ErrorMessage;
import org.sopt.practice.repository.BlogRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BlogService {

    private final BlogRepository blogRepository;
    private final MemberService memberService;


    @Transactional
    public void createBlog(BlogCreateRequest createRequest) {
        //member찾기
        Member member = memberService.findMemberById(createRequest.memberId());
        Blog blog = Blog.create(member, createRequest.title(), createRequest.description());
        blogRepository.save(blog);
    }

    public Blog findBlogById(Long blogId) {
        return blogRepository.findById(blogId).orElseThrow(
                () -> new NotFoundException(ErrorMessage.BLOG_NOT_FOUND_BY_ID_EXCEPTION)
        );
    }
}
