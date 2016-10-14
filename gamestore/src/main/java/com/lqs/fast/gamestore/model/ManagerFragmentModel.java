package com.lqs.fast.gamestore.model;

import com.lqs.fast.fast.base.model.ABaseModel;
import com.lqs.fast.fast.base.model.ReplaceDataListener;
import com.lqs.fast.fast.base.presenter.ABasePresenter;
import com.lqs.fast.gamestore.bean.GameInfoBean;
import com.lqs.fast.gamestore.presenter.IManagerPresenter;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by dell on 2016/10/14.
 */

public class ManagerFragmentModel extends ABaseModel<List<GameInfoBean>>  implements IManagerModel{
    public static final String TAG = "ManagerFragmentModel";
    @Override
    protected boolean checkData(List<GameInfoBean> list) {
        return false;
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
    public void ReplaceData(String url, ReplaceDataListener listener) {
        ReplaceData(listener);
    }

    @Override
    public void ReplaceData(ReplaceDataListener listener) {

    }

    @Override
    public List<GameInfoBean> getDownloadedGame() {
        return null;
    }

    @Override
    public String getPhoneMemoryInfo() {
        return null;
    }

    @Override
    public String getDownloadAlready() {
        return null;
    }

    @Override
    public String getDownloadAvailable() {
        return null;
    }

    @Override
    public IManagerPresenter getManagerPresenter() {
        return null;
    }

    @Override
    public void serManagerPresenter(IManagerPresenter managerPresenter) {

    }
}
