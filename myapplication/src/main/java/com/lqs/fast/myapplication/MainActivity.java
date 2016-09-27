package com.lqs.fast.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.VolleyError;
import com.lqs.fast.fast.utils.HttpUtil;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        HttpUtil.HttpListener<String> listener = new HttpUtil.HttpListener<String>() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

            }

            @Override
            public void onResponse(String s) {
                Log.e("baidu",s);
            }
        };
        HttpUtil.getString("Http://www.baidu.com",listener);
    }
}
