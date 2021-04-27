package com.randomword.myproject.service;

import com.randomword.myproject.model.Letter;
import org.springframework.dao.DataAccessException;

import java.util.Collection;

public interface LetterService {

    public Collection<Letter> findRandom(Integer count) throws DataAccessException;

    public Collection<Letter> findAll() throws DataAccessException;

}
