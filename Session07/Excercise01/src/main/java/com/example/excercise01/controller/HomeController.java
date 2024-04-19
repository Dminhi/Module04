package com.example.excercise01.controller;

import com.example.excercise01.service.IMp3Service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class HomeController {
    private final IMp3Service mp3Service;
    @GetMapping("")
    public String index(Model model){
        model.addAttribute("song",mp3Service.findAll());
        return "mp3";
    }
}
