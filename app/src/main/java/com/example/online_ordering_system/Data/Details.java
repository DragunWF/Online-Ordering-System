package com.example.online_ordering_system.Data;

public class Details {
    protected String name;
    protected int age;
    protected String email;
    protected int mobileNumber;
    protected String address;
    protected boolean accountType;

    public Details(String name, int age, String email, int mobileNumber, String address, boolean accountType) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.address = address;
        this.accountType = accountType;
    }

    public Details() {

    }

    @Override
    public String toString() {
        return "Details{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", mobileNumber=" + mobileNumber +
                ", address='" + address + '\'' +
                ", accountType=" + accountType +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public boolean isAccountType() {
        return accountType;
    }

    public void setAccountType(boolean accountType) {
        this.accountType = accountType;
    }
}
