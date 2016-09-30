package com.lqs.fast.gamestore.view;

import com.lqs.fast.gamestore.presenter.ABasePresenter;

import java.util.List;

/**
 * Created by dell on 2016/9/30.
 */

public interface IBaseView<P extends ABasePresenter,S> {
    P getPresenter();
    void showListContent(List<S> sList);
}
