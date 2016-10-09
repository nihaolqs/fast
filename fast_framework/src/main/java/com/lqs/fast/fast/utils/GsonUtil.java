package com.lqs.fast.fast.utils;

import android.util.Log;

import com.android.volley.VolleyError;
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

    public static <T> T parseJsonString(String json,Type type){
        Gson gson = new Gson();
        T t = gson.fromJson(json, type);
        return t;
    }

    public static<T> void downLoadJson(String url, final TypeToken<T> tTypeToken, final DownLoadedJsonListener<T> listener){
        HttpUtil.getString(url, new HttpUtil.HttpListener<String>() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.d("Json错误","Json下载失败");
            }

            @Override
            public void onResponse(String s) {
                T t = parseJsonString(s, tTypeToken);
                listener.downLoaded(t);
            }
        });
    }

    public static<T> void downLoadJson(String url, final Type type, final DownLoadedJsonListener<T> listener){
        HttpUtil.getString(url, new HttpUtil.HttpListener<String>() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.d("Json错误","Json下载失败");
            }

            @Override
            public void onResponse(String s) {
                T t = parseJsonString(s, type);
                listener.downLoaded(t);
            }
        });
    }
    public static<T> void downLoadJson(String url, final Class<T> clazz, final DownLoadedJsonListener<T> listener){
        HttpUtil.getString(url, new HttpUtil.HttpListener<String>() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.d("Json错误","Json下载失败");
            }

            @Override
            public void onResponse(String s) {
                T t = parseJsonString(s, clazz);
                listener.downLoaded(t);
            }
        });
    }

    public static interface DownLoadedJsonListener<S>{
        void downLoaded(S s);
    }
}
