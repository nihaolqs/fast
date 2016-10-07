package com.lqs.fast.fast.base_ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lqs.fast.fast.base.view.ABaseView;

/**
 * Created by lin on 2016/10/5.
 */

public abstract class ABaseFragment extends ABaseView{

    protected LayoutInflater mLayoutInflater;
    protected View mFragmentLauout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        initData();
        mLayoutInflater = inflater;
        mFragmentLauout = mLayoutInflater.inflate(getLayoutResId(), container, false);
        initUI();
        return mFragmentLauout;
    }

    protected abstract void initUI();

    protected abstract void initData();

    protected abstract int getLayoutResId();
}
