package com.example.exercise02.service;

import com.example.exercise02.model.Blog;
import com.example.exercise02.model.dto.request.BlogRequest;

import java.util.List;
import java.util.Optional;

public interface IBlogService{
    Blog save(BlogRequest blogRequest);
    Blog update(BlogRequest blogRequest, Long id);
    Blog findById(Long id);
    List<Blog> findAll();
    void detele(Long id);
    List<Blog> getAllByCategoryId(Long categoryId);
}
