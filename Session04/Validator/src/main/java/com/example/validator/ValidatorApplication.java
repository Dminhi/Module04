package com.example.validator;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ValidatorApplication {
    @Bean // kiến trúc mvc - design pattern : Singleton
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

    public static void main(String[] args) {
        SpringApplication.run(ValidatorApplication.class, args);
    }

}
