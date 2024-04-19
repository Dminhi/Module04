package com.example.validatesong.repository;

import com.example.validatesong.model.entity.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepo extends JpaRepository<Song,Long> {
}
