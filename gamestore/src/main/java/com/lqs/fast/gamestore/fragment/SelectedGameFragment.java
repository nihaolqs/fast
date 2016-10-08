package com.lqs.fast.gamestore.fragment;


import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ListView;

import com.lqs.fast.fast.base.presenter.ABasePresenter;
import com.lqs.fast.fast.base_ui.*;
import com.lqs.fast.gamestore.R;
import com.lqs.fast.gamestore.adatpter.MyBannerAdatpter;
import com.lqs.fast.gamestore.adatpter.MySelectedGameListAdatpter;
import com.lqs.fast.gamestore.bean.GameInfoBean;
import com.lqs.fast.gamestore.presenter.IAdGamePresenter;
import com.lqs.fast.gamestore.presenter.ISelectedGamePresenter;
import com.lqs.fast.gamestore.presenter.SelectedGameFragmentPresenter;
import com.lqs.fast.gamestore.view.IAdGameView;
import com.lqs.fast.gamestore.view.ISelectedGameView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lin on 2016/10/5.
 */

public class SelectedGameFragment extends com.lqs.fast.fast.base_ui.ABaseFragment implements IAdGameView,ISelectedGameView{

    public static final String TAG = "SelectedGameFragment";
    private View mHeaderView;
    private ViewPager mBannerViewPage;
    private ArrayList<GameInfoBean> mAdGames = new ArrayList<>();
    private ArrayList<GameInfoBean> mSelectedGames = new ArrayList<>();
    private MyBannerAdatpter mMyBannerAdatpter;
    private ListView mSelectedListView;
    private MySelectedGameListAdatpter mMySelectedGameListAdatpter;

    @Override
    protected void initUI() {
        initHeaderView();
        initListView();
    }

    private void initListView() {
        mSelectedListView = (ListView) mFragmentLauout.findViewById(R.id.lv_frag_selected_gamelist);
        mSelectedListView.addHeaderView(mHeaderView,null,false);
        mMySelectedGameListAdatpter = new MySelectedGameListAdatpter(mSelectedGames, getContext());
        mSelectedListView.setAdapter(mMySelectedGameListAdatpter);
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
        adGamePresenter.showAdGameList();
        ISelectedGamePresenter selectedGamePresenter = getSelectedGamePresenter();
        selectedGamePresenter.showSelectedGameList();
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
}
