package com.example.online_ordering_system.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.online_ordering_system.R;

public class ReceiptActivity extends AppCompatActivity {
    // Customer Details Text Views
    private TextView customerNameText;
    private TextView customerMobileNumberText;
    private TextView customerEmailText;
    private TextView customerAddressText;

    // Shop Details Text Views
    private TextView shopNameText;
    private TextView shopAddressText;

    // Product Details Text Views
    private TextView productNameText;
    private TextView productPriceText;
    private TextView shippingFeeText;
    private TextView totalPriceText;
    private TextView transactionIdText;

    // Miscellaneous
    private Button backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receipt);

        customerNameText = findViewById(R.id.receiptNameOfCustomerText);
        customerMobileNumberText = findViewById(R.id.receiptMobileNoOfCustomerText);
        customerEmailText = findViewById(R.id.receiptEmailOfCustomerText);
        customerAddressText = findViewById(R.id.receiptAddressOfCustomerText);

        shopNameText = findViewById(R.id.receiptShopNameText);
        shopAddressText = findViewById(R.id.receiptShopAddressText);

        productNameText = findViewById(R.id.receiptProductNameText);
        productPriceText = findViewById(R.id.receiptProductPriceText);
        shippingFeeText = findViewById(R.id.receiptShippingFeeText);
        totalPriceText = findViewById(R.id.receiptTotalPriceText);
        transactionIdText = findViewById(R.id.receiptTransactionIdText);

        backBtn = findViewById(R.id.receiptBackToMainBtn);
        backBtn.setOnClickListener(v -> {
            finish();
        });
    }
}