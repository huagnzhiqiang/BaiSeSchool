package com.baise.baselibs.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * @author 小强
 * @time 2017/7/25  16:45
 * @desc sharePreference工具类
 */
public class SpUtil {

    private final String SHARED_PREFERENCE_NAME = "BaiSeApp";
    private static SpUtil catche;
    private SharedPreferences spf;

    public static SpUtil instance(Context context) {
        if (catche == null) {
            catche = new SpUtil(context);
        }
        return catche;
    }

    public static SpUtil getInstance() {
        return catche;
    }

    private SpUtil(Context context) {
        spf = context.getSharedPreferences(SHARED_PREFERENCE_NAME, Context.MODE_PRIVATE);
    }

    public void putBoolean(String key, boolean value) {
        spf.edit().putBoolean(key, value).commit();
    }

    public boolean getBoolean(String key) {
        return spf.getBoolean(key, false);
    }

    public boolean getBoolean(String key, boolean defa) {
        return spf.getBoolean(key, defa);
    }

    public void putString(String key, String value) {
        spf.edit().putString(key, value).commit();
    }

    public String getString(String key) {
        return spf.getString(key, "");
    }

    public String getString(String key, String defau) {
        return spf.getString(key, defau);
    }

    public void putInt(String key, int value) {
        spf.edit().putInt(key, value).commit();
    }

    public void putLong(String key, long value) {
        spf.edit().putLong(key, value).commit();
    }

    public int getInt(String key) {
        return spf.getInt(key, 0);
    }

    public int getInt(String key, int defaultValue) {
        return spf.getInt(key, defaultValue);
    }

    public long getLong(String key) {
        return spf.getLong(key, 0);
    }

    public long getLong(String key, long def) {
        return spf.getLong(key, def);
    }

    public void clearData() {
        spf.edit().clear().commit();
    }

    public void remove(String key) {
        spf.edit().remove(key).commit();
    }

    public void commit() {
        spf.edit().commit();
    }

}
