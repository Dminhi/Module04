package com.example.validator.model.dto.request;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserRequest {
    @NotNull
    @Size(min = 5, max = 45,message = "Firstname bắt buộc có độ dài tối thiểu 5, tối đa 45 ký tự")
    private String firstName;
    @NotNull
    @Size(min = 5, max = 45,message = "Lastname bắt buộc, có độ dài tối thiểu 5, tối đa 45 ký tự")
    private String lastName;
    @NotNull
    @Pattern(regexp = "0[0-9]{9}", message = "Số điện thoại phải đúng định dạng của Việt Nam và bắt đầu bằng 0.")
    private String phoneNumber;
    @NotNull
    @Min(value = 18, message = "Age >=18\n")
    private Integer age;
    @NotNull
    @Email(message = "Địa chỉ email không hợp lệ.")
    private String email;
}
