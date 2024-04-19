package com.example.excercise01.module;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.text.NumberFormat;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Mp3 {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String songName;
    private String singer;
    private String category;
    private String linkFile;
}
