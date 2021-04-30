package com.randomword.myproject.repository;

import com.randomword.myproject.model.Letter;
import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.Repository;

import java.util.Collection;
import java.util.List;

public interface LetterRepository extends Repository<Letter, Integer> {

    public List<Letter> findAll() throws DataAccessException;

}
