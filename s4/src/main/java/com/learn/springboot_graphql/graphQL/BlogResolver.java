package com.learn.springboot_graphql.graphQL;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.learn.springboot_graphql.data.AllAuthors;
import com.learn.springboot_graphql.data.AllBlogs;
import com.learn.springboot_graphql.model.Article;
import com.learn.springboot_graphql.model.Author;
import com.learn.springboot_graphql.model.Blog;
import org.springframework.stereotype.Component;

@Component
public class BlogResolver implements GraphQLResolver<Blog> {

    public Author getAuthor(Blog blog) {
        return AllAuthors.getById(blog.getAuthorId());
    }

}