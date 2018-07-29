package com.example.michelle.dictionary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import stanford.androidlib.SimpleActivity;

public class StartMenuActivity extends SimpleActivity {

    private static final int REQ_CODE_ADD_WORD = 1234;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_menu);
    }

    public void playGameClick(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void addANewWordClick(View view) {
        Intent intent = new Intent(this, AddWordActivity.class);
        intent.putExtra("initialtext", "foobar");
        startActivityForResult(intent, REQ_CODE_ADD_WORD);
    }

    // this method gets called when AddWordActivity finish() comes back to me

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);

        if (requestCode == REQ_CODE_ADD_WORD) {
            // intent
            // "newword", "newdefinition"

            String newWord = intent.getStringExtra("newword");
            String newDefinition = intent.getStringExtra("newdefinition");

            toast("word added: " + newWord);
        }
    }
}
