package com.notes.notetakingapp.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

    @KafkaListener(topics = "noteupdate", groupId = "groupId")
    void listener(String data) {
        System.out.println("Listener received data: " + data);
    }
}
