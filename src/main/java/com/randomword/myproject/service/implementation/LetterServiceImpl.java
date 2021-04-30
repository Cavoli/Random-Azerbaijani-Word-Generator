package com.randomword.myproject.service.implementation;

import com.randomword.myproject.enums.letterEnums.LetterType;
import com.randomword.myproject.model.Letter;
import com.randomword.myproject.repository.LetterRepository;
import com.randomword.myproject.service.LetterService;
import com.randomword.myproject.util.LetterHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class LetterServiceImpl implements LetterService {

    private LetterRepository letterRepository;

    @Autowired
    public LetterServiceImpl(LetterRepository letterRepository) {
        this.letterRepository = letterRepository;
    }

    @Override
    public List<Letter> findAll() throws DataAccessException {
        return letterRepository.findAll();
    }

    @Override
    public Collection<String> getRandomLetter(Integer count, LetterType letterType){
        List<Letter> allLetters = letterRepository.findAll();

        switch (letterType){
            case SMALL: return LetterHelper.randomSmallLetters(count, allLetters);
            case BIG: return LetterHelper.randomBigLetter(count, allLetters);
            case ALL: return LetterHelper.randomAnyLetter(count, allLetters);
        }
        return null;
    }

    @Override
    public Collection<String> getTrueRandomLetter(Integer count, LetterType letterType){
        List<Letter> allLetters = letterRepository.findAll();

        switch (letterType){
            case SMALL: return LetterHelper.trueRandomSmallLetters(count, allLetters);
            case BIG: return LetterHelper.trueRandomBigLetter(count, allLetters);
            case ALL: return LetterHelper.trueRandomAnyLetter(count,allLetters);
        }
        return null;
    }
}
