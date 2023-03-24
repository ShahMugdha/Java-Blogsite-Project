package com.example.springboot3migrationswithflyway.request;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountRequest {
  private String name;
  private String email;
  private List<String> posts;
}
