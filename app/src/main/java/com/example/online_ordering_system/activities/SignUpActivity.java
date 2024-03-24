package com.example.online_ordering_system.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.online_ordering_system.R;
import com.example.online_ordering_system.utils.AccountAuthentication;
import com.example.online_ordering_system.utils.Utils;

public class SignUpActivity extends AppCompatActivity {
    private ImageButton backBtn;
    private Button signUpSubmitBtn;

    private EditText usernameText;
    private EditText passwordText;
    private EditText fullNameText;
    private EditText emailText;
    private EditText mobileNumberText;
    private EditText addressText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        usernameText = findViewById(R.id.userName);
        passwordText = findViewById(R.id.passWord);
        fullNameText = findViewById(R.id.fullName);
        emailText = findViewById(R.id.email);
        mobileNumberText = findViewById(R.id.mobileNum);
        addressText = findViewById(R.id.address);

        backBtn = findViewById(R.id.backBtnSignUp);
        signUpSubmitBtn = findViewById(R.id.signUpSubmitBtn);

        backBtn.setOnClickListener(v -> {
            finish();
        });
        signUpSubmitBtn.setOnClickListener(v -> {
            // TODO: Set up Account Registration
            String username = Utils.getString(usernameText), password = Utils.getString(passwordText),
                    fullName = Utils.getString(fullNameText), email = Utils.getString(emailText),
                    mobileNumber = Utils.getString(mobileNumberText), address = Utils.getString(addressText);
            if (username.isEmpty()) {
                errorMessage("Username is empty!");
            } else if (AccountAuthentication.isAccountExists(username)) {
                errorMessage("Username is already taken!");
            } else if (password.length() < 8) {
                errorMessage("Password must at least be equal or greater than 8 characters!");
            } else if (email.isEmpty()) {
                errorMessage("Email is invalid!");
            } else if (fullName.isEmpty()) {
                errorMessage("Full name field is empty!");
            } else if (mobileNumber.isEmpty()) {
                errorMessage("Mobile number is invalid!");
            } else if (address.isEmpty()) {
                errorMessage("Address is empty!");
            } else {
                // TODO: Create Account
            }
        });
    }

    private void errorMessage(String message) {
        Utils.displayToast(this, message);
    }
}