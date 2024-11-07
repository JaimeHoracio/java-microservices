package com.tutorial.microservices.client_users.adapter.out.persistence;

import com.tutorial.microservices.client_users.adapter.map.PostMap;
import com.tutorial.microservices.client_users.adapter.out.persistence.entities.PostUserId;
import com.tutorial.microservices.client_users.domain.Post;
import com.tutorial.microservices.client_users.service.port.out.IPostOUT;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
@RequiredArgsConstructor
public class PostPersistImpl implements IPostOUT {

    private final IPostPersist postPersist;

    @Override
    public Post getPostById(Long userId, Long idPost) {
        var postUserId = new PostUserId(userId, idPost);
        var post = postPersist.findById(postUserId);
        if (post.isPresent()) {
            return PostMap.INSTANCE.convertToDomain(post.get());
        } else {
            throw new EntityNotFoundException(String.format("No se encontró Post con identicador: %s", idPost));
        }
    }

    @Override
    public Set<Post> getAllPost(Long idUser) {
        return PostMap.INSTANCE.convertToSetDomain(postPersist.getAllPostByUserId(idUser));
    }

    @Override
    public void addPost(Post post) {
        postPersist.save(PostMap.INSTANCE.convertToEntity(post));
    }

    @Override
    public void removePost(Post post) {
        postPersist.delete(PostMap.INSTANCE.convertToEntity(post));
    }

}
