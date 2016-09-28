package com.lqs.fast.fast.app;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.lqs.fast.fast.utils.HttpUtil;
import com.lqs.fast.fast.utils.ImageUtils;

/**
 * Created by dell on 2016/9/27.
 */

public class BaseApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        HttpUtil.initVolley(Volley.newRequestQueue(this)); //初始化Volley
        ImageUtils.initFresco(this); //初始化Fresco
        ImageUtils.initUIL(this); //初始化UIL
    }
}
