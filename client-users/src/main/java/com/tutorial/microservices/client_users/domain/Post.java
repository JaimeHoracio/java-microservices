package com.tutorial.microservices.client_users.domain;

import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class Post {
    private Long id;
    private String title;
    private String body;
    private Long userId;
    private Set<Comment> comments;

}
