package com.example.online_ordering_system.data;

public class ReceiptData {
    private final int transactionID;
    private String productName;
    private double shippingFee;
    private final double totalPrice;
    private String shopName;
    private String address;

    public ReceiptData(String productName, double shippingFee, String shopName, double totalPrice, String address) {
        this.transactionID = (int)(Math.random() * (5000 - 1000) + 1000);
        this.productName = productName;
        this.shippingFee = shippingFee;
        this.shopName = shopName;
        this.address = address;
        this.totalPrice = totalPrice;
    }

    // GETTERS AND SETTERS
    public double getTotalAmount() {
        return totalPrice + shippingFee;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public int getTransactionID() {
        return transactionID;
    }

    public String getProductName() {
        return productName;
    }

    public double getShippingFee() {
        return shippingFee;
    }

    public String getShopName() {
        return shopName;
    }

    public String getAddress() {
        return address;
    }
}
