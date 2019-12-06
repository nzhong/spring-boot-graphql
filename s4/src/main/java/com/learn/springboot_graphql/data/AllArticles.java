package com.learn.springboot_graphql.data;

import com.google.common.collect.ImmutableMap;
import com.learn.springboot_graphql.model.Article;
import com.learn.springboot_graphql.model.Author;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AllArticles {

    private static Map<Integer, Article> _allArticles;
    static {
        _allArticles = ImmutableMap.of(
                1, new Article(1, "John's View on VPC", "Bla bla bla", 1),
                2, new Article(2, "John's Opinion on Java", "Bla bla bla", 1),
                3, new Article(3, "John's Opinion on Javascript", "Bla bla bla", 1),
                4, new Article(4, "Jane's Personal Diary", "Bla bla bla", 2)
        );
    }

    public static List<Article> getAll() {
        return new ArrayList<Article>(_allArticles.values());
    }

    public static Article getById(Integer id) {
        return _allArticles.get(id);
    }
}
