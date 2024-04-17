package com.example.exercise02.model.dto.response;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BlogResponse {
 private String blogName,blogContent,categoryName;
}
