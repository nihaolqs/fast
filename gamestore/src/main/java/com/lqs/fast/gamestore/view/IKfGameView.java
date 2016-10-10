package com.lqs.fast.gamestore.view;

import com.lqs.fast.gamestore.bean.GameInfoBean;
import com.lqs.fast.gamestore.bean.KfGame;
import com.lqs.fast.gamestore.presenter.IKfGamePresenter;

import java.util.List;

/**
 * Created by dell on 2016/10/10.
 */

public interface IKfGameView {
    void showKfGameList(List<KfGame.KfListBean> kflist);

    IKfGamePresenter getKfGamePresenter();

    void setKfGamePresenter(IKfGamePresenter kfGamePresenter);

    String getUrl();
}
