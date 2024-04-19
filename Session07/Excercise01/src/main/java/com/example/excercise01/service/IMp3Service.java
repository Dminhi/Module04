package com.example.excercise01.service;

import com.example.excercise01.module.Mp3;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IMp3Service {
    List<Mp3> findAll();
    Mp3 findById(Long id);
    boolean save(Mp3 product, MultipartFile file);
    boolean delete(Long id);
}
