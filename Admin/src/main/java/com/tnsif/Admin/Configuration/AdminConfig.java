package com.tnsif.Admin.Configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AdminConfig {

    @Bean
    public String startupMessage() {
        return "Admin configuration loaded successfully!";
    }
}
