package com.lqs.fast.gamestore.model;

/**
 * Created by dell on 2016/9/30.
 */

public interface IAsynReplaceDataModel {
    ReplaceDataListener getReplaceDataListener();
    void ReplaceData(String url);  //TODO 订正应该传入网址
}
