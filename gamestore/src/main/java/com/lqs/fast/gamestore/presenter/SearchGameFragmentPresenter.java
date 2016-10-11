package com.lqs.fast.gamestore.presenter;

import android.content.Context;

import com.lqs.fast.fast.base.model.ReplaceDataListener;
import com.lqs.fast.fast.base.presenter.ABasePresenter;
import com.lqs.fast.fast.utils.ToastUtils;
import com.lqs.fast.gamestore.app.Constants;
import com.lqs.fast.gamestore.bean.GameInfoBean;
import com.lqs.fast.gamestore.model.ISearchGameModel;
import com.lqs.fast.gamestore.model.SearchGameFragmentModle;
import com.lqs.fast.gamestore.view.ISearchGameView;

import java.util.List;

/**
 * Created by dell on 2016/10/11.
 */

public class SearchGameFragmentPresenter extends ABasePresenter<SearchGameFragmentModle> implements ISearchGamePresenter {
    public static final String TAG = "SearchGameFragmentPresenter";
    private final Context mContext;

    public SearchGameFragmentPresenter(Context context)
    {
       this.mContext = context;
    }

    @Override
    public String getPresenterTag() {
        return TAG;
    }

    @Override
    public void replaceData() {
        final ISearchGameModel searchGameModel = getSearchGameModel();
        ReplaceDataListener listener = new ReplaceDataListener() {
            @Override
            public void replacedData() {
                showHotSearchGameList();
                showSearchHistory();
            }

            @Override
            public void replaceDataError() {
                ToastUtils.makeToast(mContext,"数据更新错误!");
            }
        };
        searchGameModel.ReplaceData(Constants.ApiClient.HOT_SEARCH,listener);
    }

    @Override
    public void showDetail(GameInfoBean bean) {

    }

    @Override
    public void showHotSearchGameList() {
        ISearchGameModel searchGameModel = getSearchGameModel();
        ISearchGameView searchGameView = getSearchGameView();
        List<GameInfoBean> hotSearchGameList = searchGameModel.getHotSearchGameList();
        searchGameView.showHotSearchGameList(hotSearchGameList);
    }

    @Override
    public void showSearchedGameList() {
        ISearchGameModel searchGameModel = getSearchGameModel();
        ISearchGameView searchGameView = getSearchGameView();
        List<GameInfoBean> searchGameList = searchGameModel.getSearchGameList();
        searchGameView.showSearchedGameList(searchGameList);
    }

    @Override
    public void showSearchHistory() {
        ISearchGameModel searchGameModel = getSearchGameModel();
        ISearchGameView searchGameView = getSearchGameView();
        List<String> searchHistory = searchGameModel.getSearchHistory();
        searchGameView.showSearchHistory(searchHistory);
    }

    @Override
    public void searchGame(String keyWord) {

    }

    @Override
    public void setSearchGameModel(ISearchGameModel searchGameModel) {

    }

    @Override
    public ISearchGameModel getSearchGameModel() {
        return null;
    }

    @Override
    public void setSerachGameView(ISearchGameView serachGameView) {

    }

    @Override
    public ISearchGameView getSearchGameView() {
        return null;
    }
}
