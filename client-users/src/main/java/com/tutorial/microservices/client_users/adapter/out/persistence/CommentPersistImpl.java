package com.tutorial.microservices.client_users.adapter.out.persistence;

import com.tutorial.microservices.client_users.adapter.map.CommentMap;
import com.tutorial.microservices.client_users.adapter.out.persistence.entities.CommentPostId;
import com.tutorial.microservices.client_users.domain.Comment;
import com.tutorial.microservices.client_users.service.port.out.ICommentOUT;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
@RequiredArgsConstructor
public class CommentPersistImpl implements ICommentOUT {

    private final ICommentPersist commentPersist;

    @Override
    public Comment getCommentById(Long postId, Long commentId) {
        var post = commentPersist.findById(new CommentPostId(postId, commentId));
        if (post.isPresent()) {
            return CommentMap.INSTANCE.convertToDomain(post.get());
        } else {
            throw new EntityNotFoundException(
                    String.format("No se encontró Comment con identicador: %s - %s", postId, commentId));
        }
    }

    @Override
    public Set<Comment> getAllComment(Long postId) {
        return CommentMap.INSTANCE.convertToSetDomain(commentPersist.getAllCommentByPostId(postId));
    }

    @Override
    public void addComment(Comment post) {
        commentPersist.save(CommentMap.INSTANCE.convertToEntity(post));
    }

    @Override
    public void removeComment(Comment post) {
        commentPersist.delete(CommentMap.INSTANCE.convertToEntity(post));
    }

}
