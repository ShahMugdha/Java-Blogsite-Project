package com.example.springboot3migrationswithflyway.service;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.springboot3migrationswithflyway.models.Post;

public interface PostService {
  List<Post> getPosts();
  Post createPost(Post post);
  ResponseEntity<Post> getPostByID(Long id);
  void deletePost(Long id);
  Post updatePost(Long id, Post post);
}
