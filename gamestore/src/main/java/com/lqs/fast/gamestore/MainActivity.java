package com.lqs.fast.gamestore;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.lqs.fast.gamestore.app.Constants;
import com.lqs.fast.gamestore.fragment.FreaturedGameFragment;
import com.lqs.fast.gamestore.fragment.KFGameFragment;
import com.lqs.fast.gamestore.fragment.KFGamePageFragment;
import com.lqs.fast.gamestore.fragment.SelectedGameFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SelectedGameFragment selectedGameFragment = new SelectedGameFragment();
        KFGamePageFragment kfGamePageFragment = KFGamePageFragment.getInstance(KFGamePageFragment.class, Constants.ApiClient.KF_GAME);
        KFGameFragment kfGameFragment = KFGameFragment.getInstance(KFGameFragment.class, "kf");
        FreaturedGameFragment freaturedGameFragment = FreaturedGameFragment.getInstance(FreaturedGameFragment.class, "");
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.container,freaturedGameFragment);
        ft.commit();
    }
}
