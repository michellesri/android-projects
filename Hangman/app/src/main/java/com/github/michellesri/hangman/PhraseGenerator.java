package com.github.michellesri.hangman;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PhraseGenerator {

    public static ArrayList<String> allPhrases = new ArrayList<String>(){};
    private static Random random = new Random(System.currentTimeMillis());

    public static String generatePhrase() {
        allPhrases.add("cookie");
        allPhrases.add("dog");
        allPhrases.add("chases");
        allPhrases.add("after");
        allPhrases.add("cat");
        allPhrases.add("you");
        allPhrases.add("hit");
        allPhrases.add("the");
        allPhrases.add("jackpot");
        allPhrases.add("cereal");
        allPhrases.add("best");
        int index = Math.abs(random.nextInt()) % allPhrases.size();
        return allPhrases.get(index);
    }

}
