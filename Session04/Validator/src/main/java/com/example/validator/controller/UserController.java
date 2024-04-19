package com.example.validator.controller;

import com.example.validator.model.dto.request.UserRequest;
import com.example.validator.model.entity.Users;
import com.example.validator.service.user.IUserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping
public class UserController {
    @Autowired
    IUserService userService;
    @GetMapping
    public String add(Model model){
        model.addAttribute("userRequest",new UserRequest());
        return "index";
    }
    @PostMapping("/add")
    public String registerUser(@Valid  UserRequest userRequest, BindingResult bindingResult,Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("user",userRequest);
            return "index";
        }
        return "result";
    }
}
