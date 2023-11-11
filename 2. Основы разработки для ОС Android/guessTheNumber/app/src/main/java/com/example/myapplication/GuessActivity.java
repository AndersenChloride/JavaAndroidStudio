package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class GuessActivity extends AppCompatActivity {

    private TextView txtGuess;
    private TextView question;
    private Button btnLower;
    private Button btnHigher;
    private Button rightGuess;
    private Button origin;

    private int start;
    private int end;
    private int guess;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guess);

        txtGuess = findViewById(R.id.txt_guess);
        btnLower = findViewById(R.id.btn_lower);
        btnHigher = findViewById(R.id.btn_higher);
        rightGuess = findViewById(R.id.right_guess);
        question = findViewById(R.id.question);
        origin = findViewById(R.id.origin);

        Intent intent = getIntent();
        start = intent.getIntExtra("start", 0);
        end = intent.getIntExtra("end", 100);
        guess = guessNumber(start, end);
        txtGuess.setText(String.valueOf(guess));

        btnLower.setOnClickListener(v -> {
            end = guess - 1;
            if (start <= end) {
                guess = guessNumber(start, end);
                txtGuess.setText(String.valueOf(guess));
            } else {
                question.setText("Ошибка. Возможные значения закончились");
                btnLower.setEnabled(false);
                btnHigher.setEnabled(false);
                rightGuess.setEnabled(false);
            }
        });

        rightGuess.setOnClickListener(v -> {
                question.setText("Ура!! Я угадал!");
                btnLower.setEnabled(false);
                btnHigher.setEnabled(false);
                rightGuess.setEnabled(false);
        });

        btnHigher.setOnClickListener(v -> {
            start = guess + 1;
            if (start <= end) {
                guess = guessNumber(start, end);
                txtGuess.setText(String.valueOf(guess));
            } else {
                question.setText("Ошибка. Возможные значения закончились");
                btnLower.setEnabled(false);
                btnHigher.setEnabled(false);
                rightGuess.setEnabled(false);
            }
        });

        origin.setOnClickListener(v -> {
            Intent origin = new Intent(GuessActivity.this, MainActivity.class);
            startActivity(origin);
        });
    }

    private int guessNumber(int start, int end) {
        Random random = new Random();
        return random.nextInt(end - start + 1) + start;
    }
}