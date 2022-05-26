package com.notes.notetakingapp.controllers;

import com.notes.notetakingapp.models.Note;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

@RestController
public class NoteController {


    @GetMapping("/api/note")
    public Note getNote(@RequestParam(value = "noteId", defaultValue = "1") Long noteId) {
        Note note = new Note(noteId, "Test Note", "Test Description", ZonedDateTime.ofInstant(new Date().toInstant(), ZoneId.systemDefault()));
        return note;
    }
}
