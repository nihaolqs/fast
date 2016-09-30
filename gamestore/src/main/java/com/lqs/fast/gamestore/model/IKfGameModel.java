package com.lqs.fast.gamestore.model;

import com.lqs.fast.gamestore.bean.KfGame;

import java.util.List;

/**
 * Created by dell on 2016/9/29.
 */

public interface IKfGameModel extends IAsynReplaceData{
    List<KfGame.KfListBean> getKfGameList();
}
