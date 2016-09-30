package com.lqs.fast.gamestore.model;

import com.lqs.fast.gamestore.app.Constants;
import com.lqs.fast.gamestore.bean.KfGame;

import java.util.List;

/**
 * Created by dell on 2016/9/30.
 */

public class KfGameFragmentModel extends AAsynReplaceData<KfGame> implements IKfGameModel{

    public KfGameFragmentModel(ReplaceDataListener listener) {
        super(listener);
    }

    @Override
    protected boolean checkData(KfGame kfGame) {
        int successful = Constants.ApiClient.SUCCESSFUL;
        int errorno = mData.getErrorno();
        return successful == errorno;
    }

    @Override
    public List<KfGame.KfListBean> getKfGameList() {
        return mData.getKf_list();
    }
}
