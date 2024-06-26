package com.example.online_ordering_system;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
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
    private RecyclerView.Adapter productRecyclerAdapter;
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

        setProductSpinner();
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
        for (Product product : SessionData.getProductList()) {
            if (SessionData.getCategoryNameById(product.getCategoryID()).equalsIgnoreCase(name)) {
                result.add(product);
            }
        }
        return result;
    }

    private void setProductSpinner() {
        List<String> spinnerChoices = new ArrayList<>(SessionData.getCategoryNames());
        spinnerChoices.add(0, "Any");
        productSpinner = findViewById(R.id.productSpinner);
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(
                this, android.R.layout.simple_spinner_item, spinnerChoices
        );
        spinnerAdapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        productSpinner.setAdapter(spinnerAdapter);

        productSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position != 0) {
                    String selectedCategory = (String) parent.getItemAtPosition(position);
                    productList = filterProductsByCategory(selectedCategory);
                    productRecyclerView.setAdapter(new ProductAdapter(MainActivity.this, productList));
                } else {
                    productList = SessionData.getProductList();
                    productRecyclerView.setAdapter(new ProductAdapter(MainActivity.this, productList));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                productList = db.getProducts();
                productRecyclerView.setAdapter(new ProductAdapter(MainActivity.this, productList));
            }
        });
    }

    private void setUpRecyclerView() {
        productList = db.getProducts();

        productRecyclerView = findViewById(R.id.productsRecycleView);
        productRecyclerView.setHasFixedSize(true);

        layoutManager = new GridLayoutManager(this, 2);
        productRecyclerView.setLayoutManager(layoutManager);

        productRecyclerAdapter = new ProductAdapter(this, productList);
        productRecyclerView.setAdapter(productRecyclerAdapter);
    }
}