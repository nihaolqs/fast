package com.lqs.fast.gamestore.app;

import android.app.Application;
import android.graphics.Bitmap;
import android.util.Log;

import com.activeandroid.ActiveAndroid;
import com.activeandroid.Configuration;
import com.android.volley.toolbox.Volley;
import com.lqs.fast.fast.utils.HttpUtil;
import com.lqs.fast.fast.utils.ImageUtils;
import com.lqs.fast.fast.utils.SpUtil;
import com.lqs.fast.gamestore.bean.SaveGameInfoBean;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.umeng.message.IUmengCallback;
import com.umeng.message.IUmengRegisterCallback;
import com.umeng.message.PushAgent;

import java.io.Serializable;

/**
 * Created by lin on 2016/10/9.
 */

public class MyApplication extends Application {

    private PushAgent mPushAgent;

    @Override
    public void onCreate() {
        super.onCreate();
        HttpUtil.initVolley(Volley.newRequestQueue(this)); //初始化Volley
        ImageUtils.initUIL(this); //初始化UIL
        openUILCache();
        initializeDB();
        initUMengMessage();
    }

    private void initUMengMessage() {
        mPushAgent = PushAgent.getInstance(this);
        //注册推送服务，每次调用register方法都会回调该接口
        mPushAgent.register(new IUmengRegisterCallback() {

            @Override
            public void onSuccess(String deviceToken) {
                //注册成功会返回device token
                Log.e("UmengToken",deviceToken);
            }

            @Override
            public void onFailure(String s, String s1) {
                Log.e(s,s1);
            }
        });

        settingSendMessage();
    }

    public void settingSendMessage() {
        Boolean sendMessage = (Boolean) SpUtil.readSp(getApplicationContext(), Constants.Settings.SP_NAME, Constants.Settings.SEND_MESSAGE);
        if(sendMessage != null && sendMessage == true){
            openUMengMessagePush();
        }else {
            closeUMengMessagePush();
        }
    }

    private void openUMengMessagePush(){
        mPushAgent.enable(new IUmengCallback() {
            @Override
            public void onSuccess() {

            }

            @Override
            public void onFailure(String s, String s1) {

            }
        });
    }

    private void closeUMengMessagePush(){
        mPushAgent.disable(new IUmengCallback() {
            @Override
            public void onSuccess() {

            }

            @Override
            public void onFailure(String s, String s1) {

            }
        });
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
