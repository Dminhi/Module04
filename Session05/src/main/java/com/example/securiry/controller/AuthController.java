package com.example.securiry.controller;

import com.example.securiry.model.dto.request.FormLogin;
import com.example.securiry.model.dto.request.FormRegister;
import com.example.securiry.model.dto.response.JWTResponse;
import com.example.securiry.service.IUserService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api.example.com/v1/auth")
public class AuthController {
    @Autowired
    private IUserService userService;
    @PostMapping("/login")
    public ResponseEntity<JWTResponse> doLogin(@RequestBody FormLogin formLogin){
        return new ResponseEntity<>(userService.login(formLogin), HttpStatus.OK);
    };
    @PostMapping("/register")
    public ResponseEntity<?>doRegister(@RequestBody FormRegister formRegister){
        boolean check = userService.register(formRegister);
        if(check){
            Map<String,String> map = new HashMap<>();
            map.put("message","Account create successfully");
            return new ResponseEntity<>(map,HttpStatus.CREATED);
        }else {throw new RuntimeException("something is error");}
    }
}
