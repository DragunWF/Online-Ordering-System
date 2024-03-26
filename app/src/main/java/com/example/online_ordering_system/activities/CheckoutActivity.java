package com.example.online_ordering_system.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.online_ordering_system.R;

public class CheckoutActivity extends AppCompatActivity {
    // Customer Details
    private TextView customerNameText;
    private TextView customerMobileNumberText;
    private TextView customerEmailText;
    private TextView customerAddressText;

    // Product Details
    private TextView productNameText;
    private TextView productQuantityText;
    private TextView productPriceText;

    // Mode of Payment
    private RadioButton cashOnDeliveryBtn;
    private RadioButton cardPaymentBtn ;

    // Miscellaneous
    private TextView totalItemPriceText;
    private TextView shippingFeeText;
    private TextView totalAmountText;

    private TextView confirmOrderBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        customerNameText = findViewById(R.id.nameOfCustomer);
        customerMobileNumberText = findViewById(R.id.mobileNumOfCustomer);
        customerEmailText = findViewById(R.id.emailOfCustomer);
        customerAddressText = findViewById(R.id.addressOfCustomer);

        productNameText = findViewById(R.id.nameOfProduct);
        productQuantityText = findViewById(R.id.quantityOfProduct);
        productPriceText = findViewById(R.id.priceOfProduct);

        cashOnDeliveryBtn = findViewById(R.id.cashOnDeliveryBtn);
        cardPaymentBtn = findViewById(R.id.cardPaymentBtn);

        totalItemPriceText = findViewById(R.id.totalItemsPriceText);
        shippingFeeText = findViewById(R.id.shippingFeeText);
        totalAmountText = findViewById(R.id.totalAmountText);

        confirmOrderBtn = findViewById(R.id.confirmOrderBtn);
        confirmOrderBtn.setOnClickListener(v -> {
            Intent intent = new Intent(CheckoutActivity.this, ReceiptActivity.class);
            // TODO: Implement intent data passing
            startActivity(intent);
        });
    }
}