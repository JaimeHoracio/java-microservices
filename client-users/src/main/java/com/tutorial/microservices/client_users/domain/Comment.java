package com.tutorial.microservices.client_users.domain;

import com.tutorial.microservices.client_users.adapter.out.persistence.entities.PostEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
public class Comment {

    private Long id;
    private String name;
    private String email;
    private String body;
    private Long postId;
}
