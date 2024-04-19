package com.example.exercise02.service;

import com.example.exercise02.repository.IBlogRepo;
import lombok.RequiredArgsConstructor;
import com.example.exercise02.module.Blog;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogServiceIplm implements IBlogService{
    private final IBlogRepo blogService;

    @Override
    public List<Blog> findAll() {
        return blogService.findAll();
    }

    @Override
    public Blog findById(Long id) {
        return blogService.findById(id);
    }

    @Override
    public boolean save(Blog blog) {
        return blogService.save(blog);
    }

    @Override
    public boolean delete(Long id) {
        return blogService.delete(id);
    }
}
