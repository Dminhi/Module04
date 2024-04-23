package com.example.securiry.service;

import com.example.securiry.model.dto.request.FormLogin;
import com.example.securiry.model.dto.request.FormRegister;
import com.example.securiry.model.dto.response.JWTResponse;

public interface IUserService {
    boolean register(FormRegister formRegister);
    JWTResponse login(FormLogin formLogin);

}
