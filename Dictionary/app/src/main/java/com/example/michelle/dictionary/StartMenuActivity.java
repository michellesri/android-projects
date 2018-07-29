package com.example.michelle.dictionary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import stanford.androidlib.SimpleActivity;

public class StartMenuActivity extends SimpleActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_menu);
    }

    public void playGameClick(View view) {
    }

    public void addANewWordClick(View view) {
        Intent intent = new Intent(this, AddWordActivity.class);
        intent.putExtra("initialtext", "foobar");
        startActivity(intent);
    }
}
