package com.tutorial.microservices.client_users.adapter.in.web;

import com.tutorial.microservices.client_users.domain.Post;
import com.tutorial.microservices.client_users.service.PostService;
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
@RequestMapping("/api/post")
@RequiredArgsConstructor
public class PostCtrl {

    private final PostService postService;

    @GetMapping("/{userId}/{postId}")
    public ResponseEntity<Object> getPostById(@PathVariable(name = "userId") Long userId,
                                              @PathVariable(name = "postId") Long postId) {
        try {
            var result = postService.getPostById(userId, postId);
            return ResponseEntity.ok(result);
        } catch (Exception ex) {
            return ResponseEntity.status(500).body(ex.getMessage());
        }
    }

    @GetMapping("/{idUser}/all")
    public ResponseEntity<Set<Post>> getAllPost(@PathVariable(name = "idUser") Long idUser) {
        return ResponseEntity.ok(postService.getAllPost(idUser));
    }

    @PostMapping
    public ResponseEntity<String> addPost(@RequestBody Post post) {
        try {
            postService.addPost(post);
            return ResponseEntity.ok("ok");
        } catch (Exception ex) {
            return ResponseEntity.status(500).body(ex.getMessage());
        }
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<String> removePost(@PathVariable(name = "postId") Long postId) {
        try {
            postService.removePost(postId);
            return ResponseEntity.ok("ok");
        } catch (Exception ex) {
            return ResponseEntity.status(500).body(ex.getMessage());
        }
    }


}
