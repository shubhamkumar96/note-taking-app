package com.notes.notetakingapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(
        exclude={DataSourceAutoConfiguration.class}
) //TO-DO: Remove this exclusion of 'DataSourceAutoConfiguration' after configuring the Datasource properties.
public class NoteTakingAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(NoteTakingAppApplication.class, args);
    }

}
