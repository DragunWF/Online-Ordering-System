package com.example.online_ordering_system.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.online_ordering_system.R;
import com.example.online_ordering_system.data.Customer;
import com.example.online_ordering_system.utils.SessionData;

public class ProfileActivity extends AppCompatActivity {
    private TextView usernameText;
    private TextView fullNameText;
    private TextView emailText;
    private TextView mobileNumberText;
    private TextView addressText;

    private Button editProfileBtn;
    private Button updatePasswordBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        usernameText = findViewById(R.id.profileUsername);
        fullNameText = findViewById(R.id.profileFullName);
        emailText = findViewById(R.id.profileEmail);
        mobileNumberText = findViewById(R.id.profileMobileNum);
        addressText = findViewById(R.id.profileAddress);

        editProfileBtn = findViewById(R.id.editProfile);
        updatePasswordBtn = findViewById(R.id.updatePassBtn);

        findViewById(R.id.backImageViewProfile).setOnClickListener(v -> {
            finish();
        });
        editProfileBtn.setOnClickListener(v -> {
            // TODO: Implement edit profile functionality
        });
        updatePasswordBtn.setOnClickListener(v -> {
            // TODO: Implement update password functionality
        });

        setProfileDetails();
    }

    @SuppressLint("SetTextI18n")
    private void setProfileDetails() {
        Customer user = SessionData.getCurrentUser();
        usernameText.setText("Username: " + user.getUsername());
        fullNameText.setText("Full Name: " + user.getFullName());
        emailText.setText("Email: " + user.getEmail());
        mobileNumberText.setText("Mobile Number: " + user.getMobileNumber());
        addressText.setText("Address: " + user.getAddress());
    }
}