package com.example.demo.controller;

import com.example.demo.model.entity.User;
import com.example.demo.service.IUserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final IUserService userService;
    @GetMapping("/list")
    public String index(Model model){
        model.addAttribute("list",userService.findAll());
        return "list";
    }
    @GetMapping("/add")
    public String add(Model model){
        model.addAttribute("user",new User());
        return "/add";
    }
    @PostMapping("/add")
    public String doAdd(@Valid @ModelAttribute User user , @RequestParam MultipartFile file, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("user",user);
            return "add";
        }
        userService.save(user,file);
        return "redirect:/user/list";
    }
    @GetMapping("/edit/{id}")
    public String edit(Model model,@PathVariable Long id){
        model.addAttribute("user",userService.findById(id));
        return "/edit";
    }
    @PostMapping("/update")
    public String doUpdate(@ModelAttribute User user, @RequestParam MultipartFile file){
        userService.save(user,file);
        return "redirect:/user/list";
    }
    @GetMapping("/delete/{id}")
    public  String delete(@PathVariable Long id){
        userService.delete(id);
        return "redirect:/user/list";
    }

}
