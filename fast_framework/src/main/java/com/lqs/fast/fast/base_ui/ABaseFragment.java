package com.lqs.fast.fast.base_ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lqs.fast.fast.base.view.ABaseView;

import java.io.Serializable;

/**
 * Created by lin on 2016/10/5.
 */

public abstract class ABaseFragment<T extends ABaseFragment,S extends Serializable> extends ABaseView{

    protected LayoutInflater mLayoutInflater;
    protected View mFragmentLauout;
    protected S mData;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        initBundleData();
        mLayoutInflater = inflater;
        mFragmentLauout = mLayoutInflater.inflate(getLayoutResId(), container, false);
        initUI();
        initData();
        return mFragmentLauout;
    }

    protected  void initBundleData(){
        Bundle bundle = getArguments();
        S s = (S) bundle.getSerializable(T.TAG);
        mData = s;
    }

    protected abstract void initUI();

    protected abstract void initData();

    protected abstract int getLayoutResId();

    public static<T extends ABaseFragment,S extends Serializable> T getInstance(Class<T> tClass, S s){
        T t = null;
        try {
            t = tClass.newInstance();
            Bundle bundle = new Bundle();
            bundle.putSerializable(T.TAG,s);
            t.setArguments(bundle);
        } catch (java.lang.InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return t;
    }
}
