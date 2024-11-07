package com.tutorial.microservices.client_users.adapter.out.persistence.entities;

import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
public class CommentPostId implements Serializable {

    private Long commentId;
    private Long postId;

    public CommentPostId(Long postId, Long commentId) {
        this.postId = postId;
        this.commentId = commentId;
    }

}
