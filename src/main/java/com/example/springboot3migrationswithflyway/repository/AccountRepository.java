package com.example.springboot3migrationswithflyway.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springboot3migrationswithflyway.models.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

}
