package com.example.exercise02.repository;

import com.example.exercise02.module.Blog;

import java.util.List;

public interface IBlogRepo {
    List<Blog> findAll();
    Blog findById(Long id);
    boolean save(Blog blog);
    boolean delete(Long id);
}
