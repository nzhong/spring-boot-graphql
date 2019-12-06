package com.learn.springboot_graphql.graphQL;

import com.learn.springboot_graphql.data.AllArticles;
import com.learn.springboot_graphql.data.AllAuthors;
import com.learn.springboot_graphql.data.AllBlogs;
import com.learn.springboot_graphql.model.Article;
import com.learn.springboot_graphql.model.Author;
import com.learn.springboot_graphql.model.Blog;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;

import java.util.ArrayList;
import java.util.List;

@Component
public class Query implements GraphQLQueryResolver {

    public List<Article> articles() {
        return AllArticles.getAll();
    }

    public List<Author> authors() {
        return AllAuthors.getAll();
    }

    public List<Blog> blogs() {
        return AllBlogs.getAll();
    }

    public Author authorDtl(Integer id) {
        return AllAuthors.getById(id);
    }
}
