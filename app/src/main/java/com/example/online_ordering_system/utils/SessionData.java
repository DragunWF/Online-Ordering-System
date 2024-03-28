package com.example.online_ordering_system.utils;

import android.content.Context;

import com.example.online_ordering_system.data.Category;
import com.example.online_ordering_system.data.Customer;
import com.example.online_ordering_system.data.Product;
import com.example.online_ordering_system.data.ReceiptData;
import com.example.online_ordering_system.data.Shop;

import java.util.ArrayList;
import java.util.List;

public class SessionData {
    private static final List<Product> itemCart = new ArrayList<>();
    private static List<Product> productList;
    private static List<Category> categories = new ArrayList<>();
    private static List<Shop> shops;
    private static Customer currentUser;
    private static ReceiptData receipt;

    public static void initializeProductCache(Context context) {
        if (productList == null) {
            DatabaseHelper db = new DatabaseHelper(context);
            productList = db.getProducts();
            shops = db.getShops();
        }
    }

    public static void addCartItem(Product product) {
        itemCart.add(product);
    }

    public static void removeCartItem(int index) {
        itemCart.remove(index);
    }

    public static Category getCategoryById(int id) {
        for (Category category : categories) {
            if (category.getId() == id) {
                return category;
            }
        }
        return null;
    }

    public static Category getCategoryByName(String name) {
        for (Category category : categories) {
            if (category.getName().equalsIgnoreCase(name)) {
                return category;
            }
        }
        return null;
    }

    public static Shop getShopById(int id) {
        for (Shop shop : shops) {
            if (shop.getShopID() == id) {
                return shop;
            }
        }
        return null;
    }

    public static double getCartTotalAmount() {
        double total = 0;
        for (Product product : itemCart) {
            total += product.getPrice() * product.getQuantity();
        }
        return total;
    }

    public static int getCartTotalQuantity() {
        int total = 0;
        for (Product product : itemCart) {
            total += product.getQuantity();
        }
        return total;
    }

    // GETTERS AND SETTERS
    public static Customer getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(Customer currentUser) {
        SessionData.currentUser = currentUser;
    }
    public static List<Product> getItemCart() {
        return itemCart;
    }

    public static List<Category> getCategories() {
        return categories;
    }

    public static void setCategories(List<Category> categories) {
        SessionData.categories = categories;
    }

    public static List<Product> getProductList() {
        return productList;
    }

    public static ReceiptData getReceipt() {
        return receipt;
    }

    public static void setReceipt(ReceiptData receipt) {
        SessionData.receipt = receipt;
    }
}
