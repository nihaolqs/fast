package com.lqs.fast.gamestore.presenter;

import com.lqs.fast.gamestore.bean.GameInfoBean;

/**
 * Created by dell on 2016/9/30.
 */

public abstract class ABasePresenter<M,V> {

    private M mModel;
    private V mView;

    public ABasePresenter(V view)
    {
        mView = view;
        mModel = initModel();
        initData();
    }
    protected abstract M initModel();

    protected abstract void initData();

    public abstract void replaceData();

    public M getModel(){
        return this.mModel;
    }

    public V getView(){
        return this.mView;
    }

    public void showGameDetail(GameInfoBean bean){

    }

//    public void
}
