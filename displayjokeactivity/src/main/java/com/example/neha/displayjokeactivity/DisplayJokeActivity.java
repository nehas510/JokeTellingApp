package com.example.neha.displayjokeactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DisplayJokeActivity extends AppCompatActivity {


    public static String JOKE_KEY = "Joke key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_joke);

        Intent intent = getIntent();
        String joke = intent.getStringExtra(JOKE_KEY);

        TextView jokeTextView = (TextView) findViewById(R.id.textViewJoke);
        if (joke != null && joke.length() != 0) {
            jokeTextView.setText(joke);
        }
    }
}
