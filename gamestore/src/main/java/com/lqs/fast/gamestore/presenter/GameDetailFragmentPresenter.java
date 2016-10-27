package com.lqs.fast.gamestore.presenter;

import android.content.Context;

import com.lqs.fast.fast.base.model.ABaseModel;
import com.lqs.fast.fast.base.model.ReplaceDataListener;
import com.lqs.fast.fast.base.presenter.ABasePresenter;
import com.lqs.fast.fast.base.view.ABaseView;
import com.lqs.fast.fast.utils.ToastUtils;
import com.lqs.fast.gamestore.app.Constants;
import com.lqs.fast.gamestore.bean.GameDetail;
import com.lqs.fast.gamestore.fragment.GameDetailFragment;
import com.lqs.fast.gamestore.model.GameDetailFragmentModel;
import com.lqs.fast.gamestore.model.IGameDetailModel;
import com.lqs.fast.gamestore.view.IGameDetailView;

/**
 * Created by lin on 2016/10/13.
 */

public class GameDetailFragmentPresenter extends ABasePresenter<GameDetailFragmentModel> implements IGameDetailPresenter {
    protected   Context mContext;

    public GameDetailFragmentPresenter(Context context)
    {
        this.mContext  = context;
    }

    public static final String TAG = "GameDetailFragmentPresenter";
    @Override
    public String getPresenterTag() {
        return TAG;
    }

    @Override
    public void showGameDetail() {
        IGameDetailModel model = getGameDetailModel();
        IGameDetailView view = getGameDetailView();
        GameDetail.GameDeatilBean gameDetail = model.getGameDetail();
        view.showGameDetail(gameDetail);
    }

    @Override
    public void replaceData() {
        final IGameDetailModel model = getGameDetailModel();
        IGameDetailView view = getGameDetailView();
        String guid = view.getGuid();
        String url = Constants.ApiClient.GAME_DETAIL;
        model.ReplaceData(url, new ReplaceDataListener() {
            @Override
            public void replacedData() {
                showGameDetail();
            }

            @Override
            public void replaceDataError() {
                ToastUtils.makeToast(mContext,"数据加载错误");
            }
        });
    }

    @Override
    public IGameDetailModel getGameDetailModel() {
        IGameDetailModel model = (IGameDetailModel) getModel(GameDetailFragmentModel.TAG);
        return model;
    }

    @Override
    public void setGameDetailModel(IGameDetailModel model) {
        addModel((ABaseModel) model);
    }

    @Override
    public IGameDetailView getGameDetailView() {
        IGameDetailView view = (IGameDetailView) getView(GameDetailFragment.TAG);
        return view;
    }

    @Override
    public void setGameDetailView(IGameDetailView view) {
        addView((ABaseView) view);
    }

    public GameDetail.GameDeatilBean getGameInfoData(){
        return getGameDetailModel().getGameDetail();
    }
}
