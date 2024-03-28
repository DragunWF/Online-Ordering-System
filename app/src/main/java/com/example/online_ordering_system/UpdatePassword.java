package com.example.online_ordering_system;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class UpdatePassword extends AppCompatActivity {
    EditText currentPass;
    EditText newPass;
    EditText repeatPass;
    Button updatePassBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_password);

        currentPass = findViewById(R.id.currentPass);
        newPass = findViewById(R.id.newPass);
        repeatPass = findViewById(R.id.repeatPass);
        updatePassBtn = findViewById(R.id.updatePasswordBtn);

        currentPass.setOnFocusChangeListener((v, hasFocus) -> {
            if(hasFocus) {
                currentPass.setText("");
            }
        });

        newPass.setOnFocusChangeListener((v, hasFocus) -> {
            if(hasFocus) {
                newPass.setText("");
            }
        });

        repeatPass.setOnFocusChangeListener((v, hasFocus) -> {
            if(hasFocus) {
                repeatPass.setText("");
            }
        });

        updatePassBtn.setOnClickListener(v -> {
            String.valueOf(currentPass.getText());
            if (String.valueOf(newPass.getText()) == String.valueOf(repeatPass.getText())) {

            }
        });
    }
}