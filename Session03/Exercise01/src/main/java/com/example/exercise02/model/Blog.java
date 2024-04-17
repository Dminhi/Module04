package com.example.exercise02.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Blog {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long blogId;
    @NotBlank
    private String blogName;
    @NotBlank
        private String blogContent;
    @JoinColumn(name= "categoryId")
    @ManyToOne
//    @JsonIgnoreProperties({"id"})
    private Category category;
}
