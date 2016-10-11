package com.lqs.fast.gamestore.model;

import com.lqs.fast.fast.base.model.IAsynReplaceDataModel;
import com.lqs.fast.fast.base.model.ReplaceDataListener;
import com.lqs.fast.gamestore.bean.GameInfoBean;
import com.lqs.fast.gamestore.presenter.ISearchGamePresenter;

import java.util.List;

/**
 * Created by dell on 2016/9/29.
 */

public interface ISearchGameModel extends IAsynReplaceDataModel {

    List<GameInfoBean> getSearchGameList();

    List<GameInfoBean> getHotSearchGameList();

    List<String> getSearchHistory();

    ISearchGamePresenter getSearchGamePresenter();

    void setSearchGamePresenter(ISearchGamePresenter searchGamePresenter);

    void searchGame(String keyWord, ReplaceDataListener listener,String searchType);
}
