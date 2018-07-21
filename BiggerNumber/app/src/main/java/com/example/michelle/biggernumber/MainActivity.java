package com.example.michelle.biggernumber;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import stanford.androidlib.SimpleActivity;

public class MainActivity extends SimpleActivity {
    private int points;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        points = 0;

        pickRandomNumbers();

    }

    private void pickRandomNumbers() {
        // pick random numbers
        Random rand = new Random();
        int rand1 = rand.nextInt(10);
        int rand2 = 0;

        // no duplicate numbers
        while (true) {
            rand2 = rand.nextInt(10);
            if (rand2 != rand1) {
                break;
            }
        }

        $B(R.id.left_button).setText(Integer.toString(rand1));
        $B(R.id.right_button).setText(Integer.toString(rand2));
    }

    private int[] getRandoms() {
        Button leftButton = $(R.id.left_button);
        Button rightButton = $(R.id.right_button);

        String leftText = leftButton.getText().toString();
        String rightText = rightButton.getText().toString();

        int rand1 = Integer.parseInt(leftText);
        int rand2 = Integer.parseInt(rightText);

        return new int[] {rand1, rand2};
    }

    public void changePoints(String string) {

        int previousPoints = points;
        int rand1 = getRandoms()[0];
        int rand2 = getRandoms()[1];
        if (string.equals("left")) {
            if (rand1 > rand2) {
                points++;
            } else {
                points--;
            }
        } else if (string.equals("right")){
            if (rand2 > rand1) {
                points++;
            } else {
                points--;
            }
        }

        String toastText = (previousPoints < points) ? "Nice!" : "Awww";
        toast(toastText);
    }

    public void buttonClick(View view) {
        Button leftButton = (Button) $(R.id.left_button);
        Button rightButton = (Button) $(R.id.right_button);
        TextView tv = (TextView) $((R.id.points_field));

        if (view == leftButton) {
            changePoints("left");

        } else if (view == rightButton) {
            changePoints("right");
        }

        tv.setText("Points: " + points);
        pickRandomNumbers();

    }
}
