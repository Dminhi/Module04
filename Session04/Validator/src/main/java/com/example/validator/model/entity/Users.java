package com.example.validator.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String firstName;
    private String lastName;
    private Integer phoneNumber;
    private Integer age;
    private String email;
}
