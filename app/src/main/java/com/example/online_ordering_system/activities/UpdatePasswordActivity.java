package com.example.online_ordering_system.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.online_ordering_system.R;
import com.example.online_ordering_system.data.Customer;
import com.example.online_ordering_system.utils.DatabaseHelper;
import com.example.online_ordering_system.utils.SessionData;
import com.example.online_ordering_system.utils.Utils;

public class UpdatePasswordActivity extends AppCompatActivity {
    private EditText currentPass;
    private EditText newPass;
    private EditText repeatPass;
    private Button updatePassBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_password);

        DatabaseHelper db = new DatabaseHelper(this);

        currentPass = findViewById(R.id.currentPass);
        newPass = findViewById(R.id.newPass);
        repeatPass = findViewById(R.id.repeatPass);
        updatePassBtn = findViewById(R.id.updatePasswordBtn);

        updatePassBtn.setOnClickListener(v -> {
                Customer sData = SessionData.getCurrentUser();
                if  (String.valueOf(newPass.getText()).equals(String.valueOf(repeatPass.getText())) &&
                        String.valueOf(currentPass.getText()).equals(sData.getPassword())) {
                    db.updatePassword(String.valueOf(currentPass.getText()), String.valueOf(newPass.getText()));
                    toast("PASSWORD UPDATED");
                    startActivity(new Intent(UpdatePasswordActivity.this, ProfileActivity.class));
                } else if (!String.valueOf(newPass.getText()).equals(String.valueOf(repeatPass.getText()))){
                    toast("NEW PASSWORD AND REPEATED PASSWORD IS NOT THE SAME");
                } else if (!String.valueOf(currentPass.getText()).equals(sData.getPassword())) {
                    toast("YOUR CURRENT PASSWORD IS INVALID");
                }
        });
    }

    private void toast(String message) {
        Utils.toast(this, message);
    }
}