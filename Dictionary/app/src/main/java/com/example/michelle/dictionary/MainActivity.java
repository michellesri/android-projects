package com.example.michelle.dictionary;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import stanford.androidlib.SimpleActivity;
import stanford.androidlib.SimpleList;

public class MainActivity extends SimpleActivity {

    private Map<String, String> dictionary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dictionary = new HashMap<>();
        Scanner scan = new Scanner(getResources().openRawResource(R.raw.words));
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            String[] parts = line.split("->");
            println("parts: " + Arrays.toString(parts));
            dictionary.put(parts[0], parts[1]);
        }


//        ArrayAdapter<String> adapter = new ArrayAdapter<>(
//                this, // activity
//                android.R.layout.simple_list_item_1, // layout
//                new ArrayList<String>(dictionary.keySet()) // array of elements to display
//        );
//        list.setAdapter(adapter);

        Spinner list = $(R.id.word_list);
        SimpleList.with(this).setItems(list, dictionary.keySet());


        list.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String word = adapterView.getItemAtPosition(i).toString();
                String definition = dictionary.get(word);

                toast(definition);

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

//    private static final String[] WORDS = {
//            "apple", "a fruit",
//            "tree", "green leaves with brown trunk",
//            "blue", "color of the sky"
//    };

}
