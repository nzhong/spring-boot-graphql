package com.learn.springboot_graphql.graphQL;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.learn.springboot_graphql.data.AllArticles;
import com.learn.springboot_graphql.data.AllAuthors;
import com.learn.springboot_graphql.model.Article;
import com.learn.springboot_graphql.model.Author;
import com.learn.springboot_graphql.model.Blog;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AuthorResolver implements GraphQLResolver<Author> {

    public List<Article> topArticles(Author author) {
        return AllArticles.getAll();
    }
}
