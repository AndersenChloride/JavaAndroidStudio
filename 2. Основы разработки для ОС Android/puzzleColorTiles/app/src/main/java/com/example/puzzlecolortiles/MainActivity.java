package com.example.puzzlecolortiles;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int darkColor;
    int brightColor;
    View[][] tiles = new View[4][4];
    int clickCount = 0;
    TextView textViewClickCount;
    private CountDownTimer countDownTimer;
    long timeLeftInMillis = 0;

    private final long countdownInterval = 1000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        darkColor = ContextCompat.getColor(this, R.color.dark);
        brightColor = ContextCompat.getColor(this, R.color.bright);
        textViewClickCount = findViewById(R.id.count);
        TextView textViewTimer = findViewById(R.id.textViewTimer);
        textViewClickCount.setText("Количество нажатий: 0");
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("timeLeftInMillis")) {
            timeLeftInMillis = intent.getLongExtra("timeLeftInMillis", 0);
        }

        countDownTimer = new CountDownTimer(timeLeftInMillis, countdownInterval) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMillis = millisUntilFinished;
                updateTimerText(textViewTimer);
            }

            @Override
            public void onFinish() {
                if (timeLeftInMillis > 0) {
                    showToast("Время вышло!");
                }
            }
        };



        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                String buttonId = "t" + i + "_" + j;
                int resId = getResources().getIdentifier(buttonId, "id", getPackageName());
                tiles[i][j] = findViewById(resId);
            }
        }
        randomizeTilesColor();
        countDownTimer.start();
    }

    public void refresh(View view) {
        randomizeTilesColor();
        clickCount = 0;
        updateClickCount();
    }

    private void updateTimerText(TextView textViewTimer) {
        long seconds = timeLeftInMillis / 1000;
        textViewTimer.setText("Осталось времени: " + seconds + " сек");
    }

    public void onClick(View v) {
        clickCount++;
        updateClickCount();
        int row = 0, col = 0;
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[i].length; j++) {
                if (tiles[i][j] == v) {
                    row = i;
                    col = j;
                    break;
                }
            }
        }
        changeColor(v);
        for (int i = 0; i < 4; i++) {
            changeColor(tiles[row][i]);
            changeColor(tiles[i][col]);
        }
        if (checkForWin()){
            showToast("Вы выиграли!\n" +
                    "Ваш результат: "+ clickCount + " нажатий");
        }
    }

    private void updateClickCount() {
        textViewClickCount.setText("Количество нажатий: " + clickCount);
    }

    public void changeColor(View v) {
        ColorDrawable d = (ColorDrawable) v.getBackground();
        if (d.getColor() == brightColor) {
            v.setBackgroundColor(darkColor);
        } else {
            v.setBackgroundColor(brightColor);
        }
    }

    private void randomizeTilesColor() {
        Random random = new Random();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                boolean isDark = random.nextBoolean();
                if (tiles[i][j] != null) {
                    if (isDark) {
                        tiles[i][j].setBackgroundColor(darkColor);
                    } else {
                        tiles[i][j].setBackgroundColor(brightColor);
                    }
                }
            }
        }
    }

    private boolean checkForWin() {
        ColorDrawable referenceDrawable = (ColorDrawable) tiles[0][0].getBackground();
        int referenceColor = referenceDrawable.getColor();
        ColorDrawable cellDrawable;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                cellDrawable = (ColorDrawable) tiles[i][j].getBackground();
                if (cellDrawable.getColor() != referenceColor) {
                    return false;
                }
            }
        }
        return true;
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }


}
