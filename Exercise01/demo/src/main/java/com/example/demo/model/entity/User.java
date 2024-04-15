package com.example.demo.model.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;


import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;
    private String sku;
    @NotBlank
    @Pattern(regexp = "^\\w+$",message = "Khong chua ki tu dac biet")
    private String userName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dob;
    private String email;
    private boolean gender;
    private String img;
}
