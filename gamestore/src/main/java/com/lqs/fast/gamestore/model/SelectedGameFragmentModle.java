package com.lqs.fast.gamestore.model;

import com.lqs.fast.fast.base.model.ABaseModel;
import com.lqs.fast.gamestore.app.Constants;
import com.lqs.fast.gamestore.bean.GameInfoBean;
import com.lqs.fast.gamestore.bean.SelectedGame;
import com.lqs.fast.gamestore.presenter.ISelectedGamePresenter;

import java.util.List;

/**
 * AAsynReplaceData 抽离出数据更新的方法
 * Created by dell on 2016/9/30.
 */

public class SelectedGameFragmentModle extends ABaseModel<,SelectedGame> implements IAdGameModel,ISelectedGameModel{

    protected boolean checkData(SelectedGame selectedGame) {  //验证数据是否下载成功
        int errorno = selectedGame.getErrorno();
        int successful = Constants.ApiClient.SUCCESSFUL;
        return errorno == successful;
    }

    @Override
    public List<GameInfoBean> getAdGameList() {
        return this.mData.getAd_list();
    }

    @Override
    public List<GameInfoBean> getSelectedGameList() {
        return this.mData.getSelected_list();
    }


    @Override
    protected boolean checkData(Object o) {
        return false;
    }

    @Override
    public void addPresenter(ISelectedGamePresenter iSelectedGamePresenter) {

    }
}
