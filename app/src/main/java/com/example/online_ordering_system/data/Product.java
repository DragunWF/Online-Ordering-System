package com.example.online_ordering_system.data;

public class Product {
    private int id;
    private int shopID;
    private int categoryID;
    private String name;
    private double price;
    private String imageURL;

    public Product(int id, int shopID, int categoryID, String name, double price, String imageURL) {
        this.id = id;
        this.shopID = shopID;
        this.categoryID = categoryID;
        this.name = name;
        this.price = price;
        this.imageURL = imageURL;
    }

    // ---------------> GETTERS AND SETTERS <---------------
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getShopID() {
        return shopID;
    }

    public void setShopID(int shopID) {
        this.shopID = shopID;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
