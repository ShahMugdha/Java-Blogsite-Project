package com.example.springboot3migrationswithflyway.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot3migrationswithflyway.models.Account;
import com.example.springboot3migrationswithflyway.models.Post;
import com.example.springboot3migrationswithflyway.repository.AccountRepository;
import com.example.springboot3migrationswithflyway.repository.PostRepository;
import com.example.springboot3migrationswithflyway.request.PostRequest;
import com.example.springboot3migrationswithflyway.service.PostService;

import jakarta.validation.Valid;

@RestController
public class PostController {

  @Autowired
  private PostService pService;

  @Autowired
  private PostRepository pRepository;

  @Autowired
  private AccountRepository aRepository;

  @GetMapping("/posts")
  public List<Post> getPosts() {
    return pService.getPosts();
  }

  @GetMapping("/posts/{postID}")
  public ResponseEntity<Post> getPostByID(@PathVariable("postID") Long id) {
    return pService.getPostByID(id);
  }

  @PostMapping("/posts")
  public ResponseEntity<Post> createPost(@Valid @RequestBody Post post) {
    return new ResponseEntity<Post>(pService.createPost(post), HttpStatus.CREATED) ;
  }

  @PutMapping("/posts/{postID}")
  public ResponseEntity<Post> updatePost(@PathVariable("postID") Long id, @RequestBody Post post) {
    post.setId(id);
    return new ResponseEntity<Post>(pService.updatePost(id, post), HttpStatus.OK);
  }

  @DeleteMapping("/posts/{postID}")
  public void deletePost(@PathVariable("postID") Long id) {
    pService.deletePost(id);
  }
}