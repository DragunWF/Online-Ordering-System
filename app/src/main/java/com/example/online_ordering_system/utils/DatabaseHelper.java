package com.example.online_ordering_system.utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.online_ordering_system.data.Category;
import com.example.online_ordering_system.data.Customer;
import com.example.online_ordering_system.data.Product;
import com.example.online_ordering_system.data.Shop;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    //---------------DATABASE TABLES-----------------\\
    private final String ACCOUNT_TBL = "account_tbl";
    private final String SHOP_TBL = "shop_tbl";
    private final String PRODUCT_TBL = "product_tbl";
    private final String CATEGORY_TBL = "category_tbl";
    //---------------DATABASE TABLES-----------------\\

    //---------------ACCOUNT FIELDS-----------------\\
    private final String USER_ID_PK = "user_id"; //PRIMARY KEY
    private final String USERNAME = "username";
    private final String PASSWORD = "password";
    private final String FULL_NAME = "full_name";
    private final String EMAIL = "email";
    private final String MOBILE_NUMBER = "mobile_number";
    private final String ADDRESS = "address";
    private final String ACCOUNT_TYPE = "account_type";
    //---------------ACCOUNT FIELDS-----------------\\

    //---------------SHOP FIELDS-----------------\\
    private final String SHOP_ID_PK = "shop_id"; //PRIMARY KEY
    private final String OWNER_ID_FK = "owner_id"; //FOREIGN KEY FROM ACCOUNT_TBL
    private final String SHOP_NAME = "shop_name";
    private final String SHOP_ADDRESS = "shop_address";
    //---------------SHOP FIELDS-----------------\\

    //---------------PRODUCTS FIELDS-----------------\\
    private final String PRODUCTS_ID_PK = "products_id"; //PRIMARY KEY
    private final String SHOP_ID_FK = "shop_id"; //FOREIGN KEY FROM SHOP TABLE
    private final String CATEGORY_ID_FK = "category_id"; //FOREIGN KEY FROM CATEGORY TABLE
    private final String PRODUCT_NAME = "product_name";
    private final String PRODUCT_DESCRIPTION = "product_description";
    private final String STOCK = "stock";
    private final String PRICE = "price";
    private final String IMAGE_URL = "image_url";
    //---------------PRODUCTS FIELDS-----------------\\

    //---------------CATEGORY FIELDS-----------------\\
    private final String CATEGORY_ID_PK = "category_id";
    private final String CATEGORY_NAME = "category_name";
    //---------------CATEGORY FIELDS-----------------\\


    public DatabaseHelper(@Nullable Context context) {
        super(context, "oos.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String accountTbl = "CREATE TABLE " + ACCOUNT_TBL +
                            "(" + USER_ID_PK + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "
                            + USERNAME + " TEXT NOT NULL, "
                            + PASSWORD + " TEXT NOT NULL, "
                            + FULL_NAME + " TEXT NOT NULL, "
                            + EMAIL + " TEXT NOT NULL, "
                            + MOBILE_NUMBER + " TEXT NOT NULL, "
                            + ADDRESS + " TEXT NOT NULL, "
                            + ACCOUNT_TYPE + " TEXT NOT NULL)";

        String shopTbl = "CREATE TABLE " + SHOP_TBL +
                          "(" + SHOP_ID_PK + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "
                          + OWNER_ID_FK + " INTEGER NOT NULL, "
                          + SHOP_NAME + " TEXT NOT NULL, "
                          + SHOP_ADDRESS + " TEXT NOT NULL, "
                          + "FOREIGN KEY(" + OWNER_ID_FK + ") REFERENCES " + ACCOUNT_TBL
                          + "(" + USER_ID_PK + "))";

        String categoryTbl = "CREATE TABLE " + CATEGORY_TBL +
                             "(" + CATEGORY_ID_PK + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "
                             + CATEGORY_NAME + " TEXT NOT NULL)";

        String productTbl = "CREATE TABLE " + PRODUCT_TBL +
                             " (" + PRODUCTS_ID_PK + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "
                             + SHOP_ID_FK + " INTEGER NOT NULL, "
                             + CATEGORY_ID_FK + " INTEGER NOT NULL, "
                             + PRODUCT_NAME + " TEXT NOT NULL,"
                             + PRODUCT_DESCRIPTION + " TEXT NOT NULL,"
                             + STOCK + " INTEGER NOT NULL,"
                             + PRICE + " REAL NOT NULL, "
                             + IMAGE_URL + " TEXT, "
                             + "FOREIGN KEY(" + SHOP_ID_FK + ") REFERENCES " + SHOP_TBL
                             + "(" + SHOP_ID_PK +"), "
                             + "FOREIGN KEY(" + CATEGORY_ID_FK + ") REFERENCES " + CATEGORY_TBL
                             + "(" + CATEGORY_ID_PK + "))";

        // Tables
        db.execSQL(accountTbl);
        db.execSQL(shopTbl);
        db.execSQL(categoryTbl);
        db.execSQL(productTbl);

        // Insert Pre-determined Data
        setPredeterminedData();
    }

    @Override
    public void onConfigure(SQLiteDatabase db) {
        super.onConfigure(db);
        db.execSQL("PRAGMA foreign_keys = ON;");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    private void setPredeterminedData() {
        List<Category> categories = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + CATEGORY_TBL, null);

        if (cursor.moveToFirst()) {
            do {
                categories.add(new Category(cursor.getInt(0), cursor.getString(1)));
            } while (cursor.moveToNext());
        }

        int sellerId = 10;
        db.execSQL(String.format("INSERT INTO %s (category_name) VALUES ('%s'), ('%s'), ('%s'), ('%s'), ('%s')",
                CATEGORY_TBL, "Clothes", "Accessories", "PC Parts", "Gadgets", "House Furniture"));
        db.execSQL(String.format("INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s) ", ACCOUNT_TBL, USER_ID_PK, USERNAME, PASSWORD, FULL_NAME, EMAIL, MOBILE_NUMBER, ADDRESS, ACCOUNT_TYPE)
                + String.format("VALUES (%s, 'Seller01', 'password', 'Jack Sparrow', 'sparrow@gmail.com', '0960 423 5124', 'Quezon City', 'seller')", sellerId));
        db.execSQL(String.format("INSERT INTO %s (%s, %s, %s) ", SHOP_TBL, OWNER_ID_FK, SHOP_NAME, SHOP_ADDRESS) +
                String.format("VALUES (%s, '%s', '%s')", sellerId, "Avalon", "Batangas City"));

        cursor.close();
        SessionData.setCategories(categories);
    }

    public void addAccount(Customer account) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(USERNAME, account.getUsername());
        cv.put(PASSWORD, account.getPassword());
        cv.put(FULL_NAME, account.getFullName());
        cv.put(EMAIL, account.getEmail());
        cv.put(MOBILE_NUMBER, account.getMobileNumber());
        cv.put(ADDRESS, account.getAddress());
        cv.put(ACCOUNT_TYPE, account.getAccountType());

        db.insert(ACCOUNT_TBL, null, cv);
    }

    public List<Customer> getAccounts() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + ACCOUNT_TBL, null);
        List<Customer> accounts = new ArrayList<>();

        if (cursor.moveToFirst()) {
            do {
                accounts.add(new Customer(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4),
                        cursor.getString(5),
                        cursor.getString(6),
                        cursor.getString(7)
                ));
            } while (cursor.moveToNext());
        }

        cursor.close();
        return accounts;
    }

    public void addProduct(Product product) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(SHOP_ID_FK, product.getShopID());
        cv.put(CATEGORY_ID_FK, product.getCategoryID());
        cv.put(PRODUCT_NAME, product.getName());
        cv.put(PRODUCT_DESCRIPTION, product.getDescription());
        cv.put(STOCK, product.getStock());
        cv.put(PRICE, product.getPrice());
        cv.put(IMAGE_URL, product.getImageURL());

        db.insert(PRODUCT_TBL, null, cv);
    }

    public List<Product> getProducts() {
        return getProducts(null);
    }

    public List<Product> getProducts(String category) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = category == null ? "SELECT * FROM " + PRODUCT_TBL :
                String.format("SELECT * FROM %s WHERE category_id = %s", PRODUCT_TBL, category);
        Cursor cursor = db.rawQuery(query, null);
        List<Product> products = new ArrayList<>();

        if (cursor.moveToFirst()) {
            do {
                products.add(new Product(
                        cursor.getInt(0),
                        cursor.getInt(1),
                        cursor.getInt(2),
                        cursor.getString(3),
                        cursor.getString(4),
                        cursor.getInt(5),
                        cursor.getDouble(6),
                        cursor.getString(7)
                ));
            } while (cursor.moveToNext());
        }

        cursor.close();
        return products;
    }

    public void addShop(Shop shop) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(SHOP_NAME, shop.getName());
        cv.put(OWNER_ID_FK, shop.getOwnerID());
        cv.put(SHOP_ADDRESS, shop.getAddress());

        db.insert(SHOP_TBL, null, cv);
    }

    public Shop getSpecificShop(String shopName) {
        // TODO: Implement specific shop retrieval
        return null;
    }
}
