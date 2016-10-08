package com.lqs.fast.gamestore.model;

import com.lqs.fast.fast.base.model.IAsynReplaceDataModel;
import com.lqs.fast.gamestore.bean.GameInfoBean;
import com.lqs.fast.gamestore.presenter.IAdGamePresenter;

import java.util.List;

/**
 * Created by dell on 2016/9/29.
 */

public interface  IAdGameModel extends IAsynReplaceDataModel{  //TODO
    List<GameInfoBean> getAdGameList();
    IAdGamePresenter getAdGamePresenter();
    void setAdGamePresenter(IAdGamePresenter adGamePresenter);
}
