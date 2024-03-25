package com.example.online_ordering_system.data;

public class Customer {
    private String username;
    private String password;
    private String fullName;
    private int age;
    private String email;
    private int mobileNumber;
    private String address;
    private boolean accountType;

    public Customer(String username, String password, String fullName, int age, String email, int mobileNumber,
            String address, boolean accountType) {
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.age = age;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.address = address;
        this.accountType = accountType;
    }

    public Customer() {
        super();
    }

    @Override
    public String toString() {
        return "Customer{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", fullName='" + fullName + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", mobileNumber=" + mobileNumber +
                ", address='" + address + '\'' +
                ", accountType=" + accountType +
                '}';
    }

    // ---------------> GETTERS AND SETTERS <---------------
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(int mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAccountType() {
        return accountType ? "buyer" : "seller";
    }

    public void setAccountType(boolean isBuyer) {
        accountType = isBuyer;
    }
}
