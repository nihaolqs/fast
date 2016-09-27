package com.lqs.fast.fast.app;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.lqs.fast.fast.utils.HttpUtil;

/**
 * Created by dell on 2016/9/27.
 */

public class BaseApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        HttpUtil.initVolley(Volley.newRequestQueue(this)); //初始化Volley

        ImagePipelineConfig config = ImagePipelineConfig.newBuilder(this)
                .setDownsampleEnabled(true)   //开启向下采样图片缩放
                .build();
        Fresco.initialize(this,config);
    }
}
