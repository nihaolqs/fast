package com.lqs.fast.gamestore.fragment;

import com.lqs.fast.fast.base_ui.ABaseFragment;
import com.lqs.fast.gamestore.bean.GameInfoBean;
import com.lqs.fast.gamestore.presenter.ISearchGamePresenter;
import com.lqs.fast.gamestore.view.ISearchGameView;

import java.util.List;

/**
 * Created by dell on 2016/10/11.
 */

public class SearchGameFragment extends ABaseFragment<SearchGameFragment,String> implements ISearchGameView{
    @Override
    protected void initMvp() {

    }

    @Override
    protected void initUI() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected int getLayoutResId() {
        return 0;
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
