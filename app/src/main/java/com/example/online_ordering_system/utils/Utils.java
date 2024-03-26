package com.example.online_ordering_system.utils;

import android.content.Context;
import android.widget.EditText;
import android.widget.Toast;

import com.example.online_ordering_system.data.Product;

public class Utils {
    public static String getString(EditText text) {
        return String.valueOf(text.getText());
    }

    public static void toast(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    public static String productQuery(Product[] products) {
        StringBuilder query = new StringBuilder();
        query.append("VALUES ");
        for (int i = 0 ; i < products.length; i++) {
            Product product = products[i];
            String row = String.format("(%s, %s, '%s', '%s', %s, %s, '%s')",
                    product.getShopID(), product.getCategoryID(), product.getName(), product.getDescription(),
                    product.getStock(), product.getPrice(), product.getImageURL());
            if (i + 1 != products.length) {
                row += ", ";
            }
            query.append(row);
        }
        return query.toString();
    }
}
