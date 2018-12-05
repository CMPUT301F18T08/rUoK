package com.example.ruok.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;

import com.google.gson.Gson;


/**
 * @time 2017-12-13 10:18
 * 
 */
public class SpUtil {
    static SharedPreferences prefs;

    public static String getString(String key) {
        return prefs.getString(key, "");
    }

    public static void init(Context context) {
        prefs = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public static void putString(String key, String value) {
        prefs.edit().putString(key, value).apply();
    }

    public static void put(String key, Object value) {
        String type = value.getClass().getSimpleName();
        SharedPreferences.Editor editor = prefs.edit();
        if ("Integer".equals(type)) {
            editor.putInt(key, (Integer) value);
        } else if ("Boolean".equals(type)) {
            editor.putBoolean(key, (Boolean) value);
        } else if ("String".equals(type)) {
            editor.putString(key, (String) value);
        } else if ("Float".equals(type)) {
            editor.putFloat(key, (Float) value);
        } else if ("Long".equals(type)) {
            editor.putLong(key, (Long) value);
        }
        editor.apply();
    }

    public static Object getData(Context context, String key, Object defValue) {

        String type = defValue.getClass().getSimpleName();
        //defValue为为默认值，如果当前获取不到数据就返回它
        if ("Integer".equals(type)) {
            return prefs.getInt(key, (Integer) defValue);
        } else if ("Boolean".equals(type)) {
            return prefs.getBoolean(key, (Boolean) defValue);
        } else if ("String".equals(type)) {
            return prefs.getString(key, (String) defValue);
        } else if ("Float".equals(type)) {
            return prefs.getFloat(key, (Float) defValue);
        } else if ("Long".equals(type)) {
            return prefs.getLong(key, (Long) defValue);
        }

        return null;
    }

    public static void saveCurrentUser(JsonUser user) {
        Gson gson = new Gson();
        String js = gson.toJson(user);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("currentUser", js);
        editor.apply();
    }

    public static JsonUser getCurrentUser() {
        String currentUser = prefs.getString("currentUser", "");
        if (TextUtils.isEmpty(currentUser)) {
            return null;
        } else {
            JsonUser u = new Gson().fromJson(currentUser, JsonUser.class);
            return u;
        }
    }

    public static void logout() {
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("currentUser", "");
        editor.apply();
    }
}
