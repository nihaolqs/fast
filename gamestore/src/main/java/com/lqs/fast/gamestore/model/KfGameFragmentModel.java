package com.lqs.fast.gamestore.model;

import com.lqs.fast.fast.base.model.ABaseModel;
import com.lqs.fast.fast.base.model.ReplaceDataListener;
import com.lqs.fast.gamestore.app.Constants;
import com.lqs.fast.gamestore.bean.KfGame;
import com.lqs.fast.gamestore.presenter.IKfGamePresenter;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by dell on 2016/9/30.
 */

public class KfGameFragmentModel extends ABaseModel<KfGame> implements IKfGameModel{

    @Override
    protected boolean checkData(KfGame kfGame) {
        int successful = Constants.ApiClient.SUCCESSFUL;
        int errorno = mData.getErrorno();
        return successful == errorno;
    }

    @Override
    public String getModelTag() {
        return null;
    }

    @Override
    public Type getTType() {
        return null;
    }


    @Override
    public List<KfGame.KfListBean> getKfGameList() {
        return null;
    }

    @Override
    public IKfGamePresenter getKfGamePresenter() {
        return null;
    }

    @Override
    public void setKfGamePresenter(IKfGamePresenter kfGamePresenter) {

    }
}
