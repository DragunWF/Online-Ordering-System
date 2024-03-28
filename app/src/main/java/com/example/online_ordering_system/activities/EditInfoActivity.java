package com.example.online_ordering_system.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.online_ordering_system.R;
import com.example.online_ordering_system.data.Customer;
import com.example.online_ordering_system.utils.SessionData;
import com.example.online_ordering_system.utils.Utils;

public class EditInfoActivity extends AppCompatActivity {
    private EditText editEmailText;
    private EditText editMobileNumberText;
    private EditText editAddressText;
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
        submitBtn = findViewById(R.id.editInfoBtn);

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
                // TODO: Implement update in the database!
            }
        });
    }

    private void toast(String message) {
        Utils.toast(this, message);
    }
}