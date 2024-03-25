package com.example.online_ordering_system.data;

public class CustomerDetails extends Details {
    private String password;

    public CustomerDetails(String username, String password, String fullName, int age, String email, int mobileNumber, String address, boolean accountType) {
        super(username, fullName, age, email, mobileNumber, address, accountType);
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccountType() {
        return accountType ? "buyer" : "seller";
    }

    public void setAccountType(boolean isBuyer) {
        accountType = isBuyer;
    }
}
