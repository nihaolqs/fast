package com.lqs.fast.gamestore.presenter;

import android.widget.ListView;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.lqs.fast.fast.base.model.ReplaceDataListener;
import com.lqs.fast.gamestore.bean.GameInfoBean;
import com.lqs.fast.gamestore.model.ISearchGameModel;
import com.lqs.fast.gamestore.model.ISelectedGameModel;
import com.lqs.fast.gamestore.view.ISelectedGameView;

/**
 * Created by lin on 2016/10/5.
 */

public interface ISelectedGamePresenter {
    void showSelectedGameList();

    void replaceData(PullToRefreshBase<ListView> refreshView);

    void showDeatil(GameInfoBean bean);

    ISelectedGameModel getSelectedGameModel();

    void setSelectedGameModel(ISelectedGameModel searchGameModel);

    ISelectedGameView getSelectedGameView();

    void setSelectedGameView(ISelectedGameView selectedGameView);

    void nextPage();
}
