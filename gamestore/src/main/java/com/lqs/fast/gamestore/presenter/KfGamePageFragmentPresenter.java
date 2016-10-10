package com.lqs.fast.gamestore.presenter;

import android.content.Context;

import com.lqs.fast.fast.base.model.ABaseModel;
import com.lqs.fast.fast.base.model.ReplaceDataListener;
import com.lqs.fast.fast.base.presenter.ABasePresenter;
import com.lqs.fast.fast.base.view.ABaseView;
import com.lqs.fast.fast.utils.ToastUtils;
import com.lqs.fast.gamestore.bean.GameInfoBean;
import com.lqs.fast.gamestore.bean.KfGame;
import com.lqs.fast.gamestore.fragment.KFGamePageFragment;
import com.lqs.fast.gamestore.model.IKfGameModel;
import com.lqs.fast.gamestore.model.KfGamePageFragmentModel;
import com.lqs.fast.gamestore.view.IKfGameView;

import java.util.List;

/**
 * Created by dell on 2016/10/10.
 */

public class KfGamePageFragmentPresenter extends ABasePresenter<KfGamePageFragmentModel> implements IKfGamePresenter{
    public static final String TAG = "KfGamePageFragmentPresenter";
    private Context mContext;

    public KfGamePageFragmentPresenter(Context context){
        this.mContext = context;
    }
    @Override
    public String getPresenterTag() {
        return TAG;
    }

    @Override
    public void showKfGameList() {
        IKfGameModel kfGameModel = getKfGameModel();
        List<KfGame.KfListBean> kfGameList = kfGameModel.getKfGameList();
        IKfGameView kfGameView = getKfGameView();
        kfGameView.showKfGameList(kfGameList);
    }

    @Override
    public void replaceData() {
        IKfGameModel kfGameModel = getKfGameModel();
        final IKfGameView kfGameView = getKfGameView();
        String url = kfGameView.getUrl();
        ReplaceDataListener listener = new ReplaceDataListener() {
            @Override
            public void replacedData() {
                showKfGameList();
            }

            @Override
            public void replaceDataError() {
                ToastUtils.makeToast(mContext,"数据更新错误");
            }
        };
        kfGameModel.ReplaceData(url,listener);
    }

    @Override
    public void showDeatil(GameInfoBean bean) {

    }

    @Override
    public IKfGameModel getKfGameModel() {
        IKfGameModel model = (IKfGameModel) getModel(KfGamePageFragmentModel.TAG);
        return model;
    }

    @Override
    public void setKfGameModel(IKfGameModel kfGameModel) {
        ABaseModel model = (ABaseModel) kfGameModel;
        addModel(model);
    }

    @Override
    public IKfGameView getKfGameView() {
        IKfGameView view = (IKfGameView) getView(KFGamePageFragment.TAG);
        return view;
    }

    @Override
    public void setKfGameView(IKfGameView kfGameView) {
        ABaseView view = (ABaseView) kfGameView;
        addView(view);
    }
}
