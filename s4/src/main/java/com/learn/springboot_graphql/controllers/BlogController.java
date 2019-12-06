package com.learn.springboot_graphql.controllers;

import com.google.common.collect.ImmutableList;
import com.learn.springboot_graphql.data.AllBlogs;
import com.learn.springboot_graphql.data.TransientService;
import com.learn.springboot_graphql.model.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    TransientService transientSvc;

    @RequestMapping("/all")
    public List<Blog> getAll() {
        return AllBlogs.getAll();
    }

    @RequestMapping("/dtl0/{id}")
    public Blog getDetail0(@PathVariable int id) {
        return AllBlogs.getById(id);
    }

    @RequestMapping("/dtl/{id}")
    public Blog getDetail(@PathVariable int id) {
        Blog blog = AllBlogs.getById(id);
        transientSvc.addTransientValues(blog);
        return blog;
    }

}
