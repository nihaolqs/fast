package com.lqs.fast.gamestore.presenter;

import com.lqs.fast.gamestore.bean.GameInfoBean;
import com.lqs.fast.gamestore.model.ISearchGameModel;
import com.lqs.fast.gamestore.model.ISelectedGameModel;
import com.lqs.fast.gamestore.view.ISelectedGameView;

/**
 * Created by lin on 2016/10/5.
 */

public interface ISelectedGamePresenter{
    void showSelectedGameList();
    void replaceData();
    void showDeatil(GameInfoBean bean);

    ISearchGameModel getSearchGameModel();

    void setSearchGameModel(ISearchGameModel searchGameModel);

    ISelectedGameView getSelectedGameView();

    void setSelectedGameView(ISelectedGameView selectedGameView);
}
