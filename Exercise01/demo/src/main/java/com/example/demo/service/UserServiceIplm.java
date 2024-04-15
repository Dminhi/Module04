package com.example.demo.service;

import com.example.demo.model.entity.User;
import com.example.demo.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceIplm implements IUserService {
    private final IUserRepository userRepository;
    private final UploadService uploadService;
    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public boolean save(User user, MultipartFile multipartFile) {
        if(user.getUserId()==null){
            user.setSku(UUID.randomUUID().toString());
        } else {
            user.setImg(userRepository.findById(user.getUserId()).getImg());
        }
        if(multipartFile.getSize()>0){
            user.setImg(uploadService.uploadFileToServer(multipartFile));
        }
        return userRepository.save(user);
    }

    @Override
    public boolean delete(Long id) {
        return userRepository.delete(id);
    }
}
