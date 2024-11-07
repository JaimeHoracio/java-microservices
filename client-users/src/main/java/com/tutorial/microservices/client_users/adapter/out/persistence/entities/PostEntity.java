package com.tutorial.microservices.client_users.adapter.out.persistence.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;
import java.util.Set;

@Data
@Entity
@Table(name = "post")
@NoArgsConstructor
@AllArgsConstructor
public class PostEntity {

    @EmbeddedId
    private PostUserId postUserId = new PostUserId();
    private String title;
    private String body;

//    @ManyToOne(fetch = FetchType.LAZY)
//    private UserEntity user;

    //@OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<CommentEntity> comments;

}
