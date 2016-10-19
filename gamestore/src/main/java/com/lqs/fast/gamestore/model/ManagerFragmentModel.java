package com.lqs.fast.gamestore.model;

import com.activeandroid.Model;
import com.activeandroid.query.Select;
import com.lqs.fast.fast.base.model.ABaseModel;
import com.lqs.fast.fast.base.model.ReplaceDataListener;
import com.lqs.fast.fast.base.presenter.ABasePresenter;
import com.lqs.fast.gamestore.bean.GameInfoBean;
import com.lqs.fast.gamestore.bean.SaveGameInfoBean;
import com.lqs.fast.gamestore.presenter.IManagerPresenter;
import com.lqs.fast.gamestore.presenter.ManagerFragmentPresenter;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by dell on 2016/10/14.
 */

public class ManagerFragmentModel extends ABaseModel<List<SaveGameInfoBean>>  implements IManagerModel{
    public static final String TAG = "ManagerFragmentModel";
    @Override
    protected boolean checkData(List<SaveGameInfoBean> list) {
        return false;
    }

    @Override
    public String getModelTag() {
        return TAG;
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
    public List<SaveGameInfoBean> getDownloadedGame() {
        List<SaveGameInfoBean> execute = new Select().from(SaveGameInfoBean.class).execute();
        return execute;
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
        ABasePresenter presenter = getPresenter(ManagerFragmentPresenter.TAG);
        return (IManagerPresenter) presenter;
    }

    @Override
    public void serManagerPresenter(IManagerPresenter managerPresenter) {
        addPresenter((ABasePresenter) managerPresenter);
    }
}
