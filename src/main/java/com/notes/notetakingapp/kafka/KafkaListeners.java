package com.notes.notetakingapp.kafka;

import com.notes.notetakingapp.models.Note;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

    @KafkaListener(topics = "noteupdate", groupId = "groupId")
    void listener(Note note) {
        System.out.println("Listener received data: " + note);
    }
}
