package com.notes.notetakingapp.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Data @NoArgsConstructor @AllArgsConstructor
public class Note {
    private Long id;
    private String title;
    private String body;
    private ZonedDateTime dateTime;
}
