package com.lqs.fast.gamestore.presenter;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import android.widget.ListView;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.lqs.fast.fast.base.model.ABaseModel;
import com.lqs.fast.fast.base.model.ReplaceDataListener;
import com.lqs.fast.fast.base.presenter.ABasePresenter;
import com.lqs.fast.fast.base.view.ABaseView;
import com.lqs.fast.fast.utils.LogUtil;
import com.lqs.fast.fast.utils.ToastUtils;
import com.lqs.fast.gamestore.MainActivity;
import com.lqs.fast.gamestore.activity.GameDetailActivity;
import com.lqs.fast.gamestore.activity.MainAct;
import com.lqs.fast.gamestore.app.Constants;
import com.lqs.fast.gamestore.bean.GameInfoBean;
import com.lqs.fast.gamestore.bean.SelectedGame;
import com.lqs.fast.gamestore.fragment.SelectedGameFragment;
import com.lqs.fast.gamestore.model.IAdGameModel;
import com.lqs.fast.gamestore.model.ISearchGameModel;
import com.lqs.fast.gamestore.model.ISelectedGameModel;
import com.lqs.fast.gamestore.model.SelectedGameFragmentModle;
import com.lqs.fast.gamestore.service.MyDownLoadService;
import com.lqs.fast.gamestore.view.IAdGameView;
import com.lqs.fast.gamestore.view.ISelectedGameView;

import java.util.List;

import static android.content.Context.BIND_AUTO_CREATE;

/**
 * Created by lin on 2016/10/5.
 */

public class SelectedGameFragmentPresenter extends ABasePresenter implements IAdGamePresenter, ISelectedGamePresenter {

    public static final String TAG = "SelectedGameFragmentPresenter";
    private Context mContext;

    public SelectedGameFragmentPresenter(Context context) {
        this.mContext = context;
    }

    @Override
    public String getPresenterTag() {
        return SelectedGameFragmentPresenter.TAG;
    }

    @Override
    public void showAdGameList() {
        IAdGameModel adGameModel = getAdGameModel();
        List<GameInfoBean> adGameList = adGameModel.getAdGameList();
        IAdGameView adGameView = getAdGameView();
        adGameView.showAdGameList(adGameList);
    }

    @Override
    public void replaceData() {
        replaceData(null);
    }

    @Override
    public void showSelectedGameList() {
        ISelectedGameModel selectedGameModel = getSelectedGameModel();
        List<GameInfoBean> searchGameList = selectedGameModel.getSelectedGameList();
        ISelectedGameView selectedGameView = getSelectedGameView();
        selectedGameView.showSelectedGameList(searchGameList);
    }

    @Override
    public void replaceData(final PullToRefreshBase<ListView> refreshView) {
        ReplaceDataListener listener = new ReplaceDataListener() {
            @Override
            public void replacedData() {
                showAdGameList();
                showSelectedGameList();
                if (refreshView != null) {
                    refreshView.onRefreshComplete();
                    Log.e("onRefreshComplete","onRefreshComplete");
                }
            }

            @Override
            public void replaceDataError() {
                LogUtil.d(TAG, "数据更新错误");
                if (refreshView != null) {
                    refreshView.onRefreshComplete();
                    Log.e("onRefreshComplete","onRefreshComplete");
                }
            }
        };
        ABaseModel<SelectedGame> selectedGameModel = (ABaseModel) getSelectedGameModel();
        selectedGameModel.ReplaceData(Constants.ApiClient.SELECTED_GAME, listener);
    }

    @Override
    public void showDeatil(GameInfoBean bean) {

        Intent intent = new Intent(mContext, GameDetailActivity.class);
        intent.putExtra(GameDetailActivity.GUID_KEY, bean.getGuid());
        mContext.startActivity(intent);
    }

    @Override
    public ISelectedGameModel getSelectedGameModel() {
        ISelectedGameModel model = (ISelectedGameModel) getModel(SelectedGameFragmentModle.TAG);
        return model;
    }

    @Override
    public void setSelectedGameModel(ISelectedGameModel searchGameModel) {
        ABaseModel model = (ABaseModel) searchGameModel;
        addModel(model);
    }

    @Override
    public ISelectedGameView getSelectedGameView() {
        ISelectedGameView view = (ISelectedGameView) getView(SelectedGameFragment.TAG);
        return view;
    }

    @Override
    public void setSelectedGameView(ISelectedGameView selectedGameView) {
        ABaseView view = (ABaseView) selectedGameView;
        addView(view);
    }

    @Override
    public void nextPage() {
        ISelectedGameModel model = getSelectedGameModel();
        ReplaceDataListener listener = new ReplaceDataListener() {
            @Override
            public void replacedData() {
                showSelectedGameList();
            }

            @Override
            public void replaceDataError() {

            }
        };
        model.nextPageData(listener);
    }

    @Override
    public IAdGameModel getAdGameModel() {
        IAdGameModel model = (IAdGameModel) getModel(SelectedGameFragmentModle.TAG);
        return model;
    }

    @Override
    public void setAdGameModel(IAdGameModel adGameModel) {
        ABaseModel model = (ABaseModel) adGameModel;
        addModel(model);
    }

    @Override
    public IAdGameView getAdGameView() {
        IAdGameView view = (IAdGameView) getView(SelectedGameFragment.TAG);
        return view;
    }

    @Override
    public void setAdGameView(IAdGameView adGameView) {
        ABaseView view = (ABaseView) adGameView;
        addView(view);
    }

    @Override
    public void onStart(Context context) {


    }

    @Override
    public void onStop(Context context) {
        super.onStop(context);


    }
}
