package com.lqs.fast.gamestore.view;

import com.lqs.fast.fast.base.model.IAsynReplaceDataModel;
import com.lqs.fast.gamestore.bean.GameDetail;
import com.lqs.fast.gamestore.bean.GameInfoBean;
import com.lqs.fast.gamestore.presenter.IGameDetailPresenter;

/**
 * Created by lin on 2016/10/13.
 */

public interface IGameDetailView{

    void showGameDetail(GameDetail.GameDeatilBean gameDeatilBean);

    IGameDetailPresenter getGameDetailPresenter();

    void setGameDetailPresenter(IGameDetailPresenter gameDetailPresenter);

    String getGuid();
}
