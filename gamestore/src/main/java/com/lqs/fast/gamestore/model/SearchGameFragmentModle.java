package com.lqs.fast.gamestore.model;

import com.lqs.fast.gamestore.app.Constants;
import com.lqs.fast.gamestore.bean.GameInfoBean;
import com.lqs.fast.gamestore.bean.SearchGame;

import java.util.List;

/**
 * Created by dell on 2016/9/30.
 */

public class SearchGameFragmentModle extends AAsynReplaceData<SearchGame> implements ISearchGameModel {
    public SearchGameFragmentModle(ReplaceDataListener listener) {
        super(listener);
    }

    @Override
    protected boolean checkData(SearchGame searchGame) {
        int errorno = mData.getErrorno();
        int successful = Constants.ApiClient.SUCCESSFUL;
        return errorno == successful;
    }

    @Override
    public List<GameInfoBean> getSearchGameList() {
        return mData.getSelected_list();
    }
}
