package org.sopt.practice.controller;


import lombok.RequiredArgsConstructor;
import org.sopt.practice.domain.Part;
import org.sopt.practice.dto.MemberCreateDto;
import org.sopt.practice.dto.MemberFindDto;
import org.sopt.practice.dto.MemberListFindDto;
import org.sopt.practice.service.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/member")
public class MemberController {

    private final MemberService memberService;

    @PostMapping
    public void postMember(
            @RequestBody MemberCreateDto memberCreate
    ) {
        memberService.createMember(memberCreate);
    }

    @GetMapping("/{memberId}")
    public ResponseEntity<MemberFindDto> getMemberById(
            @PathVariable Long memberId
    ) {
        return ResponseEntity.ok(memberService.getMemberById(memberId));
    }

    @GetMapping
    public ResponseEntity<MemberListFindDto> getMembersByPart(
            @RequestParam Part part
    ) {
        return ResponseEntity.ok(memberService.getMembersByPart(part));
    }

    @PutMapping("/{memberId}")
    public void putMemberPart(
            @PathVariable Long memberId,
            @RequestParam Part part
    ) {
        memberService.updatePartOfMember(memberId, part);
    }

    @DeleteMapping("/{memberId}")
    public void deleteMember(
            @PathVariable Long memberId
    ) {
        memberService.deleteMember(memberId);
    }
}
