package com.notes.notetakingapp.repositories;

import com.notes.notetakingapp.models.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface NoteRepository extends JpaRepository<Note, Long> {
    List<Note> findByBodyContainingOrTitleContaining(String queryString1, String queryString2);
}
