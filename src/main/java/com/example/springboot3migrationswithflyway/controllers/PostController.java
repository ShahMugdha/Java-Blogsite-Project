package com.example.springboot3migrationswithflyway.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot3migrationswithflyway.models.Post;
import com.example.springboot3migrationswithflyway.service.PostService;

import jakarta.validation.Valid;

@RestController
public class PostController {

  @Autowired
  private PostService pService;

  @GetMapping("/posts")
  public List<Post> getPosts() {
    return pService.getPosts();
  }

  @GetMapping("/posts/{postID}")
  public Post getPostByID(@PathVariable("postID") Long id) {
    return pService.getPostByID(id);
  }

  @PostMapping("/posts")
  public Post createPost(@Valid @RequestBody Post post) {
    return pService.createPost(post);
  }

  @PutMapping("/posts/{postID}")
  public Post updatePost(@PathVariable("postID") Long id, @RequestBody Post post) {
    post.setId(id);
    return pService.updatePost(id, post);
  }

  @DeleteMapping("/posts/{postID}")
  public void deletePost(@PathVariable("postID") Long id) {
    pService.deletePost(id);
  }
}