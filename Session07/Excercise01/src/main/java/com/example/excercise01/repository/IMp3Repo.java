package com.example.excercise01.repository;

import com.example.excercise01.module.Mp3;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IMp3Repo {
    List<Mp3> findAll();
    Mp3 findById(Long id);
    boolean save(Mp3 mp3);
    boolean delete(Long id);
}
