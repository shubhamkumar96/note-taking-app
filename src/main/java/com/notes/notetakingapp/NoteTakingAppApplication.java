package com.notes.notetakingapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class NoteTakingAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(NoteTakingAppApplication.class, args);
    }

}
