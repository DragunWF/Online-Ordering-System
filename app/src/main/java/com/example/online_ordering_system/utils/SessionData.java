package com.example.online_ordering_system.utils;

import com.example.online_ordering_system.data.Customer;

public class SessionData {
    // private static List<ProductDetails> itemCart = new ArrayList<>();
    private static Customer currentUser;

    public static Customer getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(Customer currentUser) {
        SessionData.currentUser = currentUser;
    }
}
