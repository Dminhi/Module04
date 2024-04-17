package com.example.exercise02.service;

import com.example.exercise02.model.Blog;
import com.example.exercise02.model.dto.request.BlogRequest;
import com.example.exercise02.model.dto.response.BlogResponse;
import com.example.exercise02.repository.IBlogRepo;
import com.example.exercise02.repository.ICategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogServiceImpl implements IBlogService{
    @Autowired
    private IBlogRepo blogRepo;
    @Autowired
    private ICategoryRepo categoryRepo;

    @Override
    public List<Blog> findAll() {
        return blogRepo.findAll();
    }

    @Override
    public Blog findById(Long id) {
        return blogRepo.findById(id).orElse(null);
    }

    @Override
    public Blog update(BlogRequest blogRequest, Long id) {
        Blog blog = blogRepo.findById(id).orElse(null);
        if(blog != null){
        blog.setBlogName(blogRequest.getBlogName());
        blog.setBlogContent(blogRequest.getBlogContent());
        blog.setCategory(categoryRepo.findById(blogRequest.getCategoryId()).orElse(null));}
        return blog;
    }

    @Override
    public Blog save(BlogRequest blogRequest) {
        Blog blog = new Blog();
        blog.setBlogName(blogRequest.getBlogName());
        blog.setBlogContent(blogRequest.getBlogContent());
        blog.setCategory(categoryRepo.findById(blogRequest.getCategoryId()).orElse(null));
        return blogRepo.save(blog);
    }

    @Override
    public void detele(Long id) {
        blogRepo.deleteById(id);
    }

    @Override
    public List<Blog> getAllByCategoryId(Long id) {
        return blogRepo.findAllByCategoryCategoryId(id);
    }
}
