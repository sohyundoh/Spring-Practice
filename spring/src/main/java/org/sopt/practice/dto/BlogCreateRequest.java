package org.sopt.practice.dto;

public record BlogCreateRequest(
        Long memberId,
        String title,
        String description
) {
}
