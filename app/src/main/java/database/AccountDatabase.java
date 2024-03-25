package database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class AccountDatabase extends SQLiteOpenHelper {
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
    private final String AGE = "age";
    private final String MOBILE_NUMBER = "mobile_number";
    private final String ADDRESS = "address";
    private final String ACCOUNT_TYPE = "account_type";
    //---------------ACCOUNT FIELDS-----------------\\

    //---------------SHOP FIELDS-----------------\\
    private final String SHOP_ID_PK = "shop_id"; //PRIMARY KEY
    private final String OWNER_ID_FK = "owner_id"; //FOREIGN KEY FROM ACCOUNT_TBL
    private final String SHOP_NAME = "shop_name";
    private final String SHOP_ADDRESS = "shop_address";
    private final String DATE_ESTABLISH = "establishment_date";
    //---------------SHOP FIELDS-----------------\\

    //---------------PRODUCTS FIELDS-----------------\\
    private final String PRODUCTS_ID_PK = "products_id"; //PRIMARY KEY
    private final String SHOP_ID_FK = "shop_id"; //FOREIGN KEY FROM SHOP TABLE
    private final String CATEGORY_ID_FK = "category_id"; //FOREIGN KEY FROM CATEGORY TABLE
    private final String PRICE = "price";
    private final String IMAGE_URL = "image_url";
    //---------------PRODUCTS FIELDS-----------------\\

    //---------------CATEGORY FIELDS-----------------\\
    private final String CATEGORY_ID_PK = "category_id";
    private final String CATEGORY_NAME = "category_name";
    //---------------CATEGORY FIELDS-----------------\\


    public AccountDatabase(@Nullable Context context) {
        super(context, "accounts.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String accountTbl = "CREATE TABLE " + ACCOUNT_TBL +
                            " (" + USER_ID_PK + " INT PRIMARY KEY AUTOINCREMENT NOT NULL, "
                            + USERNAME + " VARCHAR(16) NOT NULL, "
                            + PASSWORD + " VARCHAR(100) NOT NULL, "
                            + FULL_NAME + " VARCHAR(50) NOT NULL, "
                            + AGE + " INT NOT NULL, "
                            + MOBILE_NUMBER + " VARCHAR(15) NOT NULL, "
                            + ADDRESS + " TEXT NOT NULL, "
                            + ACCOUNT_TYPE + " VARCHAR(10) NOT NULL)";

        String shopsTbl = "CREATE TABLE " + SHOP_TBL +
                          " (" + SHOP_ID_PK + " INT PRIMARY KEY AUTOINCREMENT, "
                          + OWNER_ID_FK + " INT NOT NULL, "
                          + SHOP_NAME + " VARCHAR(30) NOT NULL, "
                          + SHOP_ADDRESS + " TEXT NOT NULL, "
                          + DATE_ESTABLISH + " DATE NOT NULL, "
                          + " FOREIGN KEY(" + OWNER_ID_FK + ") REFERENCES " + ACCOUNT_TBL
                          + "(" + USER_ID_PK + "))";

        String productsTbl = "CREATE TABLE " + PRODUCT_TBL +
                             " (" + PRODUCTS_ID_PK + " INT NOT NULL";

        db.execSQL(accountTbl);
        db.execSQL(shopsTbl);
        db.execSQL(productsTbl);
    }

    @Override
    public void onConfigure(SQLiteDatabase db) {
        super.onConfigure(db);
        db.execSQL("PRAGMA foreign_keys = ON;");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
