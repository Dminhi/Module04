package com.example.securiry.model.dto.request;

import com.example.securiry.model.entity.Role;

import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class FormRegister {
    private String username;
    private String fullName;
    private String email;
    private String password;
    private Set<String> roleSet;

}
