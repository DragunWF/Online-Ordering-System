package com.example.online_ordering_system;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.Spinner;

import com.example.online_ordering_system.activities.CartActivity;
import com.example.online_ordering_system.activities.ProfileActivity;
import com.example.online_ordering_system.data.Product;
import com.example.online_ordering_system.utils.DatabaseHelper;
import com.example.online_ordering_system.utils.ProductAdapter;
import com.example.online_ordering_system.utils.SessionData;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ImageView profileView;
    private SearchView productSearchView;
    private Spinner productSpinner;
    private FloatingActionButton cartBtn;

    private RecyclerView productRecyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    private DatabaseHelper db;
    private List<Product> productList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DatabaseHelper(this);
        SessionData.initializeProductCache(this);

        profileView = findViewById(R.id.viewProfile);
        productSearchView = findViewById(R.id.productSearchView);
        productSpinner = findViewById(R.id.productSpinner);
        cartBtn = findViewById(R.id.cartBtn);

        profileView.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, ProfileActivity.class));
        });
        cartBtn.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, CartActivity.class));
        });

        productSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                productList = searchProducts(query);
                productRecyclerView.setAdapter(new ProductAdapter(MainActivity.this, productList));
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        setUpRecyclerView();
    }

    private List<Product> searchProducts(String name) {
        List<Product> result = new ArrayList<>();
        for (Product product : productList) {
            String[] words = product.getName().split(" ");
            for (String word : words) {
                if (name.equalsIgnoreCase(word)) {
                    result.add(product);
                    break;
                }
            }
        }
        return result;
    }

    private List<Product> filterProductsByCategory(String name) {
        List<Product> result = new ArrayList<>();
        for (Product product : productList) {
            // TODO: Implement product filtering by category
        }
        return result;
    }

    private void setUpRecyclerView() {
        productList = db.getProducts();

        productRecyclerView = findViewById(R.id.productsRecycleView);
        productRecyclerView.setHasFixedSize(true);

        layoutManager = new GridLayoutManager(this, 2);
        productRecyclerView.setLayoutManager(layoutManager);

        adapter = new ProductAdapter(this, productList);
        productRecyclerView.setAdapter(adapter);
    }
}