package com.tutorial.microservices.client_users.service.port.in;

import com.tutorial.microservices.client_users.domain.Post;

import java.util.Set;

public interface IPostIN {

    Post getPostById(Long userId, Long idPost);

    Set<Post> getAllPost(Long idUser);

    void addPost(Post post);

    void removePost(Long postId);

}
