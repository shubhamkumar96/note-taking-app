package com.notes.notetakingapp.controllers;

import com.notes.notetakingapp.models.Note;
import com.notes.notetakingapp.repositories.NoteRepository;
import com.notes.notetakingapp.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController @RequestMapping(path = "/api")
public class NoteController {

    private NoteRepository noteRepository;
    private NoteService noteService;

    @GetMapping("/note")
    public Object getNote(@RequestParam(value = "noteId", defaultValue = "1") Long noteId) {
        return noteService.getNote(noteId);
    }

    @PostMapping("/note")
    public Note addNote(@RequestBody Note note){
        return noteService.addNote(note);
    }

    @GetMapping("/notes")
    public Iterable<Note> getAllNotes() {
        return noteService.getAllNotes();
    }

    @GetMapping("/search")
    public Iterable<Note> searchNotesByQueryString(@RequestParam(value = "q", defaultValue = "test") String queryString) {
        return noteService.searchNotesByQueryString(queryString);
    }

    @DeleteMapping("/delete")
    public Object deleteNote(@RequestParam(value = "noteId", defaultValue = "1")Long noteId) {
        return noteService.deleteNote(noteId);
    }

    @PutMapping("/updatenote")
    public List<Note> updateNote(@RequestBody Note newNote) {
        return noteService.updateNote(newNote);
    }

    @PutMapping("/updatenotekafka")
    public List<Note> updateNoteKafka(@RequestBody Note newNote) {
        return noteService.updateNoteKafka(newNote);
    }
}
