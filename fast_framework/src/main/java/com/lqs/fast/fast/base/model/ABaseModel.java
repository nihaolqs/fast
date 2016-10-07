package com.lqs.fast.fast.base.model;

/**
 * Created by lin on 2016/10/4.
 */

import com.google.gson.reflect.TypeToken;
import com.lqs.fast.fast.base.presenter.ABasePresenter;
import com.lqs.fast.fast.utils.GsonUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @param <P> presenter的子类
 * @param <T> 数据POJO类的类型
 */
public abstract class ABaseModel<P extends ABasePresenter, T> implements IAsynReplaceDataModel {
    public static final String TAG = null;

    //presenter数据保存map
    protected Map<String, ABasePresenter> presenterMap = new HashMap<>();
    //保存Model数据pojo类
    protected T mData;

    @Override
    public void ReplaceData(String url, final ReplaceDataListener listener) { //更新数据

        TypeToken<T> typetoken = new TypeToken<T>() {
        };
        GsonUtil.DownLoadedJsonListener<T> l = new GsonUtil.DownLoadedJsonListener<T>() {
            @Override
            public void downLoaded(T t) {
                if (checkData(t)) {
                    listener.replacedData();
                } else {
                    listener.replaceDataError();
                }
            }
        };
        GsonUtil.downLoadJson(url, typetoken, l);
    }

    public P getPresenter(String tag) { //返回presenter 的方法
        P presenter = (P) presenterMap.get(tag);
        return presenter;
    }

    public void addPresenter(P p) {  //保存Presenter的方法
        presenterMap.put(p.TAG, p);
    }

    protected abstract boolean checkData(T t);  //检查数据下载是否成功的方法
}
