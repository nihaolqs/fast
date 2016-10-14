package com.lqs.fast.gamestore.view;

import com.lqs.fast.gamestore.bean.GameInfoBean;
import com.lqs.fast.gamestore.presenter.IManagerPresenter;

import java.util.List;

/**
 * Created by dell on 2016/10/14.
 */

public interface IManagerView {

    void showDownLoadedGame(List<GameInfoBean> list);

    void showPhoneMemoryInfo(String phoneMemoryInfo);

    void showDownloadAlready(String downloadAlreadyinfo);

    void showDownloadAvailable(String downloadAvailableinfo);

    IManagerPresenter getManagerPresenter();

    void setManagerPresenter(IManagerPresenter managerPresenter);
}
