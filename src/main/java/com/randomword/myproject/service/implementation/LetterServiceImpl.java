package com.randomword.myproject.service.implementation;

import com.randomword.myproject.model.Letter;
import com.randomword.myproject.repository.LetterRepository;
import com.randomword.myproject.service.LetterService;
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
    public Collection<Letter> findAll() throws DataAccessException {
        return letterRepository.findAll();
    }

    @Override
    public Collection<Letter> findRandom(Integer count){
        List<Letter> allLetters = new ArrayList<>(letterRepository.findAll());

        Set<Letter> letters = new HashSet<>();
        Random rng = new Random();
        while (letters.size() < count && letters.size() < allLetters.size()){
            letters.add(allLetters.get(rng.nextInt(allLetters.size())));
        }
        return letters;
    }
}
