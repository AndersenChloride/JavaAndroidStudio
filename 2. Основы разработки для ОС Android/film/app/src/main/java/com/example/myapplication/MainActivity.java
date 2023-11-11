package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    List<Movie> movies = new ArrayList<>();
    TextView A;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        A = findViewById(R.id.textView);
        loadMoviesFromJson();
    }
    public void clickButton(View v) {
        if (movies != null && movies.size() > 0 ) {
            Random random = new Random();
            int index = random.nextInt(movies.size());
            A.setText("");
            A.append("Фильм: " + movies.get(index).getTitle() + "\n" +
                    "Год выпуска: " + movies.get(index).getYear() + "\n" +
                    "Режиссёр: " + movies.get(index).getAuthor() + "\n" +
                    "Продолжительность: " + movies.get(index).getDurationMin()+ " мин" + "\n" +
                    "Жанры: " + movies.get(index).getGenre() + "\n" + "\n" +
                    "Описание: " + movies.get(index).getAnnotation() + "\n");
            movies.remove(index);
        }else{
            A.setText("");
            A.setText("Фильмы закончились.");
        }
    }
    private void loadMoviesFromJson() {
        try {
            InputStream stream = getAssets().open("films.json");
            InputStreamReader reader = new InputStreamReader(stream);
            Gson gson = new Gson();
            MoviesWrapper moviesWrapper = gson.fromJson(reader, MoviesWrapper.class);
            movies.addAll(moviesWrapper.getMovies());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}