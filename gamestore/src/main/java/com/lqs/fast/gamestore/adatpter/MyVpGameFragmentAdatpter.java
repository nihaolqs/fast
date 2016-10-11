package com.lqs.fast.gamestore.adatpter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.lqs.fast.gamestore.fragment.KFGameFragment;
import com.lqs.fast.gamestore.fragment.SelectedGameFragment;

/**
 * Created by dell on 2016/10/11.
 */

public class MyVpGameFragmentAdatpter extends FragmentPagerAdapter{
    public MyVpGameFragmentAdatpter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        if (position == 0){
            fragment = SelectedGameFragment.getInstance(SelectedGameFragment.class, "");
        }else if(position == 1)
        {
            fragment = KFGameFragment.getInstance(KFGameFragment.class,"");
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 2;
    }
}
