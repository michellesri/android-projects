package com.example.michelle.dictionary;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

import stanford.androidlib.SimpleActivity;
import stanford.androidlib.SimpleList;

public class MainActivity extends SimpleActivity {

    private Map<String, String> dictionary;
    private List<String> words;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dictionary = new HashMap<>();
        words = new ArrayList<>();
        Scanner scan = new Scanner(getResources().openRawResource(R.raw.words));
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            String[] parts = line.split("->");
            println("parts: " + Arrays.toString(parts));
            dictionary.put(parts[0], parts[1]);
            println("dictionary writing to: " + dictionary);
            words.add(parts[0]);

        }
        chooseWords();


//        ArrayAdapter<String> adapter = new ArrayAdapter<>(
//                this, // activity
//                android.R.layout.simple_list_item_1, // layout
//                new ArrayList<String>(dictionary.keySet()) // array of elements to display
//        );
//        list.setAdapter(adapter);

        ListView list = $(R.id.word_list);


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String definitionClicked = adapterView.getItemAtPosition(i).toString();
                String theWord = $TV(R.id.the_word).getText().toString();
                String theCorrectDefinition = dictionary.get(theWord);

                if (definitionClicked.equals(theCorrectDefinition)) {

                    toast("Correct!");
                } else {
                    toast("Incorrect :(");
                }
                chooseWords();

            }

        });
    }

    private void chooseWords() {
        // pick the word
        Random rand = new Random();
        int randomIndex = rand.nextInt(words.size());
        String theWord = words.get(randomIndex);
        String theDefinition = dictionary.get(theWord);

        // pick other wrong definitions at random
        List<String> definitions = new ArrayList<>(dictionary.values());
        definitions.remove(theDefinition);
        definitions = definitions.subList(0, 4);
        definitions.add(theDefinition);
        Collections.shuffle(definitions);

        // show on screen
        $TV(R.id.the_word).setText(theWord);
        SimpleList.with(this).setItems(R.id.word_list, definitions);

    }

}
