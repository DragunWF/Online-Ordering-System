package com.example.online_ordering_system.utils;

import android.content.Context;
import android.widget.EditText;
import android.widget.Toast;

public class Utils {
    public static String getString(EditText text) {
        return String.valueOf(text.getText());
    }

    public static void displayToast(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
}
