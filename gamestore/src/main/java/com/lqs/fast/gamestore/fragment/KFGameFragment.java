package com.lqs.fast.gamestore.fragment;

import android.support.v4.view.ViewPager;
import android.view.View;

import com.astuetz.PagerSlidingTabStrip;
import com.lqs.fast.fast.base_ui.ABaseFragment;
import com.lqs.fast.gamestore.R;
import com.lqs.fast.gamestore.adatpter.MyKfGameVPAdatpter;
import com.lqs.fast.gamestore.bean.KfGame;

/**
 * Created by dell on 2016/10/10.
 */

public class KFGameFragment extends ABaseFragment<KFGameFragment,KfGame>{
    public static final String TAG = "KFGameFragment";
    private PagerSlidingTabStrip mTabs;
    private ViewPager mViewPage;

    @Override
    public String getViewTag() {
        return TAG;
    }

    @Override
    protected void initMvp() {

    }

    @Override
    protected void initUI() {
        mTabs = (PagerSlidingTabStrip) mFragmentLauout.findViewById(R.id.fragmain_selete1_kaifu_indecator);
        int color = getResources().getColor(R.color.text_green);
        mTabs.setTextColor(color);
        mViewPage = (ViewPager) mFragmentLauout.findViewById(R.id.fragmain_selete1_kaifu_vp);
        MyKfGameVPAdatpter myKfGameVPAdatpter = new MyKfGameVPAdatpter(getChildFragmentManager());
        mViewPage.setAdapter(myKfGameVPAdatpter);
        mTabs.setViewPager(mViewPage);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected int getLayoutResId() {
        return R.layout.frag_kaifu;
    }
}
