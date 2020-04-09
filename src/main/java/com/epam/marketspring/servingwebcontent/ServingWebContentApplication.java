package com.epam.marketspring.servingwebcontent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication

@EntityScan({"com.epam.marketspring.domain"})
@ComponentScan({"com.epam.marketspring.service", "com.epam.marketspring.config", "com.epam.marketspring.servingwebcontent", "com.epam.marketspring.dao"})


public class ServingWebContentApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServingWebContentApplication.class, args);
    }

}