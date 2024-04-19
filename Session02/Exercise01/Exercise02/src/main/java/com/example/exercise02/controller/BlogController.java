package com.example.exercise02.controller;

import lombok.RequiredArgsConstructor;
import com.example.exercise02.module.Blog;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.exercise02.service.IBlogService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class BlogController {
    private final IBlogService blogService;
    @GetMapping
    public String Home(Model model){
        model.addAttribute("blog",blogService.findAll());
        return "blog";
    }
    @GetMapping("/add")
    public String add(Model model){
        model.addAttribute("blog",new Blog());
        return "add";
    }
    @PostMapping("/add")
    public String doAdd(@ModelAttribute Blog blog,Model model){
        blogService.save(blog);
        model.addAttribute("blog",blog);
        return "redirect:/";
    }
    @GetMapping("edit/{id}")
    public  String edit(@PathVariable Long id, Model model){
        model.addAttribute("blog",blogService.findById(id));
        return "edit";
    }
    @PostMapping("update")
    public String doUpdate(@ModelAttribute Blog blog){
        blogService.save(blog);
        return "redirect:/";
    }
    @GetMapping("delete/{id}")
    public  String delete(@PathVariable Long id){
        blogService.delete(id);
        return "redirect:/";
    }
}
