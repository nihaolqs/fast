package com.lqs.fast.gamestore;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lqs.fast.fast.utils.OtherUtil;
import com.lqs.fast.gamestore.activity.ABaseActivity;
import com.lqs.fast.gamestore.adatpter.MyActMainPageAdatpter;
import com.lqs.fast.gamestore.app.Constants;
import com.lqs.fast.gamestore.fragment.FreaturedGameFragment;
import com.lqs.fast.gamestore.fragment.KFGameFragment;
import com.lqs.fast.gamestore.fragment.KFGamePageFragment;
import com.lqs.fast.gamestore.fragment.SearchGameFragment;
import com.lqs.fast.gamestore.fragment.SelectedGameFragment;
import com.lqs.fast.gamestore.service.MyDownLoadService;

public class MainActivity extends AppCompatActivity {

    private RadioGroup mRgFragmentGroup;
    private ViewPager mPage;
    private boolean isDragging;
    private RelativeLayout mRlMainTitle;
    private TextView mMainCententTitle;
    private ServiceConnection mDownloadConne;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        OtherUtil.HideStatusBar(this);
        setContentView(R.layout.act_main);
        binderDownloadService();
        initUI();

//        SelectedGameFragment selectedGameFragment = new SelectedGameFragment();
//        KFGamePageFragment kfGamePageFragment = KFGamePageFragment.getInstance(KFGamePageFragment.class, Constants.ApiClient.KF_GAME);
//        KFGameFragment kfGameFragment = KFGameFragment.getInstance(KFGameFragment.class, "kf");
//        FreaturedGameFragment freaturedGameFragment = FreaturedGameFragment.getInstance(FreaturedGameFragment.class, "");
//        SearchGameFragment searchGameFragment = SearchGameFragment.getInstance(SearchGameFragment.class, Constants.Type.SEARCH_GAME);
//        FragmentManager fm = getSupportFragmentManager();
//        FragmentTransaction ft = fm.beginTransaction();
//        ft.replace(R.id.container,searchGameFragment);
//        ft.commit();
    }

    protected void initData() {

    }

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
                        case R.id.main_selete: {
                            mPage.setCurrentItem(0, false);
//                            mRlMainTitle.setVisibility(View.GONE);
                        }
                        break;
                        case R.id.main_search: {
                            mPage.setCurrentItem(1, false);
//                            mRlMainTitle.setVisibility(View.GONE);
                        }
                        break;
                        case R.id.main_manager: {
                            mPage.setCurrentItem(2, false);
//                            mRlMainTitle.setVisibility(View.VISIBLE);

                        }
                        break;
                        case R.id.main_help: {
                            mPage.setCurrentItem(3, false);
//                            mRlMainTitle.setVisibility(View.VISIBLE);
                        }
                        break;
                    }

                }
            }
        });
    }

    private void initViewPage() {

        MyActMainPageAdatpter myActMainPageAdatpter = new MyActMainPageAdatpter(getSupportFragmentManager());
        mPage.setAdapter(myActMainPageAdatpter);
//        mPage.setOffscreenPageLimit(4);
        mPage.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        mRgFragmentGroup.check(R.id.main_selete);
                        mRlMainTitle.setVisibility(View.GONE);
                        break;
                    case 1:
                        mRgFragmentGroup.check(R.id.main_search);
                        mRlMainTitle.setVisibility(View.GONE);
                        break;
                    case 2:
                        mRgFragmentGroup.check(R.id.main_manager);
                        mRlMainTitle.setVisibility(View.VISIBLE);
                        mMainCententTitle.setText("管理");
                        break;
                    case 3:
                        mRgFragmentGroup.check(R.id.main_help);
                        mRlMainTitle.setVisibility(View.VISIBLE);
                        mMainCententTitle.setText("帮助中心");
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
        mRlMainTitle = (RelativeLayout) findViewById(R.id.main_title_rl);
        mMainCententTitle = (TextView) findViewById(R.id.center_title);
    }

    private void binderDownloadService() {
        Intent intent = new Intent(this, MyDownLoadService.class);
        startService(intent) ;
        mDownloadConne = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                MyDownLoadService.setBinder(MainActivity.this, (MyDownLoadService.MyBinder) service);
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {

            }
        };
        bindService(intent, mDownloadConne,BIND_AUTO_CREATE);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        MyDownLoadService.removeBinder(this);
        unbindService(mDownloadConne);
    }
}
