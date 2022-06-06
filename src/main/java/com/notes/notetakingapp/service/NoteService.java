package com.notes.notetakingapp.service;

import com.notes.notetakingapp.models.Note;
import com.notes.notetakingapp.repositories.NoteRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class NoteService {
    public NoteRepository noteRepository;

    public Object getNote(Long noteId) {
        Optional<Note> noteOp = noteRepository.findById(noteId);
        if(noteOp.isPresent()) {
            return noteOp.get();
        }
        return "No Note available for given noteId";
    }

    public Note addNote(Note note){
        note.setDateTime(ZonedDateTime.ofInstant(new Date().toInstant(), ZoneId.systemDefault()));
        noteRepository.save(note);
        return note;
    }

    public Iterable<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    public Iterable<Note> searchNotesByQueryString(@RequestParam(value = "q", defaultValue = "test") String queryString) {
        List<Note> listOfNotes = noteRepository.findByBodyContainingOrTitleContaining(queryString, queryString);
        if(listOfNotes.size() == 0) {
            System.out.println("No Notes Found" + queryString);
        }
        return listOfNotes;
    }

    public Object deleteNote(@RequestParam(value = "noteId", defaultValue = "1")Long noteId) {
        Optional<Note> noteOp = noteRepository.findById(noteId);
        if(noteOp.isPresent()) {
            Note note = noteOp.get();
            noteRepository.delete(note);
            return note;
        }
        return "No note with the given noteId found";
    }

    public List<Note> updateNote(@RequestBody Note newNote) {
        List<Note> oldAndNewNotes = new ArrayList<>();

        //Update to current time
        newNote.setDateTime(ZonedDateTime.ofInstant(new Date().toInstant(), ZoneId.systemDefault()));

        Long noteId = newNote.getId();
        Optional<Note> noteOp = noteRepository.findById(noteId);
        // If there is note with given noteId present, then we will update it
        if(noteOp.isPresent()) {
            Note oldNote = noteOp.get();
            oldAndNewNotes.add(new Note(oldNote.getId(), "[OLD] " + oldNote.getTitle(), oldNote.getBody(), oldNote.getDateTime())); // Add the old note
            oldNote.setBody(newNote.getBody());
            oldNote.setTitle(newNote.getTitle());
            oldNote.setDateTime(newNote.getDateTime());
            noteRepository.save(oldNote);
        } else {    // Else we will save the new note to the database
            noteRepository.save(newNote);
        }

        oldAndNewNotes.add(newNote);
        return oldAndNewNotes;
    }

    public List<Note> updateNoteKafka(@RequestBody Note newNote) {
        List<Note> oldAndNewNotes = new ArrayList<>();

        //Update to current time
        newNote.setDateTime(ZonedDateTime.ofInstant(new Date().toInstant(), ZoneId.systemDefault()));

        Long noteId = newNote.getId();
        Optional<Note> noteOp = noteRepository.findById(noteId);
        // If there is note with given noteId present, then we will update it
        if(noteOp.isPresent()) {
            Note oldNote = noteOp.get();
            oldAndNewNotes.add(new Note(oldNote.getId(), "[OLD] " + oldNote.getTitle(), oldNote.getBody(), oldNote.getDateTime())); // Add the old note
            oldNote.setBody(newNote.getBody());
            oldNote.setTitle(newNote.getTitle());
            oldNote.setDateTime(newNote.getDateTime());
            noteRepository.save(oldNote);
        } else {    // Else we will save the new note to the database
            noteRepository.save(newNote);
        }

        oldAndNewNotes.add(newNote);
        return oldAndNewNotes;
    }

}
