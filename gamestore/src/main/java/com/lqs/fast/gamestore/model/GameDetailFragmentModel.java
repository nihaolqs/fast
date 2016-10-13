package com.lqs.fast.gamestore.model;

import com.google.gson.reflect.TypeToken;
import com.lqs.fast.fast.base.model.ABaseModel;
import com.lqs.fast.fast.base.presenter.ABasePresenter;
import com.lqs.fast.gamestore.app.Constants;
import com.lqs.fast.gamestore.bean.GameDetail;
import com.lqs.fast.gamestore.presenter.GameDetailFragmentPresenter;
import com.lqs.fast.gamestore.presenter.IGameDetailPresenter;

import java.lang.reflect.Type;

/**
 * Created by lin on 2016/10/13.
 */

public class GameDetailFragmentModel extends ABaseModel<GameDetail> implements IGameDetailModel{

    public static final String TAG = "GameDetailFragmentModel";
    @Override
    protected boolean checkData(GameDetail gameDetail) {
        int errorno = gameDetail.getErrorno();

        return errorno == Constants.ApiClient.SUCCESSFUL;
    }

    @Override
    public String getModelTag() {
        return TAG;
    }

    @Override
    public Type getTType() {
        TypeToken<GameDetail> typeToken = new TypeToken<GameDetail>() {
        };
        return typeToken.getType();
    }

    @Override
    public GameDetail.GameDeatilBean getGameDetail() {
        GameDetail.GameDeatilBean game_info = mData.getGame_info();
        return game_info;
    }

    @Override
    public IGameDetailPresenter getGameDetailPresenter() {
        IGameDetailPresenter presenter = (IGameDetailPresenter) getPresenter(GameDetailFragmentPresenter.TAG);
        return presenter;
    }

    @Override
    public void setGameDetailPresenter(IGameDetailPresenter gameDetailPresenter) {
        ABasePresenter presenter = (ABasePresenter) gameDetailPresenter;
        addPresenter(presenter);
    }
}
