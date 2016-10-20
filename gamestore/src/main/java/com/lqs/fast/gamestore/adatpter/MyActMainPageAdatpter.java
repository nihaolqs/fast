package com.lqs.fast.gamestore.adatpter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.lqs.fast.gamestore.app.Constants;
import com.lqs.fast.gamestore.bean.GameDetail;
import com.lqs.fast.gamestore.bean.SearchGame;
import com.lqs.fast.gamestore.fragment.FreaturedGameFragment;
import com.lqs.fast.gamestore.fragment.GameDetailFragment;
import com.lqs.fast.gamestore.fragment.ManagerFragment;
import com.lqs.fast.gamestore.fragment.SearchGameFragment;

/**
 * Created by dell on 2016/10/13.
 */

public class MyActMainPageAdatpter extends FragmentPagerAdapter{
    public MyActMainPageAdatpter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position){
            case 0: {
                fragment = FreaturedGameFragment.getInstance(FreaturedGameFragment.class, "");
            }
            break;
            case 1:{
                fragment = SearchGameFragment.getInstance(SearchGameFragment.class, Constants.Type.SEARCH_GAME);
            }
            break;
            case 2:{
                fragment = ManagerFragment.getInstance(ManagerFragment.class, "391");
//                fragment = FreaturedGameFragment.getInstance(FreaturedGameFragment.class, "");
            }
            break;
            case 3:{
                fragment = FreaturedGameFragment.getInstance(FreaturedGameFragment.class, "");
            }
            break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 4;
    }
}
