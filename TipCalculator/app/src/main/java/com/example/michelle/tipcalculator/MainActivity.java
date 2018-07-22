package com.example.michelle.tipcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import stanford.androidlib.SimpleActivity;


public class MainActivity extends SimpleActivity {

    private String displayText = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void buttonClick(View view) {
        TextView tv = (TextView) $((R.id.num_display));
        Button button = (Button) view;
        String buttonText = button.getText().toString();

        if (buttonText.equalsIgnoreCase("del")) {
            displayText = displayText.substring(0, displayText.length() - 1);
        } else if (buttonText.equalsIgnoreCase("clear")) {
            displayText = "";
        } else {
            displayText += buttonText;
        }

        tv.setText(displayText);

    }
}
