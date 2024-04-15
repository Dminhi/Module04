package com.example.demo.service;

import com.example.demo.model.entity.User;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IUserService {
    List<User> findAll();
    User findById(Long id);
    boolean save(User user, MultipartFile multipartFile);
    boolean delete(Long id);
}
