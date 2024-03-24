package com.example.online_ordering_system.utils;

import com.example.online_ordering_system.data.CustomerDetails;
import com.example.online_ordering_system.data.Details;

import java.util.List;
import java.util.ArrayList;

public class AccountAuthentication {
    private static final List<CustomerDetails> accounts = new ArrayList<>();
    private static CustomerDetails currentUser;

    public static boolean isAccountExists(String username) {
        for (CustomerDetails account : accounts) {
            if (account.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    public static CustomerDetails loginAccount(String username, String password) {
        for (CustomerDetails account : accounts) {
            if (account.getUsername().equals(username) && account.getPassword().equals(password)) {
                currentUser = account;
                return account;
            }
        }
        return null;
    }
}
