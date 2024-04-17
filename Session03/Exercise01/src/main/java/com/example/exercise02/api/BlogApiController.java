package com.example.exercise02.api;

import com.example.exercise02.model.Blog;
import com.example.exercise02.model.dto.request.BlogRequest;
import com.example.exercise02.model.dto.response.BlogResponse;
import com.example.exercise02.repository.IBlogRepo;
import com.example.exercise02.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api.example.com/blog")
public class BlogApiController {
    @Autowired
    IBlogRepo blogRepo;
    @Autowired
    IBlogService blogService;
    @GetMapping
    public ResponseEntity<List<Blog>> getAll(){
        return new ResponseEntity<>(blogRepo.findAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Blog> getById(@PathVariable Long id){
       Blog blog = blogRepo.findById(id).orElseThrow(()->new RuntimeException("id not found"));
        return new ResponseEntity<>(blog,HttpStatus.OK);
    }
    @PostMapping ()
    public ResponseEntity<Blog> doAdd(@RequestBody BlogRequest blogRequest){
        Blog b = blogService.save(blogRequest);
        return ResponseEntity.ok(b);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Blog> doUpdate(@RequestBody Blog blog,@PathVariable Long id){
        blogRepo.findById(id).orElseThrow(() -> new RuntimeException("id not found"));
        blog.setBlogId(id);
        Blog b = blogRepo.save(blog);
        return ResponseEntity.ok(b);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> doDelete(@PathVariable Long id){
        blogRepo.findById(id).orElseThrow(() -> new RuntimeException("id not found"));
        blogRepo.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<List<Blog>>getBlogByCategoryId(@PathVariable Long id){
        return new ResponseEntity<>(blogRepo.findAllByCategoryCategoryId(id),HttpStatus.OK) ;
    }
}
