package com.example.exercise02.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Category {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long categoryId;
    private String categoryName;
//    @OneToMany(mappedBy = "category")
//    @JsonIgnore
//    private List<Blog> blogList;
}
