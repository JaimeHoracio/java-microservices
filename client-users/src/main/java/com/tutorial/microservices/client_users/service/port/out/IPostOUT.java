package com.tutorial.microservices.client_users.service.port.out;

import com.tutorial.microservices.client_users.domain.Post;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface IPostOUT {

    Post getPostById(Long userId, Long idPost);

    Set<Post> getAllPost(Long idUser);

    void addPost(Post post);

    void removePost(Post post);

}
