package com.lqs.fast.gamestore.activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.lqs.fast.fast.utils.OtherUtil;

/**
 * Created by lin on 2016/10/5.
 */

public abstract class ABaseActivity extends AppCompatActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        OtherUtil.HideStatusBar(this);
        setContentView(getLayoutResID());
    }

    protected abstract void initData();

    protected abstract void initUI();

    protected abstract int getLayoutResID();
}
