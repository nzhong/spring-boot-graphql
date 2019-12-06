package com.learn.springboot_graphql.data;

import com.google.common.collect.ImmutableMap;
import com.learn.springboot_graphql.model.Author;
import com.learn.springboot_graphql.model.Blog;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AllAuthors {

    private static Map<Integer, Author> _allAuthors;
    static {
        _allAuthors = ImmutableMap.of(
                1, new Author(1, "John Doe", "M"),
                2, new Author(2, "Jane Doe", "F"),
                3, new Author(3, "Tom Smith", "M")
        );
    }

    public static List<Author> getAll() {
        return new ArrayList<Author>(_allAuthors.values());
    }

    public static Author getById(Integer id) {
        return _allAuthors.get(id);
    }
}
