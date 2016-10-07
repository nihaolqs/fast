package com.lqs.fast.fast.base.view;

import android.support.v4.app.Fragment;

import com.lqs.fast.fast.base.presenter.ABasePresenter;

import java.util.HashMap;

/**
 * Created by lin on 2016/10/2.
 */

/**
 *
 * @param <P> presenter的子类
 * @param <T> 数据类的类型
 */
public abstract class ABaseView<P extends ABasePresenter,T> extends Fragment{
    public static final String TAG = null;

    protected HashMap<String,ABasePresenter> mPresenterMap = new HashMap<>();

    public P getPresenter(String tag) {
        P presenter = (P) mPresenterMap.get(tag);
        return presenter;
    }

    public void addPresenter(P p) {
        mPresenterMap.put(p.TAG,p);
    }
}
