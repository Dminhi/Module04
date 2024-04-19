package com.example.validatesong.service;

import com.example.validatesong.model.dto.request.SongRequest;
import com.example.validatesong.model.entity.Song;

import java.util.List;

public interface ISongService {
    Song save(SongRequest songRequest);
    Song save(SongRequest songRequest,Long id);
    List<Song> findAll();
    Song findById(Long id);
}
