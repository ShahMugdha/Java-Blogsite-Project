package com.example.springboot3migrationswithflyway.service;
import java.util.List;

import com.example.springboot3migrationswithflyway.models.Account;

public interface AccountService {
  List<Account> getAccounts();
  Account createAccount(Account account);
  Account updateAccount(Long id, Account account);
}
