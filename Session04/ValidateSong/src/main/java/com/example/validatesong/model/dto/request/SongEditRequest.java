package com.example.validatesong.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SongEditRequest {
    private Long id;
    @NotBlank(message = "Trường này không được để trống.")
    @Size(max = 800, message = "Trường này không được vượt quá 800 ký tự.")
    @Pattern(regexp = "^[a-zA-Z0-9 ]*$", message = "Trường này không được chứa các ký tự đặc biệt.")
    private String songName;
    @NotBlank(message = "Trường này không được để trống.")
    @Size(max = 300, message = "Trường này không được vượt quá 300 ký tự.")
    @Pattern(regexp = "^[a-zA-Z0-9\\s]+$", message = "Trường này không được chứa các ký tự đặc biệt.")
    private String singer;
    @NotBlank(message = "Trường này không được để trống.")
    @Size(max = 1000, message = "Trường này không được vượt quá 1000 ký tự.")
    @Pattern(regexp = "^[a-zA-Z0-9,\\s]+$", message = "Trường này chỉ được phép chứa chữ cái, số, dấu phẩy và khoảng trắng.")
    private String category;
}
