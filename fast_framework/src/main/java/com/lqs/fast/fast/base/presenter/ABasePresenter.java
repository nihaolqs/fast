package com.lqs.fast.fast.base.presenter;

import com.lqs.fast.fast.base.model.ABaseModel;
import com.lqs.fast.fast.base.view.ABaseView;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dell on 2016/9/30.
 */

public class ABasePresenter<M extends ABaseModel,V extends ABaseView> {

    public static final String TAG = null;
    protected Map<String,ABaseModel> mModelMap = new HashMap<>();
    protected Map<String,ABaseView> mViewMap = new HashMap<>();
    public void addModel(M m) {
        mModelMap.put(m.TAG,m);
    }

    public void addView(V v) {
        mViewMap.put(v.TAG,v);
    }

    public M getModel(String tag) {
        M m = (M) mModelMap.get(tag);
        return m;
    }

    public V getView(String tag) {
        V v  = (V) mViewMap.get(tag);
        return v;
    }
}
