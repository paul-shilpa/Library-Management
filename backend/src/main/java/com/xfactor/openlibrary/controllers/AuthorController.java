package com.xfactor.openlibrary.controllers;

//import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xfactor.openlibrary.domain.Author;
import com.xfactor.openlibrary.repositories.AuthorRepository;

@RestController
@RequestMapping("author")
public class AuthorController {

    private AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @PostMapping("/saveAuthor")
    public Author saveAuthor(@RequestBody Author author) {
        authorRepository.save(author);
        return author;
    }

    @GetMapping("/getAll")
    public List<Author> getAllAuthor() {
        return authorRepository.findAll();
    }

}