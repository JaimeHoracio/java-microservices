package com.tutorial.microservices.client_users.service;

import com.tutorial.microservices.client_users.domain.Comment;
import com.tutorial.microservices.client_users.service.port.in.ICommentIN;
import com.tutorial.microservices.client_users.service.port.out.ICommentOUT;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class CommentService implements ICommentIN {

    private final ICommentOUT commentOUT;

    @Override
    public Comment getCommentById(Long postId, Long idComment) {
        return commentOUT.getCommentById(postId, idComment);
    }

    @Override
    public Set<Comment> getAllComment(Long idUser) {
        return commentOUT.getAllComment(idUser);
    }

    @Override
    public void addComment(Comment comment) {
        if (!Objects.isNull(comment)) {
            commentOUT.addComment(comment);
        } else {
            throw new IllegalArgumentException("El Comment no puede ser null");
        }
    }

    @Override
    public void removeComment(Long commentId) {
        commentOUT.removeComment(Comment.builder().id(commentId).build());
    }

}
