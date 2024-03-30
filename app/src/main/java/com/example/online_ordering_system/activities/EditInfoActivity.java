package com.example.online_ordering_system.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.online_ordering_system.R;
import com.example.online_ordering_system.data.Customer;
import com.example.online_ordering_system.utils.DatabaseHelper;
import com.example.online_ordering_system.utils.SessionData;
import com.example.online_ordering_system.utils.Utils;

public class EditInfoActivity extends AppCompatActivity {
    private EditText editEmailText;
    private EditText editMobileNumberText;
    private EditText editAddressText;

    private ImageView backBtn;
    private Button submitBtn;

    private Customer user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_info);

        user = SessionData.getCurrentUser();

        editEmailText = findViewById(R.id.editEmail);
        editMobileNumberText = findViewById(R.id.editMobileNum);
        editAddressText = findViewById(R.id.editAddress);

        backBtn = findViewById(R.id.editInfoBackBtn);
        submitBtn = findViewById(R.id.editInfoBtn);

        backBtn.setOnClickListener(v -> finish());

        submitBtn.setOnClickListener(v -> {
            String newEmail = Utils.getString(editEmailText);
            String newMobileNumber = Utils.getString(editMobileNumberText);
            String newAddress = Utils.getString(editAddressText);

            if (newEmail.equals(user.getEmail())) {
                toast("You are the using the same email!");
            } else if (newMobileNumber.equals(user.getMobileNumber())) {
                toast("You are using the same mobile number!");
            } else if (newAddress.equals(user.getAddress())) {
                toast("You are using the same address!");
            } else if (newEmail.isEmpty() && newMobileNumber.isEmpty() && newAddress.isEmpty()) {
                toast("All of the text fields are empty! Please fill at least one in...");
            } else {
                new DatabaseHelper(EditInfoActivity.this).updateInfo(
                        newEmail, newMobileNumber, newAddress
                );
                toast("Your account information has been updated!");
                updateProfileDetails(newEmail, newMobileNumber, newAddress);
                resetFields();
            }
        });
    }

    private void toast(String message) {
        Utils.toast(this, message);
    }

    private void resetFields() {
        editEmailText.setText("");
        editMobileNumberText.setText("");
        editAddressText.setText("");
    }

    public void updateProfileDetails(String email, String mobile, String address) {
        Intent intent = new Intent(EditInfoActivity.this, ProfileActivity.class);
        Customer userUpdate = SessionData.getCurrentUser();
        userUpdate.setEmail(email);
        userUpdate.setMobileNumber(mobile);
        userUpdate.setAddress(address);
        userUpdate.getEmail();
        userUpdate.getMobileNumber();
        userUpdate.getAddress();
        startActivity(intent);
    }
}