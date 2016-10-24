package com.lqs.fast.gamestore.activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

/**
 * Created by lin on 2016/10/5.
 */

public abstract class ABaseSingleFragmentActivity extends ABaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(getContainerViewId(),getFragment());
        ft.commit();
    }

    protected abstract Fragment getFragment();

    protected abstract int getContainerViewId();


}
