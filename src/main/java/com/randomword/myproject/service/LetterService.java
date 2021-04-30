package com.randomword.myproject.service;

import com.randomword.myproject.enums.letterEnums.LetterType;
import com.randomword.myproject.model.Letter;
import org.springframework.dao.DataAccessException;

import java.util.Collection;

public interface LetterService {

    public Collection<Letter> findAll() throws DataAccessException;

    public Collection<String> getRandomLetter(Integer count, LetterType letterType) throws DataAccessException;

    public Collection<String> getTrueRandomLetter(Integer count, LetterType letterType) throws DataAccessException;
}
