package com.example.online_ordering_system.data;

public class Shop {
    private int shopID;
    private int ownerID;
    private String name;
    private String address;

    public Shop(int shopID, int ownerID, String name, String address) {
        this.shopID = shopID;
        this.ownerID = ownerID;
        this.name = name;
        this.address = address;
    }

    // ---------------> GETTERS AND SETTERS <---------------
    public int getShopID() {
        return shopID;
    }

    public int getOwnerID() {
        return ownerID;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
