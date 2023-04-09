package com.abdullah.notesApp.controller;

import com.abdullah.notesApp.entity.Notes;
import com.abdullah.notesApp.repository.NotesRepository;
import jakarta.servlet.http.HttpServletRequestWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class NotesController {

    @Autowired
    private NotesRepository repository;


    @GetMapping("/id/{id}")
    public Notes getNote(@PathVariable int id) {
        Optional<Notes> note = repository.findById(id);
        return note.orElseGet(Notes::new);
    }

}
