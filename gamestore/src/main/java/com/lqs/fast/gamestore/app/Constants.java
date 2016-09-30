package com.lqs.fast.gamestore.app;

import com.android.volley.toolbox.StringRequest;

/**
 * Created by dell on 2016/9/30.
 */

public final class Constants {
    public static class ApiClient{
        //数据请求返回码
        public static final int SUCCESSFUL = 0;
        //首页精选列表
        public static final String SELECTED_GAME = "https://market.x7sy.com/game/index_selected?page=1&os_type=2&sign=2267c9070c5ab7d178b32d31eb2ec6b0";
        //查询返回列表
        public static final String SEARCH_GAME = "https://market.x7sy.com/game/split_search?page=1&os_type=2&searchkey=%E6%88%91%E5%8F%ABMT3-YW&sign=a3186399568133a56c565883e409b818";
        //开服列表
        public static final String KF_GAME ="https://market.x7sy.com/game/gamekf_day?day=1&os_type=2&sign=178db7c55d0354db5b179706b1ab7fda";
    }
}
