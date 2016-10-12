package com.lqs.fast.gamestore.view;

import com.lqs.fast.gamestore.bean.GameInfoBean;
import com.lqs.fast.gamestore.presenter.ISearchGamePresenter;

import java.util.List;

/**
 * Created by dell on 2016/10/11.
 */

public interface ISearchGameView {

    void showHotSearchGameList(List<GameInfoBean> gameList);

    void showSearchedGameList(List<GameInfoBean> gameList);

    void showSearchedError();

    void showSearchHistory(List<String> strList);

    void setSearchGamePresenter(ISearchGamePresenter searchGamePresenter);

    ISearchGamePresenter getSearchGamePresenter();

    String getSearchType();

    String getSearchContent();
}
