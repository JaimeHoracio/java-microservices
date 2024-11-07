package com.tutorial.microservices.client_users.adapter.out.persistence.entities;

import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
public class PostUserId implements Serializable {

    private Long postId;
    private Long userId;

    public PostUserId (Long userId, Long postId) {
        this.userId = userId;
        this.postId = postId;
    }
}
