package com.tutorial.microservices.client_users.service.port.in;

import com.tutorial.microservices.client_users.domain.Comment;

import java.util.Set;

public interface ICommentIN {

    Comment getCommentById(Long postId, Long idComment);

    Set<Comment> getAllComment(Long idUser);

    void addComment(Comment post);

    void removeComment(Long postId);

}
