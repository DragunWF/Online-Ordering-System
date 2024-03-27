package com.example.online_ordering_system.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.online_ordering_system.R;
import com.example.online_ordering_system.data.Product;
import com.example.online_ordering_system.utils.SessionData;
import com.example.online_ordering_system.utils.Utils;

public class ItemsActivity extends AppCompatActivity {
    private int productId;

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

        setItemDetails();
        setButtons();
    }

    private void modifyQuantity(boolean isAdd) {
        String quantityStr = String.valueOf(quantityText.getText()).split(": ")[1];
        int currentQuantity = Integer.parseInt(quantityStr);
        if (isAdd) {
            currentQuantity++;
        } else {
            currentQuantity--;
            if (currentQuantity < 0) {
                currentQuantity = 0;
            }
        }
        quantityText.setText("Quantity: " + currentQuantity);
    }

    @SuppressLint("SetTextI18n")
    private void setItemDetails() {
        try {
            Bundle bundle = getIntent().getExtras();
            assert bundle != null;
            productId = bundle.getInt("id");
            Product product = Utils.getProductById(productId);
            assert product != null;

            itemNameText.setText(product.getName());
            itemDescriptionText.setText(product.getDescription());
            itemPriceText.setText(product.getPrice() + " PHP");
            itemStockText.setText("Stock: " + product.getStock());
        } catch (Exception error) {
            Utils.toast(this, "Something went wrong trying to display the item details!");
        }
    }

    private void setButtons() {
        plusBtn.setOnClickListener(v -> {
            modifyQuantity(true);
        });
        minusBtn.setOnClickListener(v -> {
            modifyQuantity(false);
        });
        buyBtn.setOnClickListener(v -> {
            Intent intent = new Intent(ItemsActivity.this, CheckoutActivity.class);
            intent.putExtra("id", productId);
            startActivity(intent);
        });
        addToCartBtn.setOnClickListener(v -> {
            // TODO: Implement add to cart functionality
            SessionData.addCartItem(Utils.getProductById(productId));
            startActivity(new Intent(ItemsActivity.this, CartActivity.class));
        });
    }
}