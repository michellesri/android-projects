package com.example.michelle.tipcalculator;

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
        disableButtons();
    }

    public void disableButtons() {
        $(R.id.fifteen_percent).setEnabled(false);
        $(R.id.eighteen_percent).setEnabled(false);
        $(R.id.twenty_percent).setEnabled(false);
    }

    public void enableButtons() {
        $(R.id.fifteen_percent).setEnabled(true);
        $(R.id.eighteen_percent).setEnabled(true);
        $(R.id.twenty_percent).setEnabled(true);
    }

    public void buttonClick(View view) {
        TextView tv = $(R.id.num_display);
        Button button = (Button) view;
        String buttonText = button.getText().toString();
        Button periodButton = $(R.id.period_button);
        periodButton.setEnabled(true);
        enableButtons();


        if (displayText.contains(".") && buttonText.equalsIgnoreCase(".")) {
            button.setEnabled(false);
        } else if (buttonText.equalsIgnoreCase("del")) {
            displayText = displayText.substring(0, displayText.length() - 1);
        } else if (buttonText.equalsIgnoreCase("clear")) {
            displayText = "";
            disableButtons();
        } else if (buttonText.equalsIgnoreCase("15%") ||
                buttonText.equalsIgnoreCase("18%") ||
                buttonText.equalsIgnoreCase("20%")) {

            buttonText = buttonText.substring(0, buttonText.length() - 1);
            Double displayTextFloat = Double.parseDouble(displayText);
            Double total = (displayTextFloat * Float.parseFloat(buttonText) * .01);
            tv.setText(Double.toString(total));
            displayText = "";
            disableButtons();
            return;

        } else {
            displayText += buttonText;
        }

        tv.setText(displayText);

    }
}
