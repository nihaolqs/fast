package com.lqs.fast.gamestore.model;

import com.lqs.fast.fast.base.model.ABaseModel;
import com.lqs.fast.fast.base.model.ReplaceDataListener;
import com.lqs.fast.gamestore.app.Constants;
import com.lqs.fast.gamestore.bean.GameInfoBean;
import com.lqs.fast.gamestore.bean.SearchGame;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by dell on 2016/9/30.
 */

public class SearchGameFragmentModle extends ABaseModel<SearchGame> implements ISearchGameModel {


    @Override
    protected boolean checkData(SearchGame searchGame) {
        int errorno = mData.getErrorno();
        int successful = Constants.ApiClient.SUCCESSFUL;
        return errorno == successful;
    }

    @Override
    public String getModelTag() {
        return null;
    }

    @Override
    public Type getTType() {
        return null;
    }

    @Override
    public List<GameInfoBean> getSearchGameList() {
        return mData.getSelected_list();
    }
}
