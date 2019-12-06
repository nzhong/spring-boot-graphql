package com.learn.springboot_graphql.graphQL;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.learn.springboot_graphql.data.AllBlogs;
import com.learn.springboot_graphql.model.Article;
import com.learn.springboot_graphql.model.Blog;
import org.springframework.stereotype.Component;

@Component
public class ArticleResolver implements GraphQLResolver<Article> {

    public Blog getBlog(Article article) {
        return AllBlogs.getById(article.getBlogId());
    }

}
