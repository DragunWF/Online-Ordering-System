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

import java.util.Objects;

public class ItemsActivity extends AppCompatActivity {
    private int productId;
    private double basePrice;
    private int currentQuantity = 1;

    private TextView itemNameText;
    private TextView itemPriceText;
    private TextView itemStockText;
    private TextView itemDescriptionText;
    private TextView quantityText;

    private ImageView plusBtn;
    private ImageView minusBtn;
    private ImageView backBtn;

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
        backBtn = findViewById(R.id.itemBackBtn);

        buyBtn = findViewById(R.id.itemBuyNowBtn);
        addToCartBtn = findViewById(R.id.itemAddToCartBtn);

        setItemDetails();
        setButtons();
    }

    @SuppressLint("SetTextI18n")
    private void modifyQuantity(boolean isAdd) {
        currentQuantity = Integer.parseInt(extractNum(quantityText));
        int availableStock = Integer.parseInt(extractNum(itemStockText));

        if (isAdd && currentQuantity < availableStock) {
            currentQuantity++;
        } else {
            currentQuantity--;
            if (currentQuantity < 0) {
                currentQuantity = 0;
            }
        }

        quantityText.setText("Quantity: " + currentQuantity);
        itemPriceText.setText(Utils.round(basePrice * currentQuantity) + " PHP");
    }

    @SuppressLint("SetTextI18n")
    private void setItemDetails() {
        try {
            Bundle bundle = getIntent().getExtras();
            assert bundle != null;
            productId = bundle.getInt("id");
            Product product = Utils.getProductById(productId);
            assert product != null;
            basePrice = Utils.round(product.getPrice());

            quantityText.setText("Quantity: 1");
            itemNameText.setText(product.getName());
            itemDescriptionText.setText(product.getDescription());
            itemPriceText.setText(basePrice + " PHP");
            itemStockText.setText("Stock: " + product.getStock());
        } catch (Exception error) {
            Utils.toast(this, "Something went wrong trying to display the item details!");
        }
    }

    private void setButtons() {
        backBtn.setOnClickListener(v -> {
            finish();
        });
        plusBtn.setOnClickListener(v -> {
            modifyQuantity(true);
        });
        minusBtn.setOnClickListener(v -> {
            modifyQuantity(false);
        });
        buyBtn.setOnClickListener(v -> {
            if (currentQuantity > 0) {
                Intent intent = new Intent(ItemsActivity.this, CheckoutActivity.class);
                intent.putExtra("id", productId);
                intent.putExtra("buyType", "single");
                startActivity(intent);
            } else {
                Utils.toast(ItemsActivity.this, "Quantity must at least be equal or greater to 1!");
            }
        });
        addToCartBtn.setOnClickListener(v -> {
            if (currentQuantity > 0) {
                try {
                    Intent intent = new Intent(ItemsActivity.this, CartActivity.class);
                    Product product = Utils.getProductById(productId);
                    assert product != null;
                    product.setQuantity(currentQuantity);
                    SessionData.getItemCart().add(product);
                    startActivity(intent);
                } catch (NullPointerException err) {
                    Utils.toast(ItemsActivity.this, "Something went wrong trying to process your order!");
                }
            } else {
                Utils.toast(ItemsActivity.this, "Quantity to buy cannot be 0!");
            }
        });
    }

    private String extractNum(TextView text) {
        return String.valueOf(text.getText()).split(": ")[1];
    }
}