package com.github.michellesri.hangman;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class PhraseGenerator {

    public static List<String> allPhrases = Arrays.asList(
            "cookie",
            "dog",
            "chases",
            "after",
            "cat",
            "you",
            "hit",
            "the",
            "jackpot",
            "cereal",
            "best"
    );
    private static Random random = new Random(System.currentTimeMillis());

    public static String generatePhrase() {
        int index = Math.abs(random.nextInt()) % allPhrases.size();
        return allPhrases.get(index);
    }

}
