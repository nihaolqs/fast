package com.lqs.fast.myapplication;

import android.annotation.SuppressLint;
import android.os.Binder;
import android.os.IBinder;
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
import com.lqs.fast.fast.widget.ProgressButton;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private int progest = 0;


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
                Log.e("baidu", s);
            }
        };
        HttpUtil.getString("Http://www.baidu.com", listener);

        String url = "http://image100.360doc.com/DownloadImg/2016/09/1520/80115017_4.jpg";

        ImageView imageView = (ImageView) findViewById(R.id.imageView);

        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) findViewById(R.id.imageView2);

        ImageUtils.LoadImage(imageView, url);
        ImageUtils.LoadImage(simpleDraweeView, url);

        Map<String, Serializable> map = new HashMap<>();
        map.put("123", 1);
        map.put("456", 2);
        map.put("boolean", false);
        map.put("long", 10000000000000000L);
        map.put("flow", 2.6f);
        map.put("String", "dffdf");
        SpUtil.editSp(this, map, "name");

        int name = (int) SpUtil.readSp(this, "name", "123");

        LogUtil.d();

        final ProgressButton progressbutton = (ProgressButton) findViewById(R.id.progressbutton);
        progressbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progest += 5;
                progressbutton.setText("进度" + progest +"%");
                progressbutton.setProgress(progest);
            }
        });

        try{
            //加载MySql的驱动类
            Class.forName("com.mysql.jdbc.Driver") ;
            Log.e("数据库辅助类","数据库辅助类");
        }catch(ClassNotFoundException e){
            System.out.println("找不到驱动程序类 ，加载驱动失败！");
            e.printStackTrace() ;
            Log.e("数据库辅助类","找不到驱动程序类 ，加载驱动失败！");
        }

    }


}
