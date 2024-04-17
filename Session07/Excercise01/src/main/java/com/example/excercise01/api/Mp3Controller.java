package com.example.excercise01.api;

import com.example.excercise01.module.Mp3;
import com.example.excercise01.repository.IMp3Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api.example.com/mp3")
public class Mp3Controller {
    // Trả về danh sách bài hát
    @Autowired
    private IMp3Repo mp3Repo;
    @GetMapping
    public ResponseEntity<List<Mp3>>getAll(){
        return new ResponseEntity<>(mp3Repo.findAll(), HttpStatus.OK);
    }

}
