package com.learn.springboot_graphql.controllers;

import com.learn.springboot_graphql.data.AllAuthors;
import com.learn.springboot_graphql.data.TransientService;
import com.learn.springboot_graphql.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    TransientService transientSvc;

    @RequestMapping("/all")
    public List<Author> getAll() {
        return AllAuthors.getAll();
    }

    @RequestMapping("/dtl0/{id}")
    public Author getDetail0(@PathVariable int id) {
        return AllAuthors.getById(id);
    }

    @RequestMapping("/dtl/{id}")
    public Author getDetail(@PathVariable int id) {
        Author author = AllAuthors.getById(id);
        transientSvc.addTransientValues(author);
        return author;
    }
}
