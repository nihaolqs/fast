package com.lqs.fast.gamestore.presenter;

import com.lqs.fast.gamestore.bean.GameInfoBean;
import com.lqs.fast.gamestore.model.IManagerModel;
import com.lqs.fast.gamestore.view.IManagerView;

/**
 * Created by dell on 2016/10/14.
 */

public interface IManagerPresenter {

    void showDownLoadedGame();

    void showDetail(GameInfoBean bean);

    void showManageInfo();

    void replaceData();

    IManagerModel getManagerModel();

    void setManagetModel(IManagerModel managetModel);

    IManagerView getManagerView();

    void setManagerView(IManagerView managerView);
}
