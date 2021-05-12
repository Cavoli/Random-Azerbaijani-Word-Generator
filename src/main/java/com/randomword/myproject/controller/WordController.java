package com.randomword.myproject.controller;

import com.randomword.myproject.enums.wordEnums.WordType;
import com.randomword.myproject.model.Word;
import com.randomword.myproject.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@CrossOrigin(exposedHeaders = "errors, content-type")
@RequestMapping("/api/words")
public class WordController {

    private WordService wordService;

    @Autowired
    public WordController(WordService wordService) {
        this.wordService = wordService;
    }

    @GetMapping(value = "/word", produces = "application/json")
    public ResponseEntity<Collection<Word>> getRandomWords(
            @RequestParam("word-count") Integer wordCount,
            @RequestParam("word-type") WordType wordType,
            @RequestParam(value = "word-size", required = false) Integer wordSize,
            @RequestParam(value = "first-letter", required = false) String firstLetter,
            @RequestParam(value = "last-letter", required = false) String lastLetter){

        Collection<Word> result;
        result = wordService.findRandomWord(wordCount, wordType, wordSize, firstLetter, lastLetter);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
