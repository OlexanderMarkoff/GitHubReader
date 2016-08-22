package com.example.m1.githubreader.utils;

import android.util.Base64;

import com.example.m1.githubreader.app.Constants;
import com.google.gson.JsonObject;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by M1 on 22.08.2016.
 */
public class Base64EncodeDecodeHelper {
    public static String encode(String string) {
        return Base64.encodeToString(string.getBytes(), Base64.DEFAULT).replaceAll("\n", Constants.TITLE_EMPTY);
    }

    public static String decode(String base64String) {

        byte[] decoded = Base64.decode(base64String, Base64.DEFAULT);
        return new String(decoded);
    }

    public static String encode(JsonObject jsonObject) {
        return Base64.encodeToString(jsonObject.toString().getBytes(), Base64.DEFAULT).replaceAll("\n", Constants.TITLE_EMPTY);
    }

    public static boolean isBase64Valid(String base64String) {
        Pattern p = Pattern.compile(Constants.BASE_64_PATTERN);
        Matcher m = p.matcher(base64String);
        return m.matches();
    }

}
