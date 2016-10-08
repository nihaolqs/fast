package com.lqs.fast.gamestore.model;

import com.lqs.fast.fast.base.model.ABaseModel;
import com.lqs.fast.fast.base.presenter.ABasePresenter;
import com.lqs.fast.gamestore.app.Constants;
import com.lqs.fast.gamestore.bean.GameInfoBean;
import com.lqs.fast.gamestore.bean.SelectedGame;
import com.lqs.fast.gamestore.presenter.IAdGamePresenter;
import com.lqs.fast.gamestore.presenter.ISelectedGamePresenter;
import com.lqs.fast.gamestore.presenter.SelectedGameFragmentPresenter;

import java.util.List;

/**
 * AAsynReplaceData 抽离出数据更新的方法
 * Created by dell on 2016/9/30.
 */

public class SelectedGameFragmentModle extends ABaseModel<SelectedGame> implements IAdGameModel,ISelectedGameModel{

    public static final String TAG = "SelectedGameFragmentModle";

    @Override
    protected boolean checkData(SelectedGame selectedGame) {  //验证数据是否下载成功
        int errorno = selectedGame.getErrorno();
        int successful = Constants.ApiClient.SUCCESSFUL;
        return errorno == successful;
    }

    @Override
    public String getModelTag() {
        return TAG;
    }

    @Override
    public List<GameInfoBean> getAdGameList() {
        return mData.getAd_list();
    }

    @Override
    public IAdGamePresenter getAdGamePresenter() {
        IAdGamePresenter presenter = (IAdGamePresenter) getPresenter(SelectedGameFragmentPresenter.TAG);
        return presenter;
    }

    @Override
    public void setAdGamePresenter(IAdGamePresenter adGamePresenter) {
        ABasePresenter presenter = (ABasePresenter) adGamePresenter;
        addPresenter(presenter);
    }

    @Override
    public List<GameInfoBean> getSelectedGameList() {
        return mData.getSelected_list();
    }

    @Override
    public ISelectedGamePresenter getSelectedGamePresenter() {
        ISelectedGamePresenter presenter = (ISelectedGamePresenter) getPresenter(SelectedGameFragmentPresenter.TAG);
        return presenter;
    }

    @Override
    public void setAdGamePresenter(ISelectedGamePresenter selectedGamePresenter) {
        ABasePresenter presenter = (ABasePresenter) selectedGamePresenter;
        addPresenter(presenter);
    }
}
