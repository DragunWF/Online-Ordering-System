package com.example.online_ordering_system.utils;

import com.example.online_ordering_system.data.Customer;

import java.util.List;
import java.util.ArrayList;

public class AccountAuthentication {
    private static final List<Customer> accounts = new ArrayList<>();
    private static Customer currentUser;

    public static boolean isAccountExists(String username) {
        for (Customer account : accounts) {
            if (account.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    public static Customer loginAccount(String username, String password) {
        for (Customer account : accounts) {
            if (account.getUsername().equals(username) && account.getPassword().equals(password)) {
                currentUser = account;
                return account;
            }
        }
        return null;
    }
}
