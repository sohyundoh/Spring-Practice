package org.sopt.practice.dto;

import java.util.List;

public record MemberListFindDto(
        List<MemberFindDto> memberFindDtoList
) {
    public static MemberListFindDto of(
            List<MemberFindDto> memberFindDtoList
    ) {
        return new MemberListFindDto(memberFindDtoList);
    }
}
