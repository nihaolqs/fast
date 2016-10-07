package com.lqs.fast.gamestore.fragment;


import com.lqs.fast.fast.base_ui.*;
import com.lqs.fast.gamestore.presenter.IAdGamePresenter;
import com.lqs.fast.gamestore.presenter.ISelectedGamePresenter;
import com.lqs.fast.gamestore.view.IAdGameView;
import com.lqs.fast.gamestore.view.ISelectedGameView;

/**
 * Created by lin on 2016/10/5.
 */

public class SelectedGameFragment extends com.lqs.fast.fast.base_ui.ABaseFragment implements IAdGameView,ISelectedGameView{
    @Override
    public IAdGamePresenter getPresenter(String tag) {
        return null;
    }

    @Override
    public void addPresenter(ISelectedGamePresenter iSelectedGamePresenter) {

    }

    @Override
    protected void initUI() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected int getLayoutResId() {
        return 0;
    }
}
