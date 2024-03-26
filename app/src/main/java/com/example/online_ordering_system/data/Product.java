package com.example.online_ordering_system.data;

public class Product {
    private int id;
    private int shopID;
    private int categoryID;

    private String name;
    private String description;
    private int stock;
    private double price;

    private String imageURL;

    public Product(int id, int shopID, int categoryID, String name, String description, int stock, double price, String imageURL) {
        this.id = id;
        this.shopID = shopID;
        this.categoryID = categoryID;
        this.name = name;
        this.description = description;
        this.stock = stock;
        this.price = price;
        this.imageURL = imageURL;
    }

    public Product(int shopID, int categoryID, String name, String description, int stock, double price, String imageURL) {
        this.shopID = shopID;
        this.categoryID = categoryID;
        this.name = name;
        this.description = description;
        this.stock = stock;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
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
