package com.lqs.fast.fast.base.presenter;

import com.lqs.fast.fast.base.model.ABaseModel;
import com.lqs.fast.fast.base.view.ABaseView;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dell on 2016/9/30.
 */

public abstract class ABasePresenter<M extends ABaseModel> {

    public static final String TAG = null;
    protected Map<String, ABaseModel> mModelMap = new HashMap<>();
    protected Map<String, ABaseView> mViewMap = new HashMap<>();

    public void addModel(ABaseModel m) {
        mModelMap.put(m.getModelTag(), m);
    }

    public void addView(ABaseView v) {
        mViewMap.put(v.getViewTag(), v);
    }

    public ABaseModel getModel(String tag) {
        ABaseModel m = mModelMap.get(tag);
        return m;
    }

    public ABaseView getView(String tag) {
        ABaseView v = mViewMap.get(tag);
        return v;
    }

    public abstract String getPresenterTag();
}
