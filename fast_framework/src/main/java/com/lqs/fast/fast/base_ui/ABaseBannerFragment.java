package com.lqs.fast.fast.base_ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell on 2016/10/26.
 */

public abstract class ABaseBannerFragment<T extends ABaseBannerFragment.IBanner> extends Fragment{

    private View mFragmentLayout;
    private ViewPager mVpBanner;
    private MyFragmentPageAdatpter adapter;
    private ArrayList<T> mDataList = new ArrayList<>();  //存储Banner数据

    public ABaseBannerFragment(List<T> tList){
        this.mDataList.addAll(tList);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        mFragmentLayout = inflater.inflate(getLayoutRes(),container);
        initViewPage();
        return mFragmentLayout;
    }

    private void initViewPage() {
        mVpBanner = (ViewPager) mFragmentLayout.findViewById(getViewPageId());
        adapter = new MyFragmentPageAdatpter(getChildFragmentManager());
        mVpBanner.setAdapter(adapter);
    }

    protected abstract int getViewPageId();

    protected abstract int getLayoutRes();

    public class MyFragmentPageAdatpter extends FragmentStatePagerAdapter{

        public MyFragmentPageAdatpter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return null;
        }

        @Override
        public int getCount() {
            return mDataList.size();
        }
    }

    public class MyBannerPageFragment extends Fragment{
        private final T mPageData;

        public MyBannerPageFragment(T banner){
            this.mPageData = banner;
        }
        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            super.onCreateView(inflater, container, savedInstanceState);
            View page = inflater.inflate(getPageLayoutRes(), null);
            initPageUI(page,mPageData);
            return page;
        }
    }

    protected abstract void initPageUI(View page, T mPageData);


    protected abstract int getPageLayoutRes();

    public interface IBanner{  //数据接口
        String getImageUrl();
        String getTitle();
    }
}
