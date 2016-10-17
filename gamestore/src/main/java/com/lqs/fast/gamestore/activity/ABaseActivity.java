package com.lqs.fast.gamestore.activity;

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
    }

    protected abstract void initData();

    protected abstract void initUI();

    protected abstract int getLayoutResID();
}
