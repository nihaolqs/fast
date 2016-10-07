package com.lqs.fast.fast.base.model;

/**
 * Created by dell on 2016/9/30.
 */

public interface IAsynReplaceDataModel {
//    ReplaceDataListener getReplaceDataListener();
    void ReplaceData(String url,ReplaceDataListener listener);  //TODO 订正应该传入网址
}
