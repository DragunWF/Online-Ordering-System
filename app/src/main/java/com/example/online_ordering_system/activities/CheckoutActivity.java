package com.example.online_ordering_system.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.online_ordering_system.R;
import com.example.online_ordering_system.data.Customer;
import com.example.online_ordering_system.data.Product;
import com.example.online_ordering_system.utils.SessionData;
import com.example.online_ordering_system.utils.Utils;

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
    private RadioButton cardPaymentBtn;

    // Miscellaneous
    private TextView totalItemPriceText;
    private TextView shippingFeeText;
    private TextView totalAmountText;

    private TextView confirmOrderBtn;
    private ImageView backBtn;

    // Values
    private Bundle bundle;
    private double totalPrice;
    private Product product;
    private String buyType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        try {
            bundle = getIntent().getExtras();
            assert bundle != null;
            buyType = bundle.getString("buyType");
            product = Utils.getProductById(bundle.getInt("id"));
            totalPrice = bundle.getInt("quantity") * product.getPrice();
        } catch (Exception err) {
            Utils.toast(this, "Error trying to fetch from intent extras!");
        }

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
        backBtn = findViewById(R.id.backBtnCheckOut);

        setCustomerDetails();
        setProductDetails();
        setMiscDetails();
        setButtons();
    }

    @SuppressLint("SetTextI18n")
    private void setCustomerDetails() {
        Customer user = SessionData.getCurrentUser();
        customerNameText.setText("Name: " + user.getFullName());
        customerMobileNumberText.setText("Mobile No: " + user.getMobileNumber());
        customerEmailText.setText("Email Address: " + user.getEmail());
        customerAddressText.setText("Address: " + user.getAddress());
    }

    @SuppressLint("SetTextI18n")
    private void setProductDetails() {
        try {
            assert product != null;
            productNameText.setText(product.getName());
            productQuantityText.setText("Quantity: " + bundle.getInt("quantity"));
            productPriceText.setText(totalPrice + " PHP");
        } catch (Exception err) {
            Utils.toast(CheckoutActivity.this, "Something went wrong trying to display product's information!");
        }
    }

    @SuppressLint("SetTextI18n")
    private void setMiscDetails() {
        double shippingFee = totalPrice * 0.05;
        double totalAmount = totalPrice + shippingFee;
        totalItemPriceText.setText("Total Item/s Price: " + totalPrice + " PHP");
        shippingFeeText.setText("+ Shipping Fee: " + shippingFee + " PHP");
        totalAmountText.setText("Total Amount: " + totalAmount + " PHP");
    }

    private void setButtons() {
        backBtn.setOnClickListener(v -> {
            finish();
        });
        confirmOrderBtn.setOnClickListener(v -> {
            if (!cashOnDeliveryBtn.isChecked() && !cardPaymentBtn.isChecked()) {
                Utils.toast(CheckoutActivity.this, "Please select a mode of payment!");
            } else {
                Intent intent = new Intent(CheckoutActivity.this, ReceiptActivity.class);
                // TODO: Implement intent data passing
                startActivity(intent);
            }
        });
    }
}