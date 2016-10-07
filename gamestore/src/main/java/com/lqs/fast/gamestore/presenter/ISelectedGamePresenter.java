package com.lqs.fast.gamestore.presenter;

import com.lqs.fast.gamestore.model.ISelectedGameModel;
import com.lqs.fast.gamestore.view.ISelectedGameView;

/**
 * Created by lin on 2016/10/5.
 */

public interface ISelectedGamePresenter extends IBasePresenter<ISelectedGameModel,ISelectedGameView>{
    void getsele();
}
