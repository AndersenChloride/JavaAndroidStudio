package com.example.puzzlecolortiles;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

public class MenuActivity extends Activity {

    private long timeLeftInMillis = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_menu);
    }

    public void startGame(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void startTimedGame(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        timeLeftInMillis = 5 * 60 * 1000;
        intent.putExtra("timeLeftInMillis", timeLeftInMillis);
        startActivity(intent);
        finish();
    }
}
