package com.example.validator.service.user;

import com.example.validator.model.dto.request.UserRequest;
import com.example.validator.model.entity.Users;
import com.example.validator.repository.user.UserRepository;
import org.apache.catalina.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceIplm implements IUserService{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public Users save(UserRequest userRequest) {
        Users users = modelMapper.map(userRequest,Users.class);
        return userRepository.save(users);
    }
}
