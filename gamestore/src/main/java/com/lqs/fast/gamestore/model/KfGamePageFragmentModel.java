package com.lqs.fast.gamestore.model;

import com.google.gson.reflect.TypeToken;
import com.lqs.fast.fast.base.model.ABaseModel;
import com.lqs.fast.fast.base.presenter.ABasePresenter;
import com.lqs.fast.gamestore.app.Constants;
import com.lqs.fast.gamestore.bean.KfGame;
import com.lqs.fast.gamestore.presenter.IKfGamePresenter;
import com.lqs.fast.gamestore.presenter.KfGamePageFragmentPresenter;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by dell on 2016/10/10.
 */

public class KfGamePageFragmentModel extends ABaseModel<KfGame> implements IKfGameModel{

    public static final String TAG ="KfGamePageFragmentModel";
    @Override
    protected boolean checkData(KfGame kfGame) {
        int errorno = kfGame.getErrorno();
        boolean flag = errorno == Constants.ApiClient.SUCCESSFUL;
        return flag;
    }

    @Override
    public String getModelTag() {
        return TAG;
    }

    @Override
    public Type getTType() {
        TypeToken<KfGame> typeToken = new TypeToken<KfGame>() {
        };
        Type type = typeToken.getType();
        return type;
    }

    @Override
    public List<KfGame.KfListBean> getKfGameList() {
        List<KfGame.KfListBean> kf_list = mData.getKf_list();
        return kf_list;
    }

    @Override
    public IKfGamePresenter getKfGamePresenter() {
        IKfGamePresenter presenter = (IKfGamePresenter) getPresenter(KfGamePageFragmentPresenter.TAG);
        return presenter;
    }

    @Override
    public void setKfGamePresenter(IKfGamePresenter kfGamePresenter) {
        ABasePresenter presenter = (ABasePresenter) kfGamePresenter;
        addPresenter(presenter);
    }
}
