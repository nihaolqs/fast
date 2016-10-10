package com.lqs.fast.gamestore.adatpter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.lqs.fast.gamestore.app.Constants;
import com.lqs.fast.gamestore.fragment.KFGamePageFragment;

/**
 * Created by dell on 2016/10/10.
 */

public class MyKfGameVPAdatpter extends FragmentPagerAdapter {
    private String[] mTitles = new String[]{"今天","明天"};
    public MyKfGameVPAdatpter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        KFGamePageFragment pageFragment = null;
        if (position == 0) {
            pageFragment = KFGamePageFragment.getInstance(KFGamePageFragment.class, Constants.ApiClient.KF_GAME);
            return pageFragment;
        } else if (position == 1) {
             pageFragment = KFGamePageFragment.getInstance(KFGamePageFragment.class, Constants.ApiClient.KF_GAME);
        }
        return pageFragment;
    }

    @Override
    public int getCount() {
        return mTitles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }
}
