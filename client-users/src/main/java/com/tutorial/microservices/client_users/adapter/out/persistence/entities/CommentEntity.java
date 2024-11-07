package com.tutorial.microservices.client_users.adapter.out.persistence.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Table(name = "comment")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CommentEntity {

    @EmbeddedId
    private CommentPostId commentPostId = new CommentPostId();
    private String name;
    private String email;
    private String body;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @MapsId("postId") // Mapea el campo postId de CommentPostId a la FK
//    private PostEntity post;
}
