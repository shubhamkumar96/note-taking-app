package com.notes.notetakingapp.kafka;

import com.notes.notetakingapp.models.Note;
import com.notes.notetakingapp.repositories.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

    @Autowired
    public NoteRepository noteRepository;

    @KafkaListener(topics = "noteupdate", groupId = "groupId")
    Note listener(Note note) throws InterruptedException {
        note.setTitle(note.getTitle()+"-Kafka");
        System.out.println("Listener received data: " + note);
        return noteRepository.save(note);
    }
}
