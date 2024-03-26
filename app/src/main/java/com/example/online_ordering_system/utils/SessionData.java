package com.example.online_ordering_system.utils;

import com.example.online_ordering_system.data.Category;
import com.example.online_ordering_system.data.Customer;
import com.example.online_ordering_system.data.Product;

import java.util.ArrayList;
import java.util.List;

public class SessionData {
    private static final List<Product> itemCart = new ArrayList<>();
    private static List<Category> categories = new ArrayList<>();
    private static Customer currentUser;

    public static Customer getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(Customer currentUser) {
        SessionData.currentUser = currentUser;
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

    // GETTERS AND SETTERS
    public static List<Product> getItemCart() {
        return itemCart;
    }

    public static List<Category> getCategories() {
        return categories;
    }

    public static void setCategories(List<Category> categories) {
        SessionData.categories = categories;
    }
}
