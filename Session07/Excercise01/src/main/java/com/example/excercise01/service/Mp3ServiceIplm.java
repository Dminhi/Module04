package com.example.excercise01.service;

import com.example.excercise01.module.Mp3;
import com.example.excercise01.repository.IMp3Repo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RequiredArgsConstructor
@Service
public class Mp3ServiceIplm implements IMp3Service{
    private final IMp3Repo mp3Repo;
    private final UploadService uploadService;

    @Override
    public List<Mp3> findAll() {
        return mp3Repo.findAll();
    }

    @Override
    public Mp3 findById(Long id) {
        return mp3Repo.findById(id);
    }

    @Override
    public boolean save(Mp3 mp3, MultipartFile file) {
        if (file.getSize() > 0) {
            mp3.setLinkFile(uploadService.uploadFileToServer(file));
        }
        mp3Repo.save(mp3);
        return true;
    }

    @Override
    public boolean delete(Long id) {
        mp3Repo.delete(id);
        return true;
    }
}
