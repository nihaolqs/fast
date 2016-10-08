package com.lqs.fast.fast.base.view;

import android.support.v4.app.Fragment;

import com.lqs.fast.fast.base.presenter.ABasePresenter;

import java.util.HashMap;

/**
 * Created by lin on 2016/10/2.
 */

/**
 *
 * @param <> 数据类的类型
 */
public abstract class ABaseView extends Fragment{
    public static final String TAG = null;

    protected HashMap<String,ABasePresenter> mPresenterMap = new HashMap<>();

    public ABasePresenter getPresenter(String tag) {
        ABasePresenter presenter =  mPresenterMap.get(tag);
        return presenter;
    }

    public void addPresenter(ABasePresenter p) {
        mPresenterMap.put(p.getPresenterTag(),p);
    }

    public abstract String getViewTag();
}
