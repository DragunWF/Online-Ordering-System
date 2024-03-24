package com.example.online_ordering_system.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.online_ordering_system.R;

public class LoginActivity extends AppCompatActivity {
    private ImageButton backBtn;
    private Button signInBtn;

    private EditText usernameText;
    private EditText passwordText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        backBtn = findViewById(R.id.backBtn);
        signInBtn = findViewById(R.id.signInBtn);
        usernameText = findViewById(R.id.loginUsername);
        passwordText = findViewById(R.id.loginPassword);

        backBtn.setOnClickListener(v -> {
            finish();
        });
        signInBtn.setOnClickListener(v -> {
            // TODO: Login Authentication
        });
    }
}