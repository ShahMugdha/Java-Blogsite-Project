package com.example.springboot3migrationswithflyway.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot3migrationswithflyway.models.Post;
import com.example.springboot3migrationswithflyway.repository.PostRepository;

@Service
public class PostServiceImpl implements PostService {
  
  @Autowired
  private PostRepository pRepository;

  @Override
  public List<Post> getPosts() {
    return pRepository.findAll();
  }

  @Override
  public Post createPost(Post post) {
    return pRepository.save(post);
  }

  @Override
  public Post getPostByID(Long id) {
    Optional<Post> post=pRepository.findById(id);
    if(post.isPresent()) return post.get();
    throw new RuntimeException("Post by this ID not found");
  }

  @Override
  public void deletePost(Long id) {
    pRepository.deleteById(id);
  }

  @Override
  public Post updatePost(Long id, Post post) {
    return pRepository.save(post);
  }
}