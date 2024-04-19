package com.example.validatesong.controller;

import com.example.validatesong.model.dto.request.SongEditRequest;
import com.example.validatesong.model.dto.request.SongRequest;
import com.example.validatesong.model.entity.Song;
import com.example.validatesong.repository.SongRepo;
import com.example.validatesong.service.ISongService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping
public class SongController {
    @Autowired
    ISongService songService;
    @GetMapping
    public String list(Model model){
        model.addAttribute("song",songService.findAll());
        return "list";
    }
    @GetMapping("/add")
    public String add(Model model){
        model.addAttribute("songRequest",new SongRequest());
        return "add";
    }
    @PostMapping("/add")
    public String doAdd(@ModelAttribute @Valid SongRequest songRequest, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "add";
        }
        songService.save(songRequest);
        return "redirect:/";
    }
    @GetMapping("update/{id}")
    public String edit(Model model, @PathVariable Long id){
        model.addAttribute("songRequest",songService.findById(id));
        return "update";
    }
    @PostMapping("/update")
    public String update(@ModelAttribute @Valid SongRequest songRequest, BindingResult bindingResult, Model model){

        if(bindingResult.hasErrors()){
            return "update";
        }
        songService.save(songRequest);
        return "redirect:/";
    }
}
