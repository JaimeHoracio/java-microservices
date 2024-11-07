package com.tutorial.microservices.client_users.adapter.out.persistence;

import com.tutorial.microservices.client_users.adapter.out.persistence.entities.PostEntity;
import com.tutorial.microservices.client_users.adapter.out.persistence.entities.PostUserId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface IPostPersist extends JpaRepository<PostEntity, PostUserId> {

    @Query("SELECT p FROM PostEntity p WHERE p.postUserId.userId = :idUser")
    Set<PostEntity> getAllPostByUserId(Long idUser);
}
