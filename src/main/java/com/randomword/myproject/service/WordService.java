package com.randomword.myproject.service;

import com.randomword.myproject.enums.wordEnums.WordType;
import com.randomword.myproject.model.Word;
import org.springframework.dao.DataAccessException;

import java.util.Collection;

public interface WordService {

    public Collection<Word> findAll() throws DataAccessException;

    public Collection<Word> findRandomWord(Integer wordCount, WordType wordType,
                                                               Integer wordSize, String firstLetter, String lastLetter);

}
