package com.lqs.fast.fast.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by dell on 2016/9/28.
 */

public final class SpUtil {
    private SpUtil(){};  //工具类不需要实例化
    public static final String SUFFIX = "_type";
//    public static final int

    /**
     *
     * @param context
     * @param map Value 类型限定为 int boolean float long String
     */
    public static void editSp(Context context,Map<String,Serializable> map,String spName)
    {
        SharedPreferences sp = context.getSharedPreferences(spName, 0);
        SharedPreferences.Editor edit = sp.edit();
        for (Map.Entry<String,Serializable> entry:map.entrySet()) {
            Serializable value = entry.getValue();
            String key = entry.getKey();
            putEditor(edit, value, key);
        }
        edit.commit();
    }

    /**
     *
     * @param context
     * @param value Value 类型限定为 int boolean float long String
     */
    public static void editSp(Context context,String key,Serializable value,String spName)
    {
        SharedPreferences sp = context.getSharedPreferences(spName, 0);
        SharedPreferences.Editor edit = sp.edit();
        putEditor(edit, value, key);
        edit.commit();
    }

    private static void putEditor(SharedPreferences.Editor edit, Serializable value, String key) {
        String name = value.getClass().getSimpleName();
        Log.e("name:",name);
        switch (name)
        {
            case "Integer":
            {
                edit.putInt(key,(int) value);

                break;
            }
            case "Boolean":
            {
                edit.putBoolean(key,(boolean) value);
                break;
            }
            case "Float":
            {
                edit.putFloat(key,(float) value);
                break;
            }
            case "Long":
            {
                edit.putLong(key,(long) value);
                break;
            }
            case "String":
            {
                edit.putString(key,(String) value);
                break;
            }
        }
        edit.putString(key+SUFFIX,name);
    }

    public static Serializable readSp(Context context,String name,String key)
    {
        SharedPreferences sp = context.getSharedPreferences(name,0);
        Serializable value = spGetValue(sp, key);
        return value;
    }

    public static Map<String,Serializable> readSp(Context context,String name,String... keys)
    {
        SharedPreferences sp = context.getSharedPreferences(name,0);
        Map<String,Serializable> map = new HashMap<>();
        for (String key: keys) {
            Serializable value = spGetValue(sp, key);
            if(value == null){
                continue;
            }
            map.put(key,value);
        }
        return map;
    }

    private static Serializable spGetValue(SharedPreferences sp,String key)
    {
        String type = sp.getString(key + SUFFIX, null);

        Serializable value = null;
        if (type == null){
            return null;
        }
        switch (type)
        {
            case "Integer":
            {
                value = sp.getInt(key,-1);
                break;
            }
            case "Boolean":
            {
                value = sp.getBoolean(key,false);
                break;
            }
            case "Float":
            {
                value = sp.getFloat(key,-1);
                break;
            }
            case "Long":
            {
                value = sp.getLong(key,-1);
                break;
            }
            case "String":
            {
                value = sp.getString(key,null);
                break;
            }
        }
        return value;
    }

}
