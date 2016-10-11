package com.lqs.fast.gamestore.fragment;

import android.view.View;
import android.widget.GridView;
import android.widget.ListView;

import com.lqs.fast.fast.base_ui.ABaseFragment;
import com.lqs.fast.gamestore.R;
import com.lqs.fast.gamestore.bean.GameInfoBean;
import com.lqs.fast.gamestore.presenter.ISearchGamePresenter;
import com.lqs.fast.gamestore.view.ISearchGameView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell on 2016/10/11.
 */

public class SearchGameFragment extends ABaseFragment<SearchGameFragment, String> implements ISearchGameView {
    private ArrayList<GameInfoBean> mHotCearchGame = new ArrayList<>();
    private ArrayList<GameInfoBean> mSearchedGame = new ArrayList<>();
    private GridView mGvHotSearch;
    private ListView mLvSearched;

    @Override
    protected void initMvp() {

    }

    @Override
    protected void initUI() {
        mGvHotSearch = (GridView) mFragmentLauout.findViewById(R.id.gv_frag_search_hotsearch);
        mLvSearched = (ListView) mFragmentLauout.findViewById(R.id.frag_search_lv);

    }


    @Override
    protected void initData() {

    }

    @Override
    protected int getLayoutResId() {
        return R.layout.frag_search;
    }

    @Override
    public String getViewTag() {
        return null;
    }

    @Override
    public void showHotSearchGameList(List<GameInfoBean> gameList) {

    }

    @Override
    public void showSearchedGameList(List<GameInfoBean> gameList) {

    }

    @Override
    public void showSearchedError() {

    }

    @Override
    public void showSearchHistory(List<String> strList) {

    }

    @Override
    public void setSearchGamePresenter(ISearchGamePresenter searchGamePresenter) {

    }

    @Override
    public ISearchGamePresenter getSearchGamePresenter() {
        return null;
    }

    @Override
    public String getSearchType() {
        return null;
    }
}
