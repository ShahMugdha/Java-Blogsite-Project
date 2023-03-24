package com.example.springboot3migrationswithflyway.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot3migrationswithflyway.models.Account;
import com.example.springboot3migrationswithflyway.repository.AccountRepository;

@Service
//@Configuration
public class AccountServiceImpl implements AccountService {
  
  @Autowired
  private AccountRepository aRepository;

  @Override
  public List<Account> getAccounts() {
    return aRepository.findAll();
  }

  @Override
  public Account createAccount(Account account) {
    return aRepository.save(account);
  }

  @Override
  public Account updateAccount(Long id, Account account) {
    return aRepository.save(account);
  }
}
