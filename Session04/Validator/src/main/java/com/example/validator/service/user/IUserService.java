package com.example.validator.service.user;

import com.example.validator.model.dto.request.UserRequest;
import com.example.validator.model.entity.Users;
import org.springframework.stereotype.Service;

public interface IUserService {
    Users save(UserRequest userRequest);

}
