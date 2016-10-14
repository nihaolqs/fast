package com.lqs.fast.gamestore.model;

import com.lqs.fast.fast.base.model.IAsynReplaceDataModel;
import com.lqs.fast.fast.base.model.ReplaceDataListener;
import com.lqs.fast.gamestore.bean.GameInfoBean;
import com.lqs.fast.gamestore.presenter.IManagerPresenter;

import java.util.List;

/**
 * Created by dell on 2016/10/14.
 */

public interface IManagerModel extends IAsynReplaceDataModel {
    List<GameInfoBean> getDownloadedGame();

    String getPhoneMemoryInfo();

    String getDownloadAlready();

    String getDownloadAvailable();

    IManagerPresenter getManagerPresenter();

    void serManagerPresenter(IManagerPresenter managerPresenter);

    void ReplaceData(ReplaceDataListener listener);
}
