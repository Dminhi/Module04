package com.example.validatesong.service;

import com.example.validatesong.model.dto.request.SongRequest;
import com.example.validatesong.model.entity.Song;
import com.example.validatesong.repository.SongRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class SongSeviceIplm implements ISongService {
    @Autowired
    SongRepo songRepo;
    @Autowired
    ModelMapper modelMapper;
    @Override
    public Song save(SongRequest songRequest) {
        Song song = modelMapper.map(songRequest,Song.class);
        return songRepo.save(song);
    }

    @Override
    public Song save(SongRequest songRequest, Long id) {
        Song song = songRepo.findById(id).orElseThrow(() -> new NoSuchElementException("ko ton tai id"));
        song.setSongName(songRequest.getSongName());
        song.setCategory(songRequest.getCategory());
        song.setSinger(songRequest.getSinger());
        return songRepo.save(song);
    }

    @Override
    public List<Song> findAll() {
        return songRepo.findAll();
    }

    @Override
    public Song findById(Long id) {
        return songRepo.findById(id).orElseThrow(()->new NoSuchElementException("khong ton tai id"));
    }
}
