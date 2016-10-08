package com.lqs.fast.gamestore.view;

import com.lqs.fast.gamestore.bean.GameInfoBean;
import com.lqs.fast.gamestore.presenter.IAdGamePresenter;

import java.util.List;

/**
 * Created by lin on 2016/10/5.
 */

public interface IAdGameView{
    void showAdGameList(List<GameInfoBean> gameList);
    IAdGamePresenter getAdGamePresenter();
    void setAdGamePresenter(IAdGamePresenter adGamePresenter);
}
