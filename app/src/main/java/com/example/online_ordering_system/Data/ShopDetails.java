package com.example.online_ordering_system.Data;

import java.util.Date;

public class ShopDetails extends Details{
    protected String shopName;
    protected String shopAddress;
    protected Date dateOfEstablishment; // new Date(int year, int month, int day)

    public ShopDetails(String name, int age, String email, int mobileNumber, String address, boolean accountType, String shopName, String shopAddress, Date dateOfEstablishment) {
        super(name, age, email, mobileNumber, address, accountType);
        this.shopName = shopName;
        this.shopAddress = shopAddress;
        this.dateOfEstablishment = dateOfEstablishment;
    }

    public ShopDetails() {
        super();
    }

    @Override
    public String toString() {
        return "ShopDetails{" +
                "shopName='" + shopName + '\'' +
                ", shopAddress='" + shopAddress + '\'' +
                ", dateOfEstablishment=" + dateOfEstablishment +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", mobileNumber=" + mobileNumber +
                ", address='" + address + '\'' +
                ", accountType=" + accountType +
                '}';
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopAddress() {
        return shopAddress;
    }

    public void setShopAddress(String shopAddress) {
        this.shopAddress = shopAddress;
    }

    public Date getDateOfEstablishment() {
        return dateOfEstablishment;
    }

    public void setDateOfEstablishment(Date dateOfEstablishment) {
        this.dateOfEstablishment = dateOfEstablishment;
    }
}
