package com.randomword.myproject.controller;


import com.randomword.myproject.model.Letter;
import com.randomword.myproject.service.LetterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@RestController
@CrossOrigin(exposedHeaders = "errors, content-type")
@RequestMapping("/api/letters")
public class LetterController {

    private LetterService letterService;

    @Autowired
    public LetterController(LetterService letterService) {
        this.letterService = letterService;
    }

    @GetMapping(value = "/{letterCount}", produces = "application/json")
    public ResponseEntity<Collection<Letter>> getRandomLetters(@PathVariable("letterCount") int letterCount){
        Collection<Letter> letters = new HashSet<>();
        letters = letterService.findRandom(letterCount);
        return new ResponseEntity<>(letters, HttpStatus.OK);
    }

    @GetMapping(value = "", produces = "application/json")
    public ResponseEntity<Collection<Letter>> getAllLetters(){
        Collection<Letter> letters = new HashSet<>();
        letters = letterService.findAll();
        return new ResponseEntity<>(letters, HttpStatus.OK);
    }
}
