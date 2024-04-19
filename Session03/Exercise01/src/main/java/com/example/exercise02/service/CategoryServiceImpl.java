package com.example.exercise02.service;

import com.example.exercise02.model.Category;
import com.example.exercise02.repository.ICategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryService{
    @Autowired
    private ICategoryRepo categoryRepo;
    @Override
    public Category save(Category category) {
        return categoryRepo.save(category);
    }

    @Override
    public Category update(Category category, Long id) {
        if(findById(id)!=null){
            category.setCategoryId(id);
            return categoryRepo.save(category);
        }
        return null;
    }

    @Override
    public Category findById(Long id) {
        return categoryRepo.findById(id).orElse(null);
    }

    @Override
    public List<Category> findAll() {
        return categoryRepo.findAll();
    }

    @Override
    public void detele(Long id) {
        categoryRepo.deleteById(id);
    }
}
