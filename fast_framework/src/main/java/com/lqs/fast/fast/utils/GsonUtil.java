package com.lqs.fast.fast.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

/**
 * Created by lin on 2016/9/27.
 */

public final class GsonUtil {
    private GsonUtil(){

    }

    public static <T> T parseJsonString(String json, Class<T> clazz){
        Gson gson = new Gson();
        T t = gson.fromJson(json, clazz);
        return t;
    }

    public static <T> T parseJsonString(String json,TypeToken<T> tTypeToken){
        Gson gson = new Gson();
        T t = gson.fromJson(json, tTypeToken.getType());
        return t;
    }
}
