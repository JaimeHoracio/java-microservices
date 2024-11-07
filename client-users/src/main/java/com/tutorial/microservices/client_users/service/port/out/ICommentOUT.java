package com.tutorial.microservices.client_users.service.port.out;

import com.tutorial.microservices.client_users.domain.Comment;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface ICommentOUT {

    Comment getCommentById(Long postId, Long idComment);

    Set<Comment> getAllComment(Long idUser);

    void addComment(Comment post);

    void removeComment(Comment post);

}
