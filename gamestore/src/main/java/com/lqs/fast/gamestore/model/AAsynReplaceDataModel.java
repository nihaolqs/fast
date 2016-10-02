package com.lqs.fast.gamestore.model;

import com.google.gson.reflect.TypeToken;
import com.lqs.fast.fast.utils.GsonUtil;
import com.lqs.fast.gamestore.app.Constants;
import com.lqs.fast.gamestore.presenter.ABasePresenter;

import java.util.HashMap;

/**
 * Created by dell on 2016/9/30.
 */

public abstract class AAsynReplaceDataModel<T> implements IAsynReplaceData {
    public static final String TAG = null;  //标签Modle  设置为空的主要目的是使得子类必须设置标签，否则做存取的时候抛异常
    protected HashMap<String,ABasePresenter> mPresenterMap = new HashMap<>();  //使用静态容器虽然可以保证容器的唯一性，但是会造成垃圾回收时可能会有问题<未验证>
    private ReplaceDataListener mReplaceDataListener;
    protected T mData;

    public<T extends  ABasePresenter> T getPresenter(Class<T> clzz){   //从Modle中获取Presenter
        T presenter = (T) mPresenterMap.get(T.TAG);
        return presenter;
    }
    public void setPresenter(ABasePresenter presenter)  //保存Presenter到
    {
        mPresenterMap.put(presenter.TAG,presenter);
    }
    public AAsynReplaceDataModel(ReplaceDataListener listener) {
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
