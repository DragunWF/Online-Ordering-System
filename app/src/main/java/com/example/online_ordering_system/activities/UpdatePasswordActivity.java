package com.example.online_ordering_system.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.online_ordering_system.R;
import com.example.online_ordering_system.data.Customer;
import com.example.online_ordering_system.utils.DatabaseHelper;

public class UpdatePasswordActivity extends AppCompatActivity {
    private EditText currentPass;
    private EditText newPass;
    private EditText repeatPass;
    private Button updatePassBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_password);

        DatabaseHelper db = new DatabaseHelper(UpdatePasswordActivity.this);

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
            Customer customer = new Customer();
                if  (String.valueOf(newPass.getText()) == String.valueOf(repeatPass.getText()) &&
                    String.valueOf(currentPass.getText()) != String.valueOf(newPass.getText()) &&
                    String.valueOf(currentPass.getText()) != String.valueOf(repeatPass.getText())) {
                        db.updatePassword(customer.getPassword());
                        Toast.makeText(this, "PASSWORD UPDATED", Toast.LENGTH_LONG).show();
                } else if (String.valueOf(newPass.getText()) != String.valueOf(repeatPass.getText())){
                    Toast.makeText(this, "NEW PASSWORD AND REPEATED PASSWORD IS NOT THE SAME", Toast.LENGTH_LONG).show();
                }
        });
    }
}