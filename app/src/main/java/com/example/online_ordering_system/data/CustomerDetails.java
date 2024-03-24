package com.example.online_ordering_system.data;

public class CustomerDetails extends Details {
    public CustomerDetails(String username, String fullName, int age, String email, int mobileNumber, String address, boolean accountType) {
        super(username, fullName, age, email, mobileNumber, address, accountType);
    }

    public CustomerDetails() {
        super();
    }

    @Override
    public String toString() {
        return "CustomerDetails{" +
                "name='" + username + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", mobileNumber=" + mobileNumber +
                ", address='" + address + '\'' +
                ", accountType=" + accountType +
                '}';
    }
}
