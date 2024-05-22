package com.codegym.blogjpa.service;

import com.codegym.blogjpa.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();

    void save(Blog blog);

    Blog findById(Long id);

    void remove(Long id);
}
