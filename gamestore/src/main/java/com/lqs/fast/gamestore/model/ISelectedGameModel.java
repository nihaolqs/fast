package com.lqs.fast.gamestore.model;

import com.lqs.fast.fast.base.model.IAsynReplaceDataModel;
import com.lqs.fast.gamestore.bean.GameInfoBean;
import com.lqs.fast.gamestore.presenter.ISelectedGamePresenter;

import java.util.List;

/**
 * Created by dell on 2016/9/29.
 */

public interface ISelectedGameModel extends IAsynReplaceDataModel,IBaseModel<ISelectedGamePresenter>{
    List<GameInfoBean> getSelectedGameList();
}
