package com.example.michelle.todolist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import stanford.androidlib.SimpleActivity;

public class MainActivity extends SimpleActivity {

    private ArrayList<String> todoItems = new ArrayList<>();

    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, todoItems);
        ListView listView = $LV(R.id.todo_list);
        listView.setAdapter(adapter);
    }

    public void addItemClick(View view) {

        EditText editText = $ET(R.id.user_input);

        String userInput = editText.getText().toString();

        if (userInput.length() > 0) {
            adapter.add(userInput);

            editText.setText("");
        }

        ListView listView = $LV(R.id.todo_list);

    }
}

// remove items
    // make check mark appear or confirmation of complete
        // swipe to the right?

// clear all todo items?
