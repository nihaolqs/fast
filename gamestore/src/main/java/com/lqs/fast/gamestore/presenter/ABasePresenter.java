package com.lqs.fast.gamestore.presenter;

import com.lqs.fast.gamestore.bean.GameInfoBean;
import com.lqs.fast.gamestore.model.AAsynReplaceDataModel;

import java.util.HashMap;

/**
 * Created by dell on 2016/9/30.
 */

public abstract class ABasePresenter<M,V> {

    public static final String TAG = null;
    protected HashMap<String,AAsynReplaceDataModel> mPresenterMap = new HashMap<>();  //使用静态容器虽然可以保证容器的唯一性，但是会造成垃圾回收时可能会有问题<未验证>

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
