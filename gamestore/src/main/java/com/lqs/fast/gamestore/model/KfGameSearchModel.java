package com.lqs.fast.gamestore.model;

import com.lqs.fast.gamestore.app.Constants;
import com.lqs.fast.gamestore.bean.GameInfoBean;
import com.lqs.fast.gamestore.bean.KfGameSearch;

import java.util.List;

/**
 * Created by dell on 2016/9/30.
 */

public class KfGameSearchModel extends AAsynReplaceDataModel<KfGameSearch> implements IKfGameSearchModle{
    public KfGameSearchModel(ReplaceDataListener listener) {
        super(listener);
    }

    @Override
    protected boolean checkData(KfGameSearch kfGameSearch) {
        int errorno = mData.getErrorno();
        int successful = Constants.ApiClient.SUCCESSFUL;
        return errorno == successful;
    }

    @Override
    public List<GameInfoBean> getKfGameSearchList() {
        return mData.getKf_list();
    }
}
