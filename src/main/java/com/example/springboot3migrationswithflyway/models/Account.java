package com.example.springboot3migrationswithflyway.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

import com.example.springboot3migrationswithflyway.request.AccountRequest;


@Data
@Entity
@Getter
@Setter
@ToString
@Table(name="ACCOUNT")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    @Email(message="please provide a valid email id")
    String email;

    @NotNull(message="name is required")
    String name;

    LocalDateTime created_at;

    LocalDateTime updated_at;

    @OneToMany(mappedBy = "account")
    private List<Post> posts;
    public Account(AccountRequest req) {
        this.name = req.getName();
    }
}
