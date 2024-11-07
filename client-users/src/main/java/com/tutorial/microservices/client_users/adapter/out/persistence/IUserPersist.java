package com.tutorial.microservices.client_users.adapter.out.persistence;

import com.tutorial.microservices.client_users.adapter.out.persistence.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserPersist extends JpaRepository<UserEntity, Long> {
}
