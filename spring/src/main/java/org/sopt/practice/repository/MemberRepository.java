package org.sopt.practice.repository;

import org.sopt.practice.domain.Member;
import org.sopt.practice.domain.Part;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {
    List<Member> findAllByPart(Part part);
}
