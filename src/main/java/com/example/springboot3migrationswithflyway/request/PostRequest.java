package com.example.springboot3migrationswithflyway.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostRequest {
  private String title;
  private String body;
}
