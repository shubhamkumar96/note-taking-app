package com.notes.notetakingapp.controllers;

import com.notes.notetakingapp.models.Note;
import com.notes.notetakingapp.repositories.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController @RequestMapping(path = "/api")
public class NoteController {

    @Autowired
    private NoteRepository noteRepository;

    @GetMapping("/note")
    public Object getNote(@RequestParam(value = "noteId", defaultValue = "1") Long noteId) {
        Optional<Note> noteOp = noteRepository.findById(noteId);
        if(noteOp.isPresent()) {
            return noteOp.get();
        }
        return "No Note available for given noteId";
    }

    @PostMapping("/note")
    public Note addNote(@RequestBody Note note){
        note.setDateTime(ZonedDateTime.ofInstant(new Date().toInstant(), ZoneId.systemDefault()));
        noteRepository.save(note);
        return note;
    }

    @GetMapping("/notes")
    public Iterable<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    @GetMapping("/search")
    public Iterable<Note> searchNotesByQueryString(@RequestParam(value = "q", defaultValue = "test") String queryString) {
        List<Note> listOfNotes = noteRepository.findByBodyContainingOrTitleContaining(queryString, queryString);
        if(listOfNotes.size() == 0) {
            System.out.println("No Notes Found" + queryString);
        }
        return listOfNotes;
    }
}
