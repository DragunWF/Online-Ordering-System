package com.example.online_ordering_system.utils;

import android.content.Context;

import com.example.online_ordering_system.data.Category;
import com.example.online_ordering_system.data.Customer;
import com.example.online_ordering_system.data.Product;
import com.example.online_ordering_system.data.ReceiptData;
import com.example.online_ordering_system.data.Shop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SessionData {
    private static List<Product> itemCart = new ArrayList<>();
    private static final List<Integer> selectedItems = new ArrayList<>(); // stores the indices
    private static final HashMap<Integer, String> categories = new HashMap<>();
    private static final List<String> categoryNames = new ArrayList<>(); // Primarily for spinner adapter in MainActivity

    private static List<Product> productList;
    private static List<Shop> shops;
    private static Customer currentUser;
    private static ReceiptData receipt;

    public static void initializeProductCache(Context context) {
        if (productList == null) {
            DatabaseHelper db = new DatabaseHelper(context);
            productList = db.getProducts();
            shops = db.getShops();

            List<Category> categoriesData = db.getCategories();
            for (Category category : categoriesData) {
                categories.put(category.getId(), category.getName());
                categoryNames.add(category.getName());
            }
        }
    }

    public static String getCategoryNameById(int id) {
        return categories.get(id);
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
        for (int index : selectedItems) {
            Product product = itemCart.get(index);
            total += product.getPrice() * product.getQuantity();
        }
        return total;
    }

    public static int getCartTotalQuantity() {
        int total = 0;
        for (int index : selectedItems) {
            total += itemCart.get(index).getQuantity();
        }
        return total;
    }

    public static void renewCart() {
        List<Product> newCart = new ArrayList<>();
        for (int i = 0, n = itemCart.size(); i < n; i++) {
            if (!selectedItems.contains(i)) {
                newCart.add(itemCart.get(i));
            }
        }
        itemCart = newCart;
        selectedItems.clear();
    }

    public static void signOut() {
        currentUser = null;
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

    public static List<Integer> getSelectedItems() {
        return selectedItems;
    }

    public static List<String> getCategoryNames() {
        return categoryNames;
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
