package com.lqs.fast.gamestore.view;

import com.lqs.fast.gamestore.bean.GameInfoBean;
import com.lqs.fast.gamestore.presenter.ISelectedGamePresenter;

import java.util.List;

/**
 * Created by lin on 2016/10/5.
 */

public interface ISelectedGameView {
    void showSelectedGameList(List<GameInfoBean> list);
    ISelectedGamePresenter getSelectedGamePresenter();
    void setSelectedGamePresenter(ISelectedGamePresenter selectedGamePresenter);
}
