package com.example.online_ordering_system.utils;

import com.example.online_ordering_system.data.CustomerDetails;

import java.util.ArrayList;

public class SessionData {
    // private static List<ProductDetails> itemCart = new ArrayList<>();
    private static CustomerDetails currentUser;

    public static CustomerDetails getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(CustomerDetails currentUser) {
        SessionData.currentUser = currentUser;
    }
}
