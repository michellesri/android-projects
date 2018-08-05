package com.github.michellesri.hangman;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static int[] hangmanDrawables = new int[] {
            R.drawable.hangman_1,
            R.drawable.hangman_2,
            R.drawable.hangman_3,
            R.drawable.hangman_4,
            R.drawable.hangman_5,
            R.drawable.hangman_6,
            R.drawable.hangman_7
    };

    private String phrase;
    private List<Boolean> guessed;
    private List<Character> guessedCharacters;
    private int currentHangmanIndex = 0;

    private TextView targetWord;
    private TextView lettersGuessed;
    private EditText userInput;
    private ImageView hangmanImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        phrase = PhraseGenerator.generatePhrase();
        guessedCharacters = new ArrayList<>();
        guessed = new ArrayList<>();

        targetWord = findViewById(R.id.target_word_txt);
        lettersGuessed = findViewById(R.id.guessed_letters_txt);
        userInput = findViewById(R.id.guess_edt);
        hangmanImg = findViewById(R.id.hangman_img);

        for (Character c : phrase.toCharArray()) {
            // Don't need to guess space
            guessed.add(c == ' ');
        }

        userInput.setOnKeyListener(new View.OnKeyListener() {

            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                if (keyEvent.getAction() == KeyEvent.ACTION_DOWN
                        && keyCode == KeyEvent.KEYCODE_ENTER) {
                    char guess = userInput.getText().charAt(0);
                    guess(guess);
                    return true;
                }
                return false;
            }

        });

        render();
    }

    private void render() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < guessed.size(); i++) {
            if (guessed.get(i)) {
                sb.append(phrase.charAt(i));
            } else {
                sb.append("_");
            }
            sb.append(" ");
        }

        targetWord.setText(sb.toString());

        lettersGuessed.setText(TextUtils.join(",", guessedCharacters));

        hangmanImg.setImageResource(hangmanDrawables[currentHangmanIndex]);
    }

    private void guess(char guess) {
        userInput.setText("");
        if (guessedCharacters.contains(guess)) {
            return;
        }
        guessedCharacters.add(guess);

        char[] phraseArray = phrase.toCharArray();
        boolean found = false;
        for (int i = 0; i < phraseArray.length; i++) {
            if (guess == Character.toLowerCase(phraseArray[i])) {
                guessed.set(i, true);
                found = true;
            }
        }
        if (!found) {
            currentHangmanIndex++;
        }

        if (hasWon()) {
            Toast.makeText(this, "You won", Toast.LENGTH_SHORT).show();
            userInput.setEnabled(false);
        } else if (hasLost()) {
            Toast.makeText(this, "You lost!", Toast.LENGTH_SHORT).show();
            userInput.setEnabled(false);
        }

        render();
    }

    private boolean hasWon() {
        return !guessed.contains(false);
    }

    private boolean hasLost() {
        return currentHangmanIndex >= 6;
    }
}
