package com.abdullah.notesApp.controller;

import com.abdullah.notesApp.entity.User;
import com.abdullah.notesApp.entity.UserRequest;
import com.abdullah.notesApp.repository.UsersRepository;
import com.abdullah.notesApp.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SignUpController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UsersRepository repository;

    @PostMapping("/sign-up")
    @CrossOrigin(origins = "*")
    public ResponseEntity<Response> signUserUp(@RequestBody UserRequest request) {
        String encodedPassword = passwordEncoder.encode(request.getPassword());

        User user = new User(request.getUsername(), encodedPassword, "user");
        repository.save(user);

        return ResponseEntity.ok(new Response());
    }
}
