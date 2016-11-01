package com.lqs.fast.gamestore.model;

import android.util.Log;

import com.android.volley.toolbox.Volley;
import com.google.gson.reflect.TypeToken;
import com.lqs.fast.fast.base.model.ABaseModel;
import com.lqs.fast.fast.base.model.ReplaceDataListener;
import com.lqs.fast.fast.base.presenter.ABasePresenter;
import com.lqs.fast.fast.utils.GsonUtil;
import com.lqs.fast.fast.utils.HttpUtil;
import com.lqs.fast.gamestore.app.Constants;
import com.lqs.fast.gamestore.bean.GameInfoBean;
import com.lqs.fast.gamestore.bean.SelectedGame;
import com.lqs.fast.gamestore.presenter.IAdGamePresenter;
import com.lqs.fast.gamestore.presenter.ISelectedGamePresenter;
import com.lqs.fast.gamestore.presenter.SelectedGameFragmentPresenter;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * AAsynReplaceData 抽离出数据更新的方法
 * Created by dell on 2016/9/30.
 */

public class SelectedGameFragmentModle extends ABaseModel<SelectedGame> implements IAdGameModel,ISelectedGameModel{
    private int page = 1;

    public static final String TAG = "SelectedGameFragmentModle";

    @Override
    protected boolean checkData(SelectedGame selectedGame) {  //验证数据是否下载成功
        int errorno = selectedGame.getErrorno();
        int successful = Constants.ApiClient.SUCCESSFUL;
        return errorno == successful;
    }

    @Override
    public String getModelTag() {
        return TAG;
    }

    @Override
    public Type getTType() {
        Type type = new TypeToken<SelectedGame>() {
        }.getType();
        return type;
    }

    @Override
    public List<GameInfoBean> getAdGameList() {
//        Log.i("mData",mData+"");
        return mData.getAd_list();
    }

    @Override
    public IAdGamePresenter getAdGamePresenter() {
        IAdGamePresenter presenter = (IAdGamePresenter) getPresenter(SelectedGameFragmentPresenter.TAG);
        return presenter;
    }

    @Override
    public void setAdGamePresenter(IAdGamePresenter adGamePresenter) {
        ABasePresenter presenter = (ABasePresenter) adGamePresenter;
        addPresenter(presenter);
    }

    @Override
    public List<GameInfoBean> getSelectedGameList() {
        return mData.getSelected_list();
    }

    @Override
    public ISelectedGamePresenter getSelectedGamePresenter() {
        ISelectedGamePresenter presenter = (ISelectedGamePresenter) getPresenter(SelectedGameFragmentPresenter.TAG);
        return presenter;
    }

    @Override
    public void setSelectedGamePresenter(ISelectedGamePresenter selectedGamePresenter) {
        ABasePresenter presenter = (ABasePresenter) selectedGamePresenter;
        addPresenter(presenter);
    }

    @Override
    public void nextPageData(final ReplaceDataListener listener) {
        page ++;
        String url = "https://market.x7sy.com/game/index_selected";
        Map<String, String> map = new HashMap<>();
        map.put("page",String.valueOf(page));
        map.put("os_type","2");
        map.put("sign","2267c9070c5ab7d178b32d31eb2ec6b0");
        GsonUtil.DownLoadedJsonListener<SelectedGame> l = new GsonUtil.DownLoadedJsonListener<SelectedGame>() {
            @Override
            public void downLoaded(SelectedGame selectedGame) {
                listener.replacedData();  //TODO cuowu
            }
        };
        GsonUtil.downLoadJson(url,map,SelectedGame.class,l);
    }
}
