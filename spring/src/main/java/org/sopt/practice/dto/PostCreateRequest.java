package org.sopt.practice.dto;

public record PostCreateRequest(
        Long blogId,
        String title,
        String content

) {
}
