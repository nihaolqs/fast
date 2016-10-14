package com.lqs.fast.gamestore.presenter;

import android.content.Context;

import com.lqs.fast.fast.base.model.ABaseModel;
import com.lqs.fast.fast.base.model.ReplaceDataListener;
import com.lqs.fast.fast.base.presenter.ABasePresenter;
import com.lqs.fast.fast.base.view.ABaseView;
import com.lqs.fast.gamestore.bean.GameInfoBean;
import com.lqs.fast.gamestore.fragment.ManagerFragment;
import com.lqs.fast.gamestore.model.IManagerModel;
import com.lqs.fast.gamestore.model.ManagerFragmentModel;
import com.lqs.fast.gamestore.view.IManagerView;

import java.util.List;

/**
 * Created by dell on 2016/10/14.
 */

public class ManagerFragmentPresenter extends ABasePresenter<ManagerFragmentModel> implements IManagerPresenter{
    public static final String TAG ="ManagerFragmentPresenter";
    protected Context mContext;

    public ManagerFragmentPresenter(Context context)
    {
        this.mContext = context;
    }
    @Override
    public String getPresenterTag() {
        return TAG;
    }

    @Override
    public void showDownLoadedGame() {
        IManagerModel model = getManagerModel();
        IManagerView view = getManagerView();
        List<GameInfoBean> list = model.getDownloadedGame();
        view.showDownLoadedGame(list);
    }

    @Override
    public void showDetail(GameInfoBean bean) {

    }

    @Override
    public void showManageInfo() {
        IManagerView view = getManagerView();
        IManagerModel model = getManagerModel();
        String downloadAlready = model.getDownloadAlready();
        view.showDownloadAlready(downloadAlready);
        String downloadAvailable = model.getDownloadAvailable();
        view.showDownloadAvailable(downloadAvailable);
        String phoneMemoryInfo = model.getPhoneMemoryInfo();
        view.showPhoneMemoryInfo(phoneMemoryInfo);
    }

    @Override
    public void replaceData() {
        IManagerModel model = getManagerModel();
        model.ReplaceData(new ReplaceDataListener() {
            @Override
            public void replacedData() {
                showDownLoadedGame();
                showManageInfo();
            }

            @Override
            public void replaceDataError() {

            }
        });
    }

    @Override
    public IManagerModel getManagerModel() {
        IManagerModel model = (IManagerModel) getModel(ManagerFragmentModel.TAG);
        return model;
    }

    @Override
    public void setManagetModel(IManagerModel managetModel) {
        addModel((ABaseModel) managetModel);
    }

    @Override
    public IManagerView getManagerView() {
        ABaseView view = getView(ManagerFragment.TAG);
        return (IManagerView) view;
    }

    @Override
    public void setManagerView(IManagerView managerView) {

        addView((ABaseView) managerView);

    }
}
