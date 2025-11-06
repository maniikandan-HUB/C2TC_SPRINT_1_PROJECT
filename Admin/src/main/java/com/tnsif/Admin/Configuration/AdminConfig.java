package com.tnsif.Admin.Configuration;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.tnsif.Admin.Entity.Admin;
import com.tnsif.Admin.Repository.AdminRepository;

import java.util.List;

@Configuration
public class AdminConfig {

    @Bean
    CommandLineRunner commandLineRunner(AdminRepository repository) {
        return args -> {
            Admin admin1 = new Admin(1L, "Mall Manager", "manager@mall.com", "manager123", "Manager", "9876543210", "Operations", "Active");
            Admin admin2 = new Admin(2L, "Shop Supervisor", "supervisor@mall.com", "supervisor123", "Supervisor", "9876543211", "Retail", "Active");

            repository.saveAll(List.of(admin1, admin2));
        };
    }
}