package com.codegym.blogjpa.repository;

import com.codegym.blogjpa.model.Blog;

import java.util.List;

public interface IBlogRepository {
    Blog findById(Long id);
    List<Blog> findAll();
    Blog findByTitle(String title);
    void remove(Long id);
    void save(Blog blog);
}
