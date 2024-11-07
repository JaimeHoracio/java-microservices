package com.tutorial.microservices.client_users.adapter.in.web;

import com.tutorial.microservices.client_users.domain.Comment;
import com.tutorial.microservices.client_users.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/api/comment")
@RequiredArgsConstructor
public class CommentCtrl {

    private final CommentService commentService;

    @GetMapping("/{postId}/{commentId}")
    public ResponseEntity<Object> getCommentById(@PathVariable(name = "postId") Long postId,
                                                 @PathVariable(name = "commentId") Long commentId) {
        try {
            var result = commentService.getCommentById(postId, commentId);
            return ResponseEntity.ok(result);
        } catch (Exception ex) {
            return ResponseEntity.status(500).body(ex.getMessage());
        }
    }

    @GetMapping("/{idUser}/all")
    public ResponseEntity<Set<Comment>> getAllComment(@PathVariable(name = "idUser") Long idUser) {
        return ResponseEntity.ok(commentService.getAllComment(idUser));
    }

    @PostMapping
    public ResponseEntity<String> addComment(@RequestBody Comment comment) {
        try {
            commentService.addComment(comment);
            return ResponseEntity.ok("ok");
        } catch (Exception ex) {
            return ResponseEntity.status(500).body(ex.getMessage());
        }
    }

    @DeleteMapping("/{CommentId}")
    public ResponseEntity<String> removeComment(@PathVariable(name = "CommentId") Long commentId) {
        try {
            commentService.removeComment(commentId);
            return ResponseEntity.ok("ok");
        } catch (Exception ex) {
            return ResponseEntity.status(500).body(ex.getMessage());
        }
    }


}
