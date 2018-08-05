package com.github.michellesri.hangman;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String phrase = PhraseGenerator.generatePhrase();

        List<Boolean> guessed = new ArrayList<>();
        for (Character c : phrase.toCharArray()) {
            // Don't need to guess space
            guessed.add(c == ' ');
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < guessed.size(); i++) {
            if (guessed.get(i)) {
                sb.append(phrase.charAt(i));
            } else {
                sb.append("_");
            }
            sb.append(" ");
        }

        TextView targetWord = findViewById(R.id.target_word_txt);
        targetWord.setText(sb.toString());

        final EditText userInput = findViewById(R.id.guess_edt);
        userInput.setOnKeyListener(new View.OnKeyListener() {

            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                if (keyEvent.getAction() == KeyEvent.ACTION_DOWN
                        && keyCode == KeyEvent.KEYCODE_ENTER) {
                    // do something
                    System.out.println(userInput.getText());
                    return true;
                }
                return false;
            }

        });
    }
}
