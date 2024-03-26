package com.example.online_ordering_system.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.online_ordering_system.R;

public class ItemsActivity extends AppCompatActivity {
    private TextView itemNameText;
    private TextView itemPriceText;
    private TextView itemStockText;
    private TextView itemDescriptionText;
    private TextView quantityText;

    private ImageView plusBtn;
    private ImageView minusBtn;

    private Button buyBtn;
    private Button addToCartBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items);

        itemNameText = findViewById(R.id.nameOfItem);
        itemPriceText = findViewById(R.id.priceOfItem);
        itemStockText = findViewById(R.id.numOfStockItem);
        itemDescriptionText = findViewById(R.id.descriptionOfItem);
        quantityText = findViewById(R.id.quantityOfItem);

        plusBtn = findViewById(R.id.plusForItem);
        minusBtn = findViewById(R.id.minusForItem);
        buyBtn = findViewById(R.id.itemBuyNowBtn);
        addToCartBtn = findViewById(R.id.itemAddToCartBtn);

        plusBtn.setOnClickListener(v -> {
            modifyQuantity(true);
        });
        minusBtn.setOnClickListener(v -> {
            modifyQuantity(false);
        });
        buyBtn.setOnClickListener(v -> {
            // TODO: Implement buy now functionality
        });
        addToCartBtn.setOnClickListener(v -> {
            // TODO: Implement add to cart functionality
        });

        setItemDetails();
    }

    private void modifyQuantity(boolean isAdd) {
        int currentQuantity = Integer.parseInt(String.valueOf(quantityText.getText()));
        if (isAdd) {
            currentQuantity++;
        } else {
            currentQuantity--;
        }
        quantityText.setText(String.valueOf(currentQuantity));
    }

    private void setItemDetails() {

    }
}