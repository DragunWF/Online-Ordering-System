package com.example.online_ordering_system.utils;

import com.example.online_ordering_system.data.Customer;
import com.example.online_ordering_system.data.Product;

import java.util.ArrayList;
import java.util.List;

public class SessionData {
    private static final List<Product> itemCart = new ArrayList<>();
    private static Customer currentUser;

    public static Customer getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(Customer currentUser) {
        SessionData.currentUser = currentUser;
    }

    public static List<Product> getItemCart() {
        return itemCart;
    }
}
