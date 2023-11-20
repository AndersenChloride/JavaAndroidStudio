package com.example.radiobuttonuri;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private RadioGroup radioGroup;
    private Button btnCall;
    int selectedId = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        radioGroup = findViewById(R.id.radioGroup);
        btnCall = findViewById(R.id.btnCall);

        btnCall.setOnClickListener(view -> handleCall());


        for (int i = 0; i < radioGroup.getChildCount(); i++) {
            RadioButton radioButton = (RadioButton) radioGroup.getChildAt(i);
            radioButton.setOnClickListener(v -> {
                if (radioGroup.getCheckedRadioButtonId() == selectedId) {
                    radioGroup.clearCheck();
                }
                selectedId = radioGroup.getCheckedRadioButtonId();
            });
        }
    }

    private void handleCall() {
        String input = editText.getText().toString();


        if (selectedId == -1) {
            if (isValidUrl(input)) {
                openWebPage(input);
            } else if (isValidLocation(input)) {
                openMap(input);
            } else if (isValidPhoneNumber(input)) {
                makePhoneCall(input);
            } else {
                showToast("Неверный ввод");
            }
        } else {

            RadioButton radioButton = findViewById(selectedId);
            String str = radioButton.getText().toString();

            switch (str) {
                case "Веб-адрес":
                    if (isValidUrl(input)) {
                        openWebPage(input);
                        break;
                    } if(isValidLocation(input) || isValidPhoneNumber(input)){
                        showToast("Неверный ввод или выбор");
                    } else{
                    showToast("Неверный ввод");}
                    break;
                case "Координаты":
                    if (isValidLocation(input)) {
                        openMap(input);
                        break;
                    } if(isValidUrl(input) || isValidPhoneNumber(input)){
                        showToast("Неверный ввод или выбор");
                    } else{
                        showToast("Неверный ввод");
                    }
                    break;
                case "Телефон":
                    if (isValidPhoneNumber(input)) {
                        makePhoneCall(input);
                        break;
                    } if(isValidUrl(input) || isValidLocation(input)){
                        showToast("Неверный ввод или выбор");
                    } else{
                        showToast("Неверный ввод");
                    }
                    break;
            }
        }
    }

    private boolean isValidUrl(String text) {
        return android.util.Patterns.WEB_URL.matcher(text).matches();
    }

    private boolean isValidLocation(String text) {
        String doubleValuesRegex = "^[-+]?\\d*\\.?\\d+\\s+[-+]?\\d*\\.?\\d+$";
        return text.matches(doubleValuesRegex);
    }

    private boolean isValidPhoneNumber(String text) {
        String phoneNumberRegex = "^(\\+7|8)[0-9]{10}$";
        text = text.replaceAll("\\s", "");
        return text.matches(phoneNumberRegex);
    }

    private void openWebPage(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }

    private void openMap(String location) {
        String[] coordinates = location.split(" ");

        double latitude = Double.parseDouble(coordinates[0]);
        double longitude = Double.parseDouble(coordinates[1]);

        Uri map = Uri.parse("geo:" + latitude + "," + longitude + "?q=" + latitude + "," + longitude);
        Intent intent = new Intent(Intent.ACTION_VIEW, map);
        startActivity(intent);
    }

    private void makePhoneCall(String phoneNumber) {
        showToast("Осуществляю звонок по телефону " + phoneNumber);
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

}