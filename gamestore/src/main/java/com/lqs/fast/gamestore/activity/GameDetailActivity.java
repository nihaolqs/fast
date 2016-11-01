package com.lqs.fast.gamestore.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.lqs.fast.fast.utils.OtherUtil;
import com.lqs.fast.gamestore.R;
import com.lqs.fast.gamestore.fragment.GameDetailFragment;

/**
 * Created by dell on 2016/10/17.
 */

public class GameDetailActivity extends AppCompatActivity {

    public static final String GUID_KEY = "detail_guid_intent_key";
    private String mGUID;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        OtherUtil.HideStatusBar(this);
        setContentView(R.layout.activity_gamedetail);
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        GameDetailFragment fragment = GameDetailFragment.getInstance(GameDetailFragment.class, mGUID);
        ft.replace(R.id.container,fragment);
        ft.commit();
    }

    //
//    protected Fragment getFragment() {
//
//        GameDetailFragment fragment = GameDetailFragment.getInstance(GameDetailFragment.class, mGUID);
//        return fragment;
//    }

//    protected int getContainerViewId() {
//        return R.id.container;
//    }

    protected void initData() {
        Intent intent = getIntent();
        mGUID = intent.getStringExtra(GUID_KEY);
    }

//    protected void initUI() {
//
//    }

//    protected int getLayoutResID() {
//        return R.layout.activity_gamedetail;
//    }
}
