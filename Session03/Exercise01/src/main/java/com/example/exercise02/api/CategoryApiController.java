package com.example.exercise02.api;

import com.example.exercise02.model.Blog;
import com.example.exercise02.model.Category;
import com.example.exercise02.model.dto.request.BlogRequest;
import com.example.exercise02.repository.IBlogRepo;
import com.example.exercise02.repository.ICategoryRepo;
import com.example.exercise02.service.IBlogService;
import com.example.exercise02.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api.example.com/category")
public class CategoryApiController {
    @Autowired
    ICategoryRepo categoryRepo;
    @Autowired
    ICategoryService categoryService;
    @GetMapping
    public ResponseEntity<List<Category>> getAll(){
        return new ResponseEntity<>(categoryRepo.findAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Category> getById(@PathVariable Long id){
        Category category = categoryRepo.findById(id).orElseThrow(()->new RuntimeException("id not found"));
        return new ResponseEntity<>(category,HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Category> doAdd(@RequestBody Category category){
        Category c = categoryService.save(category);
        return ResponseEntity.ok(c);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Category> doUpdate(@RequestBody Category category,@PathVariable Long id){
        categoryRepo.findById(id).orElseThrow(() -> new RuntimeException("id not found"));
        category.setCategoryId(id);
        Category c = categoryRepo.save(category);
        return ResponseEntity.ok(c);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> doDelete(@PathVariable Long id){
        categoryRepo.findById(id).orElseThrow(() -> new RuntimeException("id not found"));
        categoryRepo.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
