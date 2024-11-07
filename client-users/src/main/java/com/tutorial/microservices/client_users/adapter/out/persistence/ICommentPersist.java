package com.tutorial.microservices.client_users.adapter.out.persistence;

import com.tutorial.microservices.client_users.adapter.out.persistence.entities.CommentEntity;
import com.tutorial.microservices.client_users.adapter.out.persistence.entities.CommentPostId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface ICommentPersist extends JpaRepository<CommentEntity, CommentPostId> {

    @Query("SELECT c FROM CommentEntity c WHERE c.commentPostId.postId = :postId")
    Set<CommentEntity> getAllCommentByPostId(Long postId);
}
