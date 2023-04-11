package com.xfactor.openlibrary.controllers;

//import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xfactor.openlibrary.domain.Publisher;
import com.xfactor.openlibrary.repositories.PublisherRepository;

@RestController
@RequestMapping("publisher")
public class PublisherController {

    private PublisherRepository publisherRepository;

    public PublisherController(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    @PostMapping("/savePublisher")
    public Publisher savePublisher(@RequestBody Publisher publisher) {
        publisherRepository.save(publisher);
        return publisher;
    }

    @GetMapping("/getAll")
    public List<Publisher> getAllPublisher() {
        return publisherRepository.findAll();
    }

}