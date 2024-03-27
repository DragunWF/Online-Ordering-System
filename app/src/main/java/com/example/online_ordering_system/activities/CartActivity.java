package com.example.online_ordering_system.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import com.example.online_ordering_system.R;
import com.example.online_ordering_system.utils.CartAdapter;
import com.example.online_ordering_system.utils.SessionData;

public class CartActivity extends AppCompatActivity {
    private ImageView backBtn;
    private Button checkOutBtn;

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        backBtn = findViewById(R.id.cartBackBtn);
        checkOutBtn = findViewById(R.id.checkOutBtn);

        backBtn.setOnClickListener(v -> {
            finish();
        });
        checkOutBtn.setOnClickListener(v -> {
            Intent intent = new Intent(CartActivity.this, CheckoutActivity.class);
            // TODO: Implement checkout functionality
            startActivity(intent);
        });

        setUpRecyclerView();
    }

    private void setUpRecyclerView() {
        recyclerView = findViewById(R.id.recycleViewCart);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new CartAdapter(SessionData.getItemCart());
        recyclerView.setAdapter(adapter);
    }
}