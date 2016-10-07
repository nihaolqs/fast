package com.lqs.fast.gamestore.presenter;

import com.lqs.fast.gamestore.model.IAdGameModel;
import com.lqs.fast.gamestore.view.IAdGameView;

/**
 * Created by lin on 2016/10/5.
 */

public interface IAdGamePresenter extends IBasePresenter<IAdGameModel,IAdGameView>{
    void getAD();
}
