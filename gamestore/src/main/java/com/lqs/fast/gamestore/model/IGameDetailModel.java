package com.lqs.fast.gamestore.model;

import com.lqs.fast.fast.base.model.IAsynReplaceDataModel;
import com.lqs.fast.gamestore.bean.GameDetail;
import com.lqs.fast.gamestore.presenter.IGameDetailPresenter;

/**
 * Created by lin on 2016/10/13.
 */

public interface IGameDetailModel extends IAsynReplaceDataModel {

    GameDetail.GameDeatilBean getGameDetail();

    IGameDetailPresenter getGameDetailPresenter();

    void setGameDetailPresenter(IGameDetailPresenter gameDetailPresenter);
}
