package com.example.excercise01.controller;

import com.example.excercise01.module.Mp3;
import com.example.excercise01.service.IMp3Service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/mp3")
@RequiredArgsConstructor
public class Mp3Controller {
    private final IMp3Service mp3Service;
    @GetMapping("/list")
    public String list(Model model){
        model.addAttribute("song",mp3Service.findAll());
        return "mp3";
    }
    @GetMapping("/add")
    public String add(Model model){
        model.addAttribute("mp3",new Mp3());
        return "add";
    }
    @PostMapping("/add")
    public String doAdd(@ModelAttribute Mp3 mp3,@RequestParam MultipartFile file){
        mp3Service.save(mp3,file);
        return "redirect:/mp3/list";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        mp3Service.delete(id);
        return "redirect:/mp3/list";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id,Model model){
        model.addAttribute("song",mp3Service.findById(id));
        return "edit";
    }
    @PostMapping("/update")
    public String update(@ModelAttribute Mp3 song,@RequestParam MultipartFile file){
        mp3Service.save(song,file);
        return "redirect:/mp3/list";
    }
}
