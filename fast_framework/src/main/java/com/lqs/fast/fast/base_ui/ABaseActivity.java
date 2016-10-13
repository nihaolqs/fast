package com.lqs.fast.fast.base_ui;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by lin on 2016/10/5.
 */

public abstract class ABaseActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(getLayoutResID());
//        initUI();
//        initData();
    }

    protected abstract void initData();

    protected abstract void initUI();

    protected abstract int getLayoutResID();
}
