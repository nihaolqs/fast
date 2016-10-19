package com.lqs.fast.gamestore.view;

import com.lqs.fast.gamestore.presenter.IDownloadPresenter;
import com.lqs.fast.gamestore.service.MyDownLoadService;

/**
 * Created by dell on 2016/10/18.
 */

public interface IDownLoadView {

    void setDownLoadListener();

    void setDownLoadPresenter(IDownloadPresenter downLoadPresenter);

    IDownloadPresenter getDownLoadPresenter();
}
