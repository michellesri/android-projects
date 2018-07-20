package com.example.michelle.biggernumber;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
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

        Button leftButton = (Button) findViewById(R.id.left_button);
        leftButton.setText(Integer.toString(rand1));
        Button rightButton = (Button) findViewById(R.id.right_button);
        rightButton.setText(Integer.toString(rand2));
    }

    private int[] getRandoms() {
        Button leftButton = (Button) findViewById(R.id.left_button);
        Button rightButton = (Button) findViewById(R.id.right_button);

        String leftText = leftButton.getText().toString();
        String rightText = rightButton.getText().toString();

        int rand1 = Integer.parseInt(leftText);
        int rand2 = Integer.parseInt(rightText);

        return new int[] {rand1, rand2};
    }

    public void leftButtonClick(View view) {

        int rand1 = getRandoms()[0];
        int rand2 = getRandoms()[1];

        if (rand1 > rand2) {
            points++;
        } else {
            points--;
        }
        TextView tv = (TextView) findViewById((R.id.points_field));
        tv.setText("Points: " + points);
        pickRandomNumbers();
    }

    public void rightButtonClick(View view) {

        int rand1 = getRandoms()[0];
        int rand2 = getRandoms()[1];

        if (rand2 > rand1) {
            points++;
        } else {
            points--;
        }
        TextView tv = (TextView) findViewById((R.id.points_field));
        tv.setText("Points: " + points);
        pickRandomNumbers();
    }
}
