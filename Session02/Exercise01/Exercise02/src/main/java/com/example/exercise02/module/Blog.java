package com.example.exercise02.module;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.springframework.validation.annotation.Validated;

import java.math.BigDecimal;
import java.text.NumberFormat;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Blog {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank
    private String blogName;
    @NotBlank
    private String blogContent;
}
