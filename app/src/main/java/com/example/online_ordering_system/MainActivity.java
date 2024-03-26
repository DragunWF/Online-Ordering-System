package com.example.online_ordering_system;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.Spinner;

import com.example.online_ordering_system.activities.ProfileActivity;

public class MainActivity extends AppCompatActivity {
    private ImageView profileView;
    private SearchView productSearchView;
    private Spinner productSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        profileView = findViewById(R.id.viewProfile);
        productSearchView = findViewById(R.id.productSearchView);
        productSpinner = findViewById(R.id.productSpinner);

        profileView.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, ProfileActivity.class));
        });
    }
}