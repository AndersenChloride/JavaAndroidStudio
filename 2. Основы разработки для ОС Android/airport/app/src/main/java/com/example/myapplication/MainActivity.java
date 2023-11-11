package com.example.myapplication;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private Calendar calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editTextDate1 = findViewById(R.id.editTextDate1);
        EditText editTextDate2 = findViewById(R.id.editTextDate2);
        calendar = Calendar.getInstance();

        updateEditTextDate(editTextDate1);
        updateEditTextDate(editTextDate2);
        editTextDate1.setText("");
        editTextDate2.setText("");
    }

    private void updateEditTextDate(EditText ed) {

        final DatePickerDialog.OnDateSetListener dateSetListener = (view, year, monthOfYear, dayOfMonth) -> {
            calendar.set(Calendar.YEAR, year);
            calendar.set(Calendar.MONTH, monthOfYear);
            calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            updateLabel(ed);
        };

        ed.setOnClickListener(v -> {
            new DatePickerDialog(MainActivity.this, dateSetListener,
                    calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH),
                    calendar.get(Calendar.DAY_OF_MONTH)).show();
        });
        updateLabel(ed);
    }

    private void updateLabel(EditText ed) {
        String format = "dd.MM.yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.getDefault());
        ed.setText(sdf.format(calendar.getTime()));
    }
}