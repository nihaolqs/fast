package com.lqs.fast.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.android.volley.VolleyError;
import com.facebook.drawee.view.SimpleDraweeView;
import com.lqs.fast.fast.utils.HttpUtil;
import com.lqs.fast.fast.utils.ImageUtils;
import com.lqs.fast.fast.utils.LogUtil;
import com.lqs.fast.fast.utils.SpUtil;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

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

        String url = "http://image100.360doc.com/DownloadImg/2016/09/1520/80115017_4.jpg";

        ImageView imageView = (ImageView) findViewById(R.id.imageView);

        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) findViewById(R.id.imageView2);

        ImageUtils.LoadImage(imageView,url);
        ImageUtils.LoadImage(simpleDraweeView,url);

        Map<String, Serializable> map = new HashMap<>();
        map.put("123",1);
        map.put("456",2);
        map.put("boolean",false);
        map.put("long",10000000000000000L);
        map.put("flow",2.6f);
        map.put("String","dffdf");
        SpUtil.editSp(this,map,"name");

        int name = (int) SpUtil.readSp(this, "name", "123");

        LogUtil.d();

    }
}
