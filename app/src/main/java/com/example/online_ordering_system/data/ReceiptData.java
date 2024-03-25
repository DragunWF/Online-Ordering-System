package com.example.online_ordering_system.data;

public class ReceiptData {
    private int transactionID;
    private int shippingFee;
    private String shopName;
    private String address;

    public ReceiptData(int transactionID, int shippingFee, ShopDetails shop, Customer customer) {
        this.shopName = shop.shopName;
        this.address = customer.address;
        this.transactionID = transactionID;
        this.shippingFee = shippingFee;
    }

    public ReceiptData() {

    }

    @Override
    public String toString() {
        return "ReceiptData{" +
                "transactionID=" + transactionID +
                ", shippingFee=" + shippingFee +
                ", shopName='" + shopName + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public int getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(int transactionID) {
        this.transactionID = transactionID;
    }

    public int getShippingFee() {
        return shippingFee;
    }

    public void setShippingFee(int shippingFee) {
        this.shippingFee = shippingFee;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
