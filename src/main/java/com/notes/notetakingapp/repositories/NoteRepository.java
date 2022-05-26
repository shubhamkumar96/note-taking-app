package com.notes.notetakingapp.repositories;

import com.notes.notetakingapp.models.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Long> {
}
