package com.example.springboot3migrationswithflyway.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.example.springboot3migrationswithflyway.request.AccountRequest;
import com.example.springboot3migrationswithflyway.service.AccountService;

import jakarta.validation.Valid;

@RestController
public class AccountController {

  @Autowired
  private AccountService aService;

  @Autowired
  private PostRepository pRepository;

  @Autowired
  private AccountRepository aRepository;

  //Get all users

  @GetMapping("/account")
  public List<Account> getAccounts() {
    return aService.getAccounts();
  }

  //create user account
  @PostMapping("/account")
  public ResponseEntity<Account> createAccount(@Valid @RequestBody AccountRequest aRequest) {
    Account account = new Account(aRequest);
    account = aRepository.save(account);
    for(String s: aRequest.getPosts()) {
      Post p = new Post();
      p.setTitle(s);
      p.setAccount(account);
      pRepository.save(p);
    }
    return new ResponseEntity<Account>(aService.createAccount(account), HttpStatus.CREATED);
  }

  //update user account
  @PutMapping("/account/{accountID}")
  public Account updateAccount(@PathVariable("accountID") Long id, @RequestBody Account account) {
    account.setId(id);
    return aService.updateAccount(id, account);
  }
}
