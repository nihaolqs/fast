package com.lqs.fast.gamestore.bean;

import java.util.List;

/**
 * Created by dell on 2016/10/12.
 */

public interface ISearch {
    int getErrorno();
    String getErrormsg();
    List<GameInfoBean> getSearched();
}
