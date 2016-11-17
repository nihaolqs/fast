package com.lqs.fast.gamestore.adatpter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.lqs.fast.gamestore.bean.GameInfoBean;
import com.lqs.fast.gamestore.fragment.BannerPageFragment;

import java.util.List;

/**
 * Created by dell on 2016/10/8.
 */

public class MyBannerAdatpter extends FragmentStatePagerAdapter {
    private List<GameInfoBean> mGameList;
    public static final int COUNT_MULTIPLE = 10000;


    public MyBannerAdatpter(FragmentManager fm, List<GameInfoBean> list) {
        super(fm);
        mGameList = list;
    }

    @Override
    public Fragment getItem(int position) {
        GameInfoBean gameInfoBean = mGameList.get(position % mGameList.size());
        BannerPageFragment fragment = BannerPageFragment.getInstance(BannerPageFragment.class, gameInfoBean);
        return fragment;
    }

    @Override
    public int getCount() {
        return mGameList.size() * COUNT_MULTIPLE;
    }
}
