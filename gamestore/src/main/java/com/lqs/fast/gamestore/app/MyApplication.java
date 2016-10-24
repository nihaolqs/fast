package com.lqs.fast.gamestore.app;

import android.app.Application;
import android.graphics.Bitmap;

import com.activeandroid.ActiveAndroid;
import com.activeandroid.Configuration;
import com.android.volley.toolbox.Volley;
import com.lqs.fast.fast.utils.HttpUtil;
import com.lqs.fast.fast.utils.ImageUtils;
import com.lqs.fast.gamestore.bean.SaveGameInfoBean;
import com.nostra13.universalimageloader.core.DisplayImageOptions;

/**
 * Created by lin on 2016/10/9.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        HttpUtil.initVolley(Volley.newRequestQueue(this)); //初始化Volley
        ImageUtils.initUIL(this); //初始化UIL
        openUILCache();
        initializeDB();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        ActiveAndroid.dispose();
    }


    private void openUILCache() {
        DisplayImageOptions displayImageOptions = new DisplayImageOptions.Builder()
// .showImageOnLoading(R.drawable.image1)/*加载图片的时候显示正在加载的图*/
//.showImageOnFail(R.drawable.image1)/*加载图片失败后显示这个张图*/
                .cacheInMemory(true)/*缓存至内存*/
                .cacheOnDisk(true)/*缓存值SDcard*/
                .bitmapConfig(Bitmap.Config.RGB_565)
                .build();
        ImageUtils.setDisplayImageOptions(displayImageOptions);
    }

    protected void initializeDB() {
        Configuration.Builder configurationBuilder = new Configuration.Builder(this);
        configurationBuilder.addModelClasses(SaveGameInfoBean.class);
        ActiveAndroid.initialize(configurationBuilder.create());
    }
}
