package com.lqs.fast.gamestore.model;

import com.google.gson.reflect.TypeToken;
import com.lqs.fast.fast.utils.GsonUtil;
import com.lqs.fast.gamestore.app.Constants;

/**
 * Created by dell on 2016/9/30.
 */

public abstract class AAsynReplaceData<T> implements IAsynReplaceData {

    private ReplaceDataListener mReplaceDataListener;
    protected T mData;

    public AAsynReplaceData(ReplaceDataListener listener) {
        mReplaceDataListener = listener;
    }

    @Override
    public ReplaceDataListener getReplaceDataListener() {
        return this.mReplaceDataListener;
    }

    @Override
    public void ReplaceData(String url) {    //更新数据的方法

// 地址应该传参
//        String urlStr = Constants.ApiClient.SELECTED_GAME;

        GsonUtil.DownLoadedJsonListener<T> listener = new GsonUtil.DownLoadedJsonListener<T>() {
            @Override
            public void downLoaded(T t) {
                mData = t;
                ReplaceDataListener replaceDataListener = getReplaceDataListener();

                if (checkData(t))  //验证是否下载数据成功
                {
                    replaceDataListener.replacedData();  // 成功则通知presenter处理成功分支
                } else {
                    replaceDataListener.replaceDataError();  //失败分支
                }
            }
        };

        TypeToken<T> typeToken = new TypeToken<T>() {
        };
        GsonUtil.downLoadJson(url, typeToken, listener);
    }

    protected abstract boolean checkData(T t);
}
