package com.lqs.fast.fast.utils;

import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.StringRequest;

import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * Created by dell on 2016/9/27.
 */

public class HttpUtil {
    public static RequestQueue sRequestQueue;

    public static void getString(String url, HttpListener<String> listener) {
        if(censorVolleyInit())
        {
            return;
        }
        StringRequest stringRequest = new MyStringRequest(Request.Method.GET, url, listener, listener);
        sRequestQueue.add(stringRequest);
    }

    public static void postString(String url, final Map<String,String> map, HttpListener listener) {
        if(censorVolleyInit())
        {
            return;
        }
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, listener, listener) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return map;
            }
        };
    }

    public static boolean censorVolleyInit(){
        if(sRequestQueue == null)
        {
            Log.e("VolleyError","Volley未进行初始化");
        }
        return (sRequestQueue == null);
    }

    public static void initVolley(RequestQueue requestQueue)
    {
        sRequestQueue = requestQueue;
    }

    /**
     * 对接口进行合并
     * @param <T> 请求泛型
     */
    public static interface HttpListener<T> extends Response.Listener<T> ,Response.ErrorListener{

    }

    /**
     * 对默认转码进行进一步处理
     * 如果请求到的数据有Charset编码信息则用该编码进行转码,
     * 如果没有Charset编码信息尝试使用UTF-8 进行解码,
     * 如果解码失败用ISO-8859-1
     */
    private static class MyStringRequest extends StringRequest{

        public MyStringRequest(int method, String url, Response.Listener<String> listener, Response.ErrorListener errorListener) {
            super(method, url, listener, errorListener);
        }

        @Override
        protected Response<String> parseNetworkResponse(NetworkResponse response) {
            String parsed;
            try {
                parsed = new String(response.data, HttpHeaderParser.parseCharset(response.headers));
            } catch (UnsupportedEncodingException var4) {
                try {
                    parsed = new String(response.data,"UTF-8");
                } catch (UnsupportedEncodingException e) {
                    parsed = new String(response.data);
                    e.printStackTrace();
                }
            }
            return Response.success(parsed, HttpHeaderParser.parseCacheHeaders(response));
        }
    }
}
