package org.sopt.practice.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Member member;

    private String title;

    private String description;

    @Builder
    private Blog(Member member, String title, String description) {
        this.member = member;
        this.title = title;
        this.description = description;
    }

    public static Blog create(
            Member member,
            String title,
            String description
    ) {
        return Blog.builder().member(member).title(title).description(description).build();
    }
}
