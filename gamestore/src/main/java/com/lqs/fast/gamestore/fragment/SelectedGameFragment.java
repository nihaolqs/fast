package com.lqs.fast.gamestore.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.lqs.fast.fast.base.presenter.ABasePresenter;
import com.lqs.fast.fast.base_ui.*;
import com.lqs.fast.gamestore.R;
import com.lqs.fast.gamestore.adatpter.MyBannerAdatpter;
import com.lqs.fast.gamestore.adatpter.MySelectedGameListAdatpter;
import com.lqs.fast.gamestore.bean.GameInfoBean;
import com.lqs.fast.gamestore.model.IAdGameModel;
import com.lqs.fast.gamestore.model.ISelectedGameModel;
import com.lqs.fast.gamestore.model.SelectedGameFragmentModle;
import com.lqs.fast.gamestore.presenter.DownLoadPresenter;
import com.lqs.fast.gamestore.presenter.IAdGamePresenter;
import com.lqs.fast.gamestore.presenter.IDownloadPresenter;
import com.lqs.fast.gamestore.presenter.ISelectedGamePresenter;
import com.lqs.fast.gamestore.presenter.SelectedGameFragmentPresenter;
import com.lqs.fast.gamestore.service.MyDownLoadService;
import com.lqs.fast.gamestore.view.IAdGameView;
import com.lqs.fast.gamestore.view.IDownLoadView;
import com.lqs.fast.gamestore.view.ISelectedGameView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lin on 2016/10/5.
 */

public class SelectedGameFragment extends com.lqs.fast.fast.base_ui.ABaseFragment implements IAdGameView, ISelectedGameView, IDownLoadView {

    public static final String TAG = "SelectedGameFragment";
    private View mHeaderView;
    private ViewPager mBannerViewPage;
    private ArrayList<GameInfoBean> mAdGames = new ArrayList<>();
    private ArrayList<GameInfoBean> mSelectedGames = new ArrayList<>();
    private MyBannerAdatpter mMyBannerAdatpter;
    private ListView mSelectedListView;
    private MySelectedGameListAdatpter mMySelectedGameListAdatpter;
    private MyDownLoadService.IDownLoadListener mDownloadListener;

    private boolean isDistory;

    @Override
    protected void initUI() {
        initHeaderView();
        initListView();
    }

    private void initListView() {
        mSelectedListView = (ListView) mFragmentLauout.findViewById(R.id.lv_frag_selected_gamelist);
        mSelectedListView.addHeaderView(mHeaderView, null, false);
        mMySelectedGameListAdatpter = new MySelectedGameListAdatpter(mSelectedGames, getContext(), getDownLoadPresenter());
        mSelectedListView.setAdapter(mMySelectedGameListAdatpter);
        mSelectedListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                GameInfoBean gameInfoBean = mSelectedGames.get(position);
                getSelectedGamePresenter().showDeatil(gameInfoBean);
            }
        });
    }

    private void initHeaderView() {
        mHeaderView = mLayoutInflater.inflate(R.layout.header_seletefrag, null);
        mBannerViewPage = (ViewPager) mHeaderView.findViewById(R.id.fragmain_selete_vp);
        FragmentManager fm = getChildFragmentManager();
        mMyBannerAdatpter = new MyBannerAdatpter(fm, mAdGames);
        mBannerViewPage.setAdapter(mMyBannerAdatpter);
    }

    @Override
    protected void initData() {
        IAdGamePresenter adGamePresenter = getAdGamePresenter();
        adGamePresenter.replaceData();
    }

    @Override
    protected void initMvp() {
        SelectedGameFragmentModle selectedGameFragmentModle = new SelectedGameFragmentModle();
        SelectedGameFragmentPresenter selectedGameFragmentPresenter = new SelectedGameFragmentPresenter(getContext());
        selectedGameFragmentModle.setAdGamePresenter(selectedGameFragmentPresenter);
        selectedGameFragmentPresenter.setAdGameModel(selectedGameFragmentModle);
        selectedGameFragmentPresenter.setAdGameView(this);
        this.setAdGamePresenter(selectedGameFragmentPresenter);

//        DownLoadPresenter downLoadPresenter = new DownLoadPresenter();
//        this.setDownLoadPresenter(downLoadPresenter);
//
//        downLoadPresenter.onStart(getContext());
//        setDownLoadListener();


    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_selectedgame;
    }

    @Override
    public void showAdGameList(List<GameInfoBean> gameList) {
        mAdGames.clear();
        mAdGames.addAll(gameList);
        mMyBannerAdatpter.notifyDataSetChanged();
    }

    @Override
    public IAdGamePresenter getAdGamePresenter() {
        IAdGamePresenter presenter = (IAdGamePresenter) getPresenter(SelectedGameFragmentPresenter.TAG);
        return presenter;
    }

    @Override
    public void setAdGamePresenter(IAdGamePresenter adGamePresenter) {
        SelectedGameFragmentPresenter presenter = (SelectedGameFragmentPresenter) adGamePresenter;
        addPresenter(presenter);
    }

    @Override
    public String getViewTag() {
        return SelectedGameFragment.TAG;
    }

    @Override
    public void showSelectedGameList(List<GameInfoBean> list) {
        mSelectedGames.clear();
        mSelectedGames.addAll(list);
        mMySelectedGameListAdatpter.notifyDataSetChanged();
    }

    @Override
    public ISelectedGamePresenter getSelectedGamePresenter() {
        ISelectedGamePresenter presenter = (ISelectedGamePresenter) getPresenter(SelectedGameFragmentPresenter.TAG);
        return presenter;
    }

    @Override
    public void setSelectedGamePresenter(ISelectedGamePresenter selectedGamePresenter) {
        ABasePresenter presenter = (ABasePresenter) selectedGamePresenter;
        addPresenter(presenter);
    }

    @Override
    public void onStart() {
        super.onStart();
        ABasePresenter presenter = (ABasePresenter) getDownLoadPresenter();
        this.setDownLoadPresenter((IDownloadPresenter) presenter);
        presenter.onStart(getContext());
        setDownLoadListener();
        isDistory = false;
    }

    @Override
    public void onStop() {
        super.onStop();
//
//        presenter.onStop(getContext());
        isDistory = true;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            DownLoadPresenter downLoadPresenter = new DownLoadPresenter();
            this.setDownLoadPresenter(downLoadPresenter);
            Context context = getContext();
            if (context != null) {
                downLoadPresenter.onStart(context);
                setDownLoadListener();
            }
        } else {
            DownLoadPresenter downLoadPresenter = (DownLoadPresenter) getDownLoadPresenter();

            if (downLoadPresenter != null) {
                downLoadPresenter.onStop(getContext());
            }
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        ABasePresenter presenter = (ABasePresenter) getSelectedGamePresenter();
        presenter.onStop(getContext());

    }

    //
//    @Override
//    public void onDestroyView() {
//        super.onDestroyView();
//        ABasePresenter presenter = (ABasePresenter) getSelectedGamePresenter();
//        presenter.onStop(getContext());
//    }

    @Override
    public void setDownLoadListener() {
        IDownloadPresenter downLoadPresenter = getDownLoadPresenter();
        mDownloadListener = new MyDownLoadService.IDownLoadListener() {
            @Override
            public void wail(String url) {
                setItemState(url, "等待");
            }

            @Override
            public void progress(String url, int progre) {
                setItemState(url, progre + "%");
            }

            @Override
            public void completed(String url) {
                setItemState(url, "完成");
            }

            @Override
            public void fail(String url) {
                setItemState(url, "重试");
            }

            @Override
            public void speed(String url, long speed) {

            }

            @Override
            public void downloadedSize(String url, long size) {

            }
        };
        downLoadPresenter.setDownLoadListener(mDownloadListener);

    }

    private void setItemState(String url, final String state) {
        if (!isDistory) {
            for (int i = 0; i < mSelectedGames.size(); i++) {
                GameInfoBean bean = mSelectedGames.get(i);
                if (bean.getDownload_url().equals(url) && i >= mSelectedListView.getFirstVisiblePosition() && i < mSelectedListView.getLastVisiblePosition()) {  //在可见范围内才进行更新进度

                    View childAt = mSelectedListView.getChildAt(i + mSelectedListView.getHeaderViewsCount() - mSelectedListView.getFirstVisiblePosition());
                    final TextView tvState = (TextView) childAt.findViewById(R.id.item_select_tv_state);
                    tvState.post(new Runnable() {
                        @Override
                        public void run() {
                            tvState.setText(state);
                        }
                    });
                }
            }
        }
    }

    @Override
    public void setDownLoadPresenter(IDownloadPresenter downLoadPresenter) {
        addPresenter((ABasePresenter) downLoadPresenter);
    }

    @Override
    public IDownloadPresenter getDownLoadPresenter() {
        ABasePresenter presenter = getPresenter(DownLoadPresenter.TAG);
        return (IDownloadPresenter) presenter;
    }
}
