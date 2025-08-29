package com.tapan.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {

    @Bean
    ModelMapper getMapper(){

        return new ModelMapper();
    }


}
