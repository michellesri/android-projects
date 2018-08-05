package com.github.michellesri.hangman;

import java.util.Random;

public class PhraseGenerator {

    private static String[] allPhrases = new String[] {
            "Here is a cookie",
            "Dog chases after a cat",
            "You hit the jackpot",
            "Cereal is the best"
    };
    private static Random random = new Random(System.currentTimeMillis());

    public static String generatePhrase() {
        int index = Math.abs(random.nextInt()) % allPhrases.length;
        return allPhrases[index];
    }
}
