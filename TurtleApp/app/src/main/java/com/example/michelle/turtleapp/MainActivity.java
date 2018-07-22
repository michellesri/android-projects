package com.example.michelle.turtleapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import stanford.androidlib.SimpleActivity;

public class MainActivity extends SimpleActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void radioClick(View view) {
        int id = view.getId();
        ImageView img = $(R.id.png);
        if (id == R.id.leo_button) {
            img.setImageResource(R.drawable.tmnt_png);

        } else if (id == R.id.raichu_button) {
            img.setImageResource(R.drawable.raichu);

        } else if (id == R.id.don_button) {
            img.setImageResource(R.drawable.tmnt_don);

        }
    }
}
