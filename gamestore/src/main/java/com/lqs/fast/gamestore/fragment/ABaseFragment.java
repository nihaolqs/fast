package com.lqs.fast.gamestore.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.Serializable;

/**
 * Created by dell on 2016/9/30.
 */

public abstract class ABaseFragment<T> extends Fragment {
    public static final String BUNDLE_KEY = "bundle_key";
    private View mLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        initData();
        int fragmentResId = getFragmentResId();
        mLayout = inflater.inflate(fragmentResId, container);
        return mLayout;
    }

    private void initData() {

    }

    protected abstract int getFragmentResId();

    public static <T extends Serializable, S extends ABaseFragment<T>> Fragment getInstance(T t, Class<S> sClass) {
        S s = null;
        try {
            s = sClass.newInstance();
            Bundle bundle = new Bundle();
            bundle.putSerializable(BUNDLE_KEY,t);
        } catch (java.lang.InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return s;
    }
}
