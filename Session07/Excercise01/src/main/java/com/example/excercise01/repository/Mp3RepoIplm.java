package com.example.excercise01.repository;

import com.example.excercise01.module.Mp3;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
@Repository
@Transactional
public class Mp3RepoIplm implements IMp3Repo{
    @PersistenceContext
    EntityManager entityManager;
    @Override
    public List<Mp3> findAll() {
        return entityManager.createQuery("from Mp3", Mp3.class).getResultList();
    }

    @Override
    public Mp3 findById(Long id) {
        return entityManager.find(Mp3.class,id);
    }

    @Override
    public boolean save(Mp3 mp3) {
        if (mp3.getId()==null){
            // them moi
            entityManager.persist(mp3);
        }else {
            // cap nhat
            entityManager.merge(mp3);
        }
        return true;
    }

    @Override
    public boolean delete(Long id) {
        entityManager.remove(findById(id));
        return true;
    }
}
