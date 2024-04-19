package com.example.validatesong;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ValidateSongApplication {
    @Bean // kiến trúc mvc - design pattern : Singleton
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

    public static void main(String[] args) {
        SpringApplication.run(ValidateSongApplication.class, args);
    }

}
