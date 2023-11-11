package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    int start;
    int end;
    private EditText editStart;
    private EditText editEnd;
    private Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editStart = findViewById(R.id.edit_start);
        editEnd = findViewById(R.id.edit_end);
        btn = findViewById(R.id.btn_next);

        btn.setOnClickListener(v -> {

            if (editStart.getText().toString().isEmpty()) {
                start = 0;
            }else{
                start = Integer.parseInt(editStart.getText().toString());
            }

            if (editEnd.getText().toString().isEmpty()) {
                end = 100;
            }else{
                end = Integer.parseInt(editEnd.getText().toString());
            }

            Intent intent = new Intent(MainActivity.this, GuessActivity.class);
            intent.putExtra("start", start);
            intent.putExtra("end", end);
            startActivity(intent);
        });
    }
}