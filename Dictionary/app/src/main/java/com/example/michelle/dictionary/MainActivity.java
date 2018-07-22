package com.example.michelle.dictionary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import stanford.androidlib.SimpleActivity;

public class MainActivity extends SimpleActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dictionary = new HashMap<>();
        for (int i = 0; i < WORDS.length; i += 2) {
            dictionary.put(WORDS[i], WORDS[i + 1]);
        }

        ListView list = $(R.id.word_list);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, // activity
                android.R.layout.simple_list_item_1, // layout
                new ArrayList<String>(dictionary.keySet()) // array of elements to display
        );

        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String word = adapterView.getItemAtPosition(i).toString();
                String definition = dictionary.get(word);

                toast(definition);
            }
        });
    }

    private static final String[] WORDS = {
            "apple", "a fruit",
            "tree", "green leaves with brown trunk",
            "blue", "color of the sky"
    };

    private Map<String, String> dictionary;
}
