package com.lqs.fast.gamestore.model;

import com.lqs.fast.fast.base.model.IAsynReplaceDataModel;
import com.lqs.fast.gamestore.bean.KfGame;
import com.lqs.fast.gamestore.presenter.IKfGamePresenter;

import java.util.List;

/**
 * Created by dell on 2016/9/29.
 */

public interface IKfGameModel extends IAsynReplaceDataModel {
    List<KfGame.KfListBean> getKfGameList();

    IKfGamePresenter getKfGamePresenter();

    void setKfGamePresenter(IKfGamePresenter kfGamePresenter);

}
