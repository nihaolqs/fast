package com.lqs.fast.gamestore.presenter;

import com.lqs.fast.gamestore.model.IGameDetailModel;
import com.lqs.fast.gamestore.view.IGameDetailView;

/**
 * Created by lin on 2016/10/13.
 */

public interface IGameDetailPresenter {

    void showGameDetail();

    void replaceData();

    IGameDetailModel getGameDetailModel();

    void setGameDetailModel(IGameDetailModel model);

    IGameDetailView getGameDetailView();

    void setGameDetailView(IGameDetailView view);
}
