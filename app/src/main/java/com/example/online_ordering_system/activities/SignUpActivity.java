package com.example.online_ordering_system.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.online_ordering_system.R;

public class SignUpActivity extends AppCompatActivity {
    private ImageButton backBtn;
    private Button signUpSubmitBtn;

    private EditText usernameText;
    private EditText passwordText;
    private EditText fullNameText;
    private EditText emailText;
    private EditText mobileNumText;
    private EditText addressText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        usernameText = findViewById(R.id.userName);
        passwordText = findViewById(R.id.passWord);
        fullNameText = findViewById(R.id.fullName);
        emailText = findViewById(R.id.email);
        mobileNumText = findViewById(R.id.mobileNum);
        addressText = findViewById(R.id.address);

        backBtn = findViewById(R.id.backBtnSignUp);
        signUpSubmitBtn = findViewById(R.id.signUpSubmitBtn);

        backBtn.setOnClickListener(v -> {
            finish();
        });
        signUpSubmitBtn.setOnClickListener(v -> {
            // TODO: Set up Account Registration
        });
    }
}