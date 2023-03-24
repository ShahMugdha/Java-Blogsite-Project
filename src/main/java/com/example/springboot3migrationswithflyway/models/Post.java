package com.example.springboot3migrationswithflyway.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

import com.example.springboot3migrationswithflyway.request.PostRequest;

@Data
@Entity
@Getter
@Setter
@ToString
@Table(name="POST")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    @NotNull(message="Title should not be empty")
    @Column(columnDefinition = "TEXT", name = "TITLE")
    String title;

    @Column(columnDefinition = "TEXT", name = "BODY")
    String body;

    LocalDateTime createdAt;

    LocalDateTime updatedAt;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "account_id", referencedColumnName = "id", nullable = false)
    private Account account;
    /* public Post(PostRequest req) {
        this.title = req.getTitle();
    } */
}
