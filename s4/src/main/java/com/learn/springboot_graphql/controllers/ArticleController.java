package com.learn.springboot_graphql.controllers;

import com.learn.springboot_graphql.data.AllArticles;
import com.learn.springboot_graphql.data.TransientService;
import com.learn.springboot_graphql.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    TransientService transientSvc;

    @RequestMapping("/all")
    public List<Article> getAll() {
        return AllArticles.getAll();
    }

    @RequestMapping("/dtl0/{id}")
    public Article getDetail0(@PathVariable int id) {
        return AllArticles.getById(id);
    }

    @RequestMapping("/dtl/{id}")
    public Article getDetail(@PathVariable int id) {
        Article article = AllArticles.getById(id);
        transientSvc.addTransientValues(article);
        return article;
    }
}
