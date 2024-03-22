package com.example.online_ordering_system.Data;

public class CustomerDetails extends Details {
    public CustomerDetails(String name, int age, String email, int mobileNumber, String address, boolean accountType) {
        super(name, age, email, mobileNumber, address, accountType);
    }

    @Override
    public String toString() {
        return "CustomerDetails{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", mobileNumber=" + mobileNumber +
                ", address='" + address + '\'' +
                ", accountType=" + accountType +
                '}';
    }
}
