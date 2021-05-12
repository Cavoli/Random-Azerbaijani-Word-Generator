package com.randomword.myproject.service.implementation;

import com.randomword.myproject.enums.wordEnums.WordType;
import com.randomword.myproject.model.Word;
import com.randomword.myproject.repository.WordRepository;
import com.randomword.myproject.service.WordService;
import com.randomword.myproject.util.WordHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;

@Service
@Transactional
public class WordServiceImpl implements WordService {

    private WordRepository wordRepository;

    @Autowired
    public WordServiceImpl(WordRepository wordRepository) {
        this.wordRepository = wordRepository;
    }

    @Override
    public Collection<Word> findAll() throws DataAccessException {
        return wordRepository.findAll();
    }

    @Override
    public Collection<Word> findRandomWord(Integer wordCount, WordType wordType,
                                           Integer wordSize, String firstLetter, String lastLetter) {

        Collection<Word> words = wordRepository.findByType(wordType.toString().toLowerCase());

        if(wordSize != null){
            words = WordHelper.filterWordsByLength(words, wordSize);
        }
        if(firstLetter != null || lastLetter != null){
            words = WordHelper.filterWordsByLetters(words, firstLetter, lastLetter);
        }
        return words;
    }
}
