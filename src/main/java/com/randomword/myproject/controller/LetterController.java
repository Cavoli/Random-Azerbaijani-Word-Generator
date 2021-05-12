package com.randomword.myproject.controller;


import com.randomword.myproject.enums.letterEnums.LetterType;
import com.randomword.myproject.model.Letter;
import com.randomword.myproject.service.LetterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashSet;

@RestController
@CrossOrigin(exposedHeaders = "errors, content-type")
@RequestMapping("/api/letters")
public class LetterController {

    private LetterService letterService;

    @Autowired
    public LetterController(LetterService letterService) {
        this.letterService = letterService;
    }

//    @GetMapping(value = "", params = "letterCount", produces = "application/json")
//    public ResponseEntity<Collection<String>> getRandomLetters(@RequestParam("letterCount") int letterCount){
//        Collection<String> letters = new HashSet<>();
//        letters = letterService.getRandomLowerCaseLetters(letterCount);
//        return new ResponseEntity<>(letters, HttpStatus.OK);
//    }

    @GetMapping(value = "", produces = "application/json")
    public ResponseEntity<Collection<Letter>> getAllLetters(){
        Collection<Letter> letters = new HashSet<>();
        letters = letterService.findAll();
        return new ResponseEntity<>(letters, HttpStatus.OK);
    }

    //switch to hyphen case, add other http requests
    @GetMapping(value = "", produces = "application/json")
    public ResponseEntity<Collection<String>> getRandomLetters
            (@RequestParam("letter-count") int letterCount,
             @RequestParam("letter-type") LetterType letterType,
             @RequestParam("true-random") boolean isTrueRandom){

        Collection<String> letters;

        if(!isTrueRandom){
            letters = letterService.getRandomLetter(letterCount, letterType);
        }else{
            letters = letterService.getTrueRandomLetter(letterCount, letterType);
        }

        return new ResponseEntity<>(letters, HttpStatus.OK);
    }
}
