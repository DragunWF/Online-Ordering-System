package com.example.online_ordering_system;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class UpdatePassword extends AppCompatActivity {
    EditText currentPass;
    EditText newPass;
    EditText repeatPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_password);

        currentPass = findViewById(R.id.currentPass);
        newPass = findViewById(R.id.newPass);
        repeatPass = findViewById(R.id.repeatPass);

        currentPass.setOnFocusChangeListener((v, hasFocus) -> {

        });

        newPass.setOnFocusChangeListener((v, hasFocus) -> {

        });

        repeatPass.setOnFocusChangeListener((v, hasFocus) -> {

        });
    }
}