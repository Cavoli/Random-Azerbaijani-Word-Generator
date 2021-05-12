package com.randomword.myproject.util;

import com.randomword.myproject.model.Word;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class WordHelper {

    public static Collection<Word> filterWordsByLength(Collection<Word> words, Integer length){
        List<Word> filteredWords = new ArrayList<>();

        for (Word word:words) {
            if(word.getWord().length() == length){
                filteredWords.add(word);
            }
        }
        return filteredWords;
    }

    public static Collection<Word> filterWordsByLetters(Collection<Word> words, String firstLetter, String lastLetter){
        if(firstLetter == null){
            return filterByLastLetter(words, lastLetter);
        }
        if(lastLetter == null){
            return filterByFirstLetter(words, firstLetter);
        }
        return filteredByFirstAndLastLetter(words, firstLetter, lastLetter);

    }

    private static Collection<Word> filterByFirstLetter(Collection<Word> words, String letter){
        List<Word> filteredWords = new ArrayList<>();

        for (Word word:words) {
            if (word.getWord().length() == 1){
                if(word.getWord().equals(letter)){
                    filteredWords.add(word);
                }
            } else if(word.getWord().substring(0, 1).equals(letter)){
                filteredWords.add(word);
            }
        }
        return  filteredWords;
    }

    private static Collection<Word> filterByLastLetter(Collection<Word> words, String letter){
        List<Word> filteredWords = new ArrayList<>();

        for (Word word:words) {
            if (word.getWord().length() == 1){
                if(word.getWord().equals(letter)){
                    filteredWords.add(word);
                }
            } else if(word.getWord().substring(word.getWord().length() - 2, word.getWord().length() - 1).equals(letter)){
                filteredWords.add(word);
            }
        }
        return  filteredWords;
    }

    private static Collection<Word> filteredByFirstAndLastLetter(Collection<Word> words, String firstLetter, String lastLetter){
        List<Word> filteredWords = new ArrayList<>();
        for(Word word : words){
            if(word.getWord().length() == 1){
                continue;
            }
            if(word.getWord().substring(0,1).equals(firstLetter) &&
               word.getWord().substring(word.getWord().length() - 2, word.getWord().length() - 1).equals(lastLetter)){
                filteredWords.add(word);
            }
        }
        return filteredWords;
    }
}
