package com.tutorial.microservices.client_users.service;

import com.tutorial.microservices.client_users.domain.Post;
import com.tutorial.microservices.client_users.service.port.in.IPostIN;
import com.tutorial.microservices.client_users.service.port.out.IPostOUT;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class PostService implements IPostIN {

    private final IPostOUT postOUT;

    @Override
    public Post getPostById(Long userId, Long idPost) {
        return postOUT.getPostById(userId, idPost);
    }

    @Override
    public Set<Post> getAllPost(Long idUser) {
        return postOUT.getAllPost(idUser);
    }

    @Override
    //@Transactional(Transactional.TxType.REQUIRES_NEW)
    public void addPost(Post post) {
        if (!Objects.isNull(post)) {

            postOUT.addPost(post);
        } else {
            throw new IllegalArgumentException("El Post no puede ser null");
        }
    }

    @Override
    public void removePost(Long postId) {
        postOUT.removePost(Post.builder().id(postId).build());
    }

}
