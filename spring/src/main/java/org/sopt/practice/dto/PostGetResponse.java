package org.sopt.practice.dto;

import org.sopt.practice.domain.Post;

public record PostGetResponse(
        String title,
        String content
) {

    public static PostGetResponse of(
            Post post
    ) {
        return new PostGetResponse(post.getTitle(), post.getContent());
    }
}
