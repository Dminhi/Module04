package com.example.demo.repository;

import com.example.demo.model.entity.User;

import java.util.List;


public interface IUserRepository {
    List<User> findAll();
    User findById(Long id);
    boolean save(User user);
    boolean delete(Long id);
}
