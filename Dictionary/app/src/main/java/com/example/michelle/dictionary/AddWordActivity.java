package com.example.michelle.dictionary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.io.PrintStream;

import stanford.androidlib.SimpleActivity;

public class AddWordActivity extends SimpleActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_word);

        Intent intent = getIntent();
        String text = intent.getStringExtra("initialtext"); // foobar
        $TV(R.id.new_word).setText(text);
     }

    public void addWordClick(View view) {
        // add given word and definition to dictionary
        String newWord = $ET(R.id.new_word).getText().toString();
        String newDefinition = $ET(R.id.new_definition).getText().toString();
        // write to end of files
        PrintStream output = new PrintStream(openFileOutput("added_words.txt", MODE_PRIVATE | MODE_APPEND));
        output.println(newWord + " -> " + newDefinition);
        output.close();

        // go back to start menu activity
        finish();
    }
}
