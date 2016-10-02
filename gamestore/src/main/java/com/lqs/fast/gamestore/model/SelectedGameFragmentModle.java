package com.lqs.fast.gamestore.model;

import com.lqs.fast.gamestore.app.Constants;
import com.lqs.fast.gamestore.bean.GameInfoBean;
import com.lqs.fast.gamestore.bean.SelectedGame;

import java.util.List;

/**
 * AAsynReplaceData 抽离出数据更新的方法
 * Created by dell on 2016/9/30.
 */

public class SelectedGameFragmentModle extends AAsynReplaceDataModel<SelectedGame> implements IAdGameModel,ISelectedGameModel{

//    private SelectedGame mSelectedGame;  //数据类
//    private ReplaceDataListener mListener;  //更新数据回调

    public SelectedGameFragmentModle(ReplaceDataListener listener)
    {
        super(listener);
//        this.mListener = listener;
    }

    @Override
    protected boolean checkData(SelectedGame selectedGame) {  //验证数据是否下载成功
        int errorno = selectedGame.getErrorno();
        int successful = Constants.ApiClient.SUCCESSFUL;
        return errorno == successful;
    }

    @Override
    public List<GameInfoBean> getAdGameList() {
        return this.mData.getAd_list();
    }

    @Override
    public List<GameInfoBean> getSelectedGameList() {
        return this.mData.getSelected_list();
    }

//    @Override
//    public ReplaceDataListener getReplaceDataListener() {
//        return this.mListener;
//    }
//
//    @Override
//    public void ReplaceData() {    //更新数据的方法
//        String urlStr = Constants.ApiClient.SELECTED_GAME;
//
//        GsonUtil.DownLoadedJsonListener<SelectedGame> listener = new GsonUtil.DownLoadedJsonListener<SelectedGame>() {
//            @Override
//            public void downLoaded(SelectedGame selectedGame) {
//                SelectedGameFragmentModle.this.mSelectedGame = selectedGame;
//                ReplaceDataListener replaceDataListener = getReplaceDataListener();
//                int successful = Constants.ApiClient.SUCCESSFUL;
//                if(mSelectedGame.getErrorno() == successful)  //验证是否下载数据成功
//                {
//                    replaceDataListener.replacedData();  // 成功则通知presenter处理成功分支
//                }else
//                {
//                    replaceDataListener.replaceDataError();  //失败分支
//                }
//            }
//        };
//        GsonUtil.downLoadJson(urlStr,SelectedGame.class,listener);
//    }

}
