package com.example.online_ordering_system.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.online_ordering_system.R;
import com.example.online_ordering_system.data.Customer;
import com.example.online_ordering_system.utils.DatabaseHelper;
import com.example.online_ordering_system.utils.SessionData;

public class UpdatePasswordActivity extends AppCompatActivity {
    EditText currentPass;
    EditText newPass;
    EditText repeatPass;
    Button updatePassBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_password);

        DatabaseHelper db = new DatabaseHelper(UpdatePasswordActivity.this);

        currentPass = findViewById(R.id.currentPass);
        newPass = findViewById(R.id.newPass);
        repeatPass = findViewById(R.id.repeatPass);
        updatePassBtn = findViewById(R.id.updatePasswordBtn);

        currentPass.setOnClickListener( v -> {

        });

        newPass.setOnClickListener( v -> {

        });

        repeatPass.setOnClickListener(v -> {

        });

        updatePassBtn.setOnClickListener(v -> {
                Customer sData = SessionData.getCurrentUser();
                if  (String.valueOf(newPass.getText()).equals(String.valueOf(repeatPass.getText())) &&
                        String.valueOf(currentPass.getText()).equals(sData.getPassword())) {
                        db.updatePassword(String.valueOf(currentPass.getText()), String.valueOf(newPass.getText()));
                        Toast.makeText(this, "PASSWORD UPDATED", Toast.LENGTH_LONG).show();
                } else if (!String.valueOf(newPass.getText()).equals(String.valueOf(repeatPass.getText()))){
                    Toast.makeText(this, "NEW PASSWORD AND REPEATED PASSWORD IS NOT THE SAME", Toast.LENGTH_LONG).show();
                } else if (!String.valueOf(currentPass.getText()).equals(sData.getPassword())) {
                    Toast.makeText(this, "YOUR CURRENT PASSWORD IS INVALID", Toast.LENGTH_LONG).show();
                }
        });
    }
}