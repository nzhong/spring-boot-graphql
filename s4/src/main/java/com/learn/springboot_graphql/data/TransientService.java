package com.learn.springboot_graphql.data;

import com.learn.springboot_graphql.model.Article;
import com.learn.springboot_graphql.model.Author;
import com.learn.springboot_graphql.model.Blog;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransientService {

    public void addTransientValues(Blog blog) {
        Author author = AllAuthors.getById(blog.getAuthorId());
        blog.setAuthor(author);

        List<Article> articles = AllArticles.getAll().stream().filter(
            article -> article.getBlogId() == blog.getId()
        ).collect(Collectors.toList());
        blog.setArticles(articles);
    }

    public void addTransientValues(Article article) {
        Blog blog = AllBlogs.getById(article.getBlogId());

        Author author = AllAuthors.getById(blog.getAuthorId());
        blog.setAuthor(author);

        article.setBlog( blog );
    }

    public void addTransientValues(Author author) {
        List<Blog> blogs = AllBlogs.getAll().stream().filter(
            blog -> blog.getAuthorId() == author.getId()
        ).collect(Collectors.toList());

        author.setBlogs(blogs);
    }
}
