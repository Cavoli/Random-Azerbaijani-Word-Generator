package com.randomword.myproject.repository;

import com.randomword.myproject.model.Word;
import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.Repository;

import java.util.Collection;

public interface WordRepository extends Repository<Word, Integer> {

    public Collection<Word> findAll() throws DataAccessException;

    public Collection<Word> findByType(String type) throws DataAccessException;


}
