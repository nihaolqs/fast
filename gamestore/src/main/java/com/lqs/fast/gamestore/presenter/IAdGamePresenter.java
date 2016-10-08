package com.lqs.fast.gamestore.presenter;

import com.lqs.fast.gamestore.bean.GameInfoBean;
import com.lqs.fast.gamestore.model.IAdGameModel;
import com.lqs.fast.gamestore.view.IAdGameView;

/**
 * Created by lin on 2016/10/5.
 */

public interface IAdGamePresenter {
    void showAdGameList();

    void replaceData();

    void showDeatil(GameInfoBean bean);

    IAdGameModel getAdGameModel();

    void setAdGameModel(IAdGameModel adGameModel);

    IAdGameView getAdGameView();

    void setAdGameView(IAdGameView adGameView);
}
