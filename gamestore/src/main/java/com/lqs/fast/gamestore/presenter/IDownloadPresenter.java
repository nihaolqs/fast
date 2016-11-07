package com.lqs.fast.gamestore.presenter;


import com.lqs.fast.gamestore.bean.SaveGameInfoBean;
import com.lqs.fast.gamestore.service.MyDownLoadService;
import com.lqs.fast.gamestore.view.IDownLoadView;

/**
 * Created by dell on 2016/10/18.
 */

public interface IDownloadPresenter {

    void addDownLoadTask(String url);

    void setDownLoadListener(MyDownLoadService.IDownLoadListener listener);

    void pauseDownLoadTask(String url);

    void continueDownLoadTast(String url);

    void cancelDownLoadTask(String url);

    int getDownLoadState(String url);

    void saveGameInfo(SaveGameInfoBean bean);

    void checkFileExists(String url,ICheckListener listener);


}
