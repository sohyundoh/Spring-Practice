package org.sopt.practice.service;

import lombok.RequiredArgsConstructor;
import org.sopt.practice.domain.Member;
import org.sopt.practice.domain.Part;
import org.sopt.practice.dto.MemberCreateRequest;
import org.sopt.practice.dto.MemberFindDto;
import org.sopt.practice.dto.MemberListFindDto;
import org.sopt.practice.exception.NotFoundException;
import org.sopt.practice.exception.message.ErrorMessage;
import org.sopt.practice.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public void createMember(
            MemberCreateRequest memberCreate
    ) {
        Member member = Member.create(memberCreate.name(), memberCreate.part(), memberCreate.age());
        memberRepository.save(member);
    }


    public Member findMemberById(
            Long memberId
    ) {
        return memberRepository.findById(memberId).orElseThrow(
                () -> new NotFoundException(ErrorMessage.MEMBER_NOT_FOUND_BY_ID_EXCEPTION)
        );
    }

    @Transactional
    public void deleteMember(
            Long memberId
    ) {
        memberRepository.delete(findMemberById(memberId));
    }

    public MemberFindDto getMemberById(
            Long memberId
    ) {
        return MemberFindDto.of(findMemberById(memberId));
    }

    public MemberListFindDto getMembersByPart(
            Part part
    ) {
        return MemberListFindDto.of(
                memberRepository.findAllByPart(part)
                        .stream().map(MemberFindDto::of)
                        .toList()
        );
    }


    @Transactional
    public void updatePartOfMember(
            Long memberId,
            Part part
    ) {
        findMemberById(memberId).updatePart(part);
    }
}
