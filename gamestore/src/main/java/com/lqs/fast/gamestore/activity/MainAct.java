package com.lqs.fast.gamestore.activity;

import android.support.v4.view.ViewPager;

import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.lqs.fast.gamestore.R;
import com.lqs.fast.gamestore.adatpter.MyActMainPageAdatpter;

/**
 * Created by dell on 2016/10/13.
 */

public class MainAct extends ABaseActivity {

    private RadioGroup mRgFragmentGroup;
    private ViewPager mPage;
    private boolean isDragging;
    private View mMainTitle;
    private TextView mMainCententTitle;

    @Override
    protected void initData() {

    }

    @Override
    protected void initUI() {
        initFindView();
        initViewPage();
        initRadioGroup();

    }

    private void initRadioGroup() {
        mRgFragmentGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (!isDragging) {
                    switch (checkedId) {
                        case R.id.main_selete:
                            mPage.setCurrentItem(0, false);
                            break;
                        case R.id.main_search:
                            mPage.setCurrentItem(1, false);
                            break;
                        case R.id.main_manager:
                            mPage.setCurrentItem(2, false);
                            break;
                        case R.id.main_help:
                            mPage.setCurrentItem(3, false);
                            break;
                    }

                }
            }
        });
    }

    private void initViewPage() {

        MyActMainPageAdatpter myActMainPageAdatpter = new MyActMainPageAdatpter(getSupportFragmentManager());
        mPage.setAdapter(myActMainPageAdatpter);
        mPage.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0: {
                        mRgFragmentGroup.check(R.id.main_selete);
                        mMainTitle.setVisibility(View.GONE);
                    }
                    break;
                    case 1: {
                        mRgFragmentGroup.check(R.id.main_search);
                        mMainTitle.setVisibility(View.GONE);
                    }
                    break;
                    case 2: {
                        mRgFragmentGroup.check(R.id.main_manager);
                        mMainTitle.setVisibility(View.VISIBLE);
                        mMainCententTitle.setText("管理");
                    }
                    break;
                    case 3: {
                        mRgFragmentGroup.check(R.id.main_help);
                        mMainTitle.setVisibility(View.VISIBLE);
                        mMainCententTitle.setText("帮助中心");
                    }
                    break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                isDragging = (state == ViewPager.SCROLL_STATE_DRAGGING);
            }
        });
    }

    private void initFindView() {
        mRgFragmentGroup = (RadioGroup) findViewById(R.id.main_rg);
        mPage = (ViewPager) findViewById(R.id.mPager);
        mMainTitle = findViewById(R.id.main_title_rl);
        mMainTitle.setVisibility(View.GONE);
        mMainCententTitle = (TextView) findViewById(R.id.center_title);
    }

    @Override
    protected int getLayoutResID() {
        return R.layout.act_main;
    }
}
