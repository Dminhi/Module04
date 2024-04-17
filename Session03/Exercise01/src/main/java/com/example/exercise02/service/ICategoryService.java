package com.example.exercise02.service;

import com.example.exercise02.model.Blog;
import com.example.exercise02.model.Category;
import com.example.exercise02.model.dto.request.BlogRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICategoryService {
    Category save(Category category);
    Category update(Category category, Long id);
    Category findById(Long id);
    List<Category> findAll();
    void detele(Long id);
}
