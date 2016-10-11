package com.lqs.fast.gamestore.presenter;

import com.lqs.fast.gamestore.bean.GameInfoBean;
import com.lqs.fast.gamestore.model.ISearchGameModel;
import com.lqs.fast.gamestore.view.ISearchGameView;

/**
 * Created by dell on 2016/10/11.
 */

public interface ISearchGamePresenter {
    void replaceData();

    void showDetail(GameInfoBean bean);

    void showHotSearchGameList();

    void showSearchedGameList();

    void showSearchHistory();

    void searchGame(String keyWord);

    void setSearchGameModel(ISearchGameModel searchGameModel);

    ISearchGameModel getSearchGameModel();

    void setSerachGameView(ISearchGameView serachGameView);

    ISearchGameView getSearchGameView();
}
