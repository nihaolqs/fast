package com.lqs.fast.myapplication;

import android.view.View;

import com.lqs.fast.fast.base_ui.ABaseBannerFragment;

import java.util.List;

/**
 * Created by dell on 2016/10/26.
 */

public class MyBanner extends ABaseBannerFragment{
    public MyBanner(List list) {
        super(list);
    }

    @Override
    protected int getViewPageId() {
        return 0;
    }

    @Override
    protected int getLayoutRes() {
        return 0;
    }

    @Override
    protected void initPageUI(View page, IBanner mPageData) {

    }

    @Override
    protected int getPageLayoutRes() {
        return 0;
    }
}
