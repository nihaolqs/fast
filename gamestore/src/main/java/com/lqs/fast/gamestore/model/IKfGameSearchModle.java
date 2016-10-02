package com.lqs.fast.gamestore.model;

import com.lqs.fast.gamestore.bean.GameInfoBean;

import java.util.List;

/**
 * Created by dell on 2016/9/30.
 */

public interface IKfGameSearchModle extends IAsynReplaceDataModel{
    List<GameInfoBean> getKfGameSearchList();
}
