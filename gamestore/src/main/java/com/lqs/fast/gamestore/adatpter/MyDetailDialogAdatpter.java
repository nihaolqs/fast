package com.lqs.fast.gamestore.adatpter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.lqs.fast.fast.utils.ImageUtils;
import com.lqs.fast.gamestore.R;
import com.lqs.fast.gamestore.fragment.DetailDailogPageFragment;

import java.util.List;

/**
 * Created by dell on 2016/10/17.
 */

public class MyDetailDialogAdatpter extends FragmentStatePagerAdapter {

    private LayoutInflater mLayoutInflater;
    private List<String> mImageUrls;

    public MyDetailDialogAdatpter(FragmentManager fm, LayoutInflater inflater, List<String> list) {
        super(fm);
        this.mLayoutInflater = inflater;
        this.mImageUrls = list;
    }

    @Override
    public Fragment getItem(int position) {
        String uristr = mImageUrls.get(position);
        DetailDailogPageFragment fragment = DetailDailogPageFragment.getInstance(DetailDailogPageFragment.class, uristr);
        return fragment;
    }

    @Override
    public int getCount() {
        return mImageUrls.size();
    }
}
