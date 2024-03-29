package com.example.online_ordering_system.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.online_ordering_system.MainActivity;
import com.example.online_ordering_system.R;
import com.example.online_ordering_system.data.Customer;
import com.example.online_ordering_system.data.ReceiptData;
import com.example.online_ordering_system.utils.SessionData;
import com.example.online_ordering_system.utils.Utils;

import java.util.Objects;

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
    private Bundle bundle;
    private boolean isSinglePurchase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receipt);

        setClassValues();

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
            SessionData.getSelectedItems().clear();
            startActivity(new Intent(ReceiptActivity.this, MainActivity.class));
        });

        setCustomerDetails();
        setShopDetails();
        setProductDetails();
        SessionData.getItemCart().clear();
    }

    private void setClassValues() {
        try {
            bundle = getIntent().getExtras();
            assert bundle != null;
            isSinglePurchase = Objects.equals(bundle.get("buyType"), "single");
        } catch (Exception err) {
            Utils.toast(ReceiptActivity.this, "Error trying to fetch intent extra values!");
        }
    }

    @SuppressLint("SetTextI18n")
    private void setCustomerDetails() {
        Customer user = SessionData.getCurrentUser();
        customerNameText.setText("Name: " + user.getFullName());
        customerMobileNumberText.setText("Mobile No: " + user.getMobileNumber());
        customerEmailText.setText("Email: " + user.getEmail());
        customerAddressText.setText("Address: " + user.getAddress());
    }

    @SuppressLint("SetTextI18n")
    private void setShopDetails() {
        shopNameText.setText("Name: " + SessionData.getReceipt().getShopName());
        shopAddressText.setText("Address: " + SessionData.getReceipt().getAddress());
    }

    @SuppressLint("SetTextI18n")
    private void setProductDetails() {
        ReceiptData receipt = SessionData.getReceipt();
        productNameText.setText("Product Name: " + receipt.getProductName());
        productPriceText.setText("Price: " + receipt.getTotalPrice());
        shippingFeeText.setText("Shipping Fee: " + receipt.getShippingFee());
        totalPriceText.setText("Total Price: " + receipt.getTotalAmount());
        transactionIdText.setText("Transaction ID: " + receipt.getTransactionID());
    }
}