package com.notes.notetakingapp;

import com.notes.notetakingapp.models.Note;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

@SpringBootApplication
public class NoteTakingAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(NoteTakingAppApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(KafkaTemplate<String, Note> kafkaTemplate) {
        return args -> {
            for(int i=0; i<100; i++) {
                Note note = new Note(Long.valueOf(i), "title-"+i, "body-"+i, ZonedDateTime.ofInstant(new Date().toInstant(), ZoneId.systemDefault()));
                kafkaTemplate.send("noteupdate", note);
            }
        };
    }

}
