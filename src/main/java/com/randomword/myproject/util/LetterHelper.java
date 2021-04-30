package com.randomword.myproject.util;

import com.randomword.myproject.model.Letter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

public class LetterHelper {

    public static Collection<String> randomSmallLetters(Integer count, List<Letter> allLetters){
        Random rng = new Random();
        List<String> letters = new ArrayList<>();
        int size = allLetters.size();
        while(letters.size() < size && letters.size() < count){
            int index = rng.nextInt(allLetters.size());
            letters.add(allLetters.get(index).getLetter());
            allLetters.remove(index);
        }
        return letters;
    }

    public static Collection<String> randomBigLetter(Integer count, List<Letter> allLetters){
        Random rng = new Random();
        List<String> letters = new ArrayList<>();
        int size = allLetters.size();
        while(letters.size() < size && letters.size() < count){
            int index = rng.nextInt(allLetters.size());
            letters.add(allLetters.get(index).getLetter().toUpperCase());
            allLetters.remove(index);
        }
        return letters;
    }

    public static Collection<String> randomAnyLetter(Integer count, List<Letter> allLetters){
        List<String> list = new ArrayList<>();
        for (Letter letter: allLetters) {
            list.add(letter.getLetter());
            list.add(letter.getLetter().toUpperCase());
        }
        int size = list.size();
        Random rng = new Random();
        List<String> letters = new ArrayList<>();
        while(letters.size() < size && letters.size() < count){
            int index = rng.nextInt(list.size());
            letters.add(list.get(index));
            list.remove(index);
        }
        return letters;
    }

    public static Collection<String> trueRandomSmallLetters(Integer count, List<Letter> allLetters){
        Random rng = new Random();
        List<String> letters = new ArrayList<>();

        while(letters.size() < count){
            int index = rng.nextInt(allLetters.size());
            letters.add(allLetters.get(index).getLetter());
        }
        return letters;
    }

    public static Collection<String> trueRandomBigLetter(Integer count, List<Letter> allLetters){
        Random rng = new Random();
        List<String> letters = new ArrayList<>();

        while(letters.size() < count){
            int index = rng.nextInt(allLetters.size());
            letters.add(allLetters.get(index).getLetter().toUpperCase());
        }
        return letters;
    }

    public static Collection<String> trueRandomAnyLetter(Integer count, List<Letter> allLetters){
        List<String> list = new ArrayList<>();
        for (Letter letter: allLetters) {
            list.add(letter.getLetter());
            list.add(letter.getLetter().toUpperCase());
        }

        Random rng = new Random();
        List<String> letters = new ArrayList<>();
        while(letters.size() < count){
            int index = rng.nextInt(list.size());
            letters.add(list.get(index));
        }
        return letters;
    }
}
