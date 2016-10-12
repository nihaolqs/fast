package com.lqs.fast.gamestore.model;

import com.google.gson.reflect.TypeToken;
import com.lqs.fast.fast.base.model.ABaseModel;
import com.lqs.fast.fast.base.model.ReplaceDataListener;
import com.lqs.fast.fast.base.presenter.ABasePresenter;
import com.lqs.fast.fast.utils.GsonUtil;
import com.lqs.fast.gamestore.app.Constants;
import com.lqs.fast.gamestore.bean.GameInfoBean;
import com.lqs.fast.gamestore.bean.HotSearch;
import com.lqs.fast.gamestore.bean.ISearch;
import com.lqs.fast.gamestore.bean.KfGameSearch;
import com.lqs.fast.gamestore.bean.SearchGame;
import com.lqs.fast.gamestore.presenter.ISearchGamePresenter;
import com.lqs.fast.gamestore.presenter.SearchGameFragmentPresenter;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell on 2016/9/30.
 */

public class SearchGameFragmentModle<T extends ISearch> extends ABaseModel<HotSearch> implements ISearchGameModel {

    public static final String TAG = "SearchGameFragmentModle";

    private T mSearchGameData;

    @Override
    protected boolean checkData(HotSearch searchGame) {
        int errorno = mData.getErrorno();
        int successful = Constants.ApiClient.SUCCESSFUL;
        return errorno == successful;
    }

    @Override
    public String getModelTag() {
        return TAG;
    }

    @Override
    public Type getTType() {
        TypeToken<HotSearch> typeToken = new TypeToken<HotSearch>() {
        };
        Type type = typeToken.getType();
        return type;
    }


    @Override
    public List<GameInfoBean> getSearchGameList() {
        List<GameInfoBean> selected_list = mSearchGameData.getSearched();
        return selected_list;
    }

    @Override
    public List<GameInfoBean> getHotSearchGameList() {
        List<GameInfoBean> hot_list = mData.getHot_list();
        return hot_list;
    }

    @Override
    public List<String> getSearchHistory() {
        return null;
    }

    @Override
    public ISearchGamePresenter getSearchGamePresenter() {
        ISearchGamePresenter presenter = (ISearchGamePresenter) getPresenter(SearchGameFragmentPresenter.TAG);
        return presenter;
    }

    @Override
    public void setSearchGamePresenter(ISearchGamePresenter searchGamePresenter) {
        ABasePresenter presenter = (ABasePresenter) searchGamePresenter;
        addPresenter(presenter);
    }

    @Override
    public void searchGame(String keyWord, final ReplaceDataListener listener, String searchType) {
        String searchUrl = null;
        if(searchType.equals(Constants.Type.SEARCH_GAME)){
            searchUrl = Constants.ApiClient.SEARCH_GAME;
        }else if(searchType.equals(Constants.Type.SEARCH_KF)){
            searchUrl = Constants.ApiClient.SEARCH_KF;
        }
        if(searchUrl != null){

            GsonUtil.DownLoadedJsonListener<T> l = new GsonUtil.DownLoadedJsonListener<T>() {
                @Override
                public void downLoaded(T searchGame) {
                    mSearchGameData = searchGame;
                    boolean b = checkSearchGameData(searchGame);
                    if(b){
                        listener.replacedData();
                    }else{
                        listener.replaceDataError();
                    }
                }
            };
            Class searchClass = getSearchClass(searchType);
            GsonUtil.downLoadJson(searchUrl,searchClass,l);
        }
    }

    private boolean checkSearchGameData(T searchGame)
    {
        int errorno = searchGame.getErrorno();
        int successful = Constants.ApiClient.SUCCESSFUL;
        return errorno == successful;
    }

    private Class getSearchClass(String searchType)
    {
        if(searchType.equals(Constants.Type.SEARCH_GAME)){
            return SearchGame.class;
        }else {
            return KfGameSearch.class;
        }
    }
}
