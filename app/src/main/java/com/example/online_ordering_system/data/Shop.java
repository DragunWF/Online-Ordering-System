package com.example.online_ordering_system.data;

import java.util.Date;

public class Shop {
    private int shopID;
    private int ownerID;
    private String shopName;
    private String shopAddress;

    public Shop(int shopID, int ownerID, String shopName, String shopAddress) {
        this.shopID = shopID;
        this.ownerID = ownerID;
        this.shopName = shopName;
        this.shopAddress = shopAddress;
    }

    // ---------------> GETTERS AND SETTERS <---------------
    public int getShopID() {
        return shopID;
    }

    public void setShopID(int shopID) {
        this.shopID = shopID;
    }

    public int getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(int ownerID) {
        this.ownerID = ownerID;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopAddress() {
        return shopAddress;
    }

    public void setShopAddress(String shopAddress) {
        this.shopAddress = shopAddress;
    }
}
