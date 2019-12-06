package com.learn.springboot_graphql.data;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.learn.springboot_graphql.model.Blog;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AllBlogs {

    private static Map<Integer, Blog> _allBlogs;
    static {
        _allBlogs = ImmutableMap.of(
                1, new Blog(1, "John's Blog", 1),
                2, new Blog(2, "Jane's Blog", 2),
                3, new Blog(3, "Tom's Blog", 3),
                4, new Blog(4, "John's Blog", 1)
        );
    }

    public static List<Blog> getAll() {
        return new ArrayList<Blog>(_allBlogs.values());
    }

    public static Blog getById(Integer id) {
        return _allBlogs.get(id);
    }
}
