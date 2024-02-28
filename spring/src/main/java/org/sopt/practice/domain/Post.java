package org.sopt.practice.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.sopt.practice.dto.PostCreateRequest;
import org.sopt.practice.dto.PostUpdateRequest;

@Entity
@Getter
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String content;

    @ManyToOne
    private Blog blog;

    @Builder
    private Post(String title, String content, Blog blog) {
        this.title = title;
        this.content = content;
        this.blog = blog;
    }

    public static Post create(PostCreateRequest createRequest, Blog blog) {
        return new Post(createRequest.title(), createRequest.content(), blog);
    }

    public void update(PostUpdateRequest updateRequest) {
        this.title = title;
        this.content = content;
    }
}
