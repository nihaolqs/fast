package com.lqs.fast.gamestore.presenter;

import com.lqs.fast.gamestore.bean.GameInfoBean;
import com.lqs.fast.gamestore.model.IKfGameModel;
import com.lqs.fast.gamestore.view.IKfGameView;

/**
 * Created by dell on 2016/10/10.
 */

public interface IKfGamePresenter {
    void showKfGameList();

    void replaceData();

    void showDeatil(GameInfoBean bean);

    IKfGameModel getKfGameModel();

    void setKfGameModel(IKfGameModel kfGameModel);

    IKfGameView getKfGameView();

    void setKfGameView(IKfGameView kfGameView);
}
