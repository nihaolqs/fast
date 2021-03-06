package com.lqs.fast.gamestore.app;

import android.content.Context;
import android.os.Environment;

import com.android.volley.toolbox.StringRequest;

/**
 * Created by dell on 2016/9/30.
 */

public final class Constants {

//    public static final String SAVEPATH = Environment.getDownloadCacheDirectory().getAbsolutePath();
//    public static final String SAVEPATH = Environment.getExternalStorageDirectory().getAbsolutePath();

    public static final String FILEPROVIDER = "com.lqs.fast.gamestore.fileProvider";

    public static String getSavePath(Context context){
        return context.getFilesDir().getAbsolutePath();
    }

    public static class Type{
        public static final String SEARCH_KF = "search_kf";
        public static final String SEARCH_GAME = "search_game";
    }

    public static class Settings{
        public static final String SP_NAME ="gamestore_sp";
        public static final String SEND_MESSAGE ="send_message";
        public static final String AUTOMATIC_INSTALL ="automatic_install";
        public static final String DELETE_INSTALLPACKAGE ="delete_installpackage";
    }

    public static class ApiClient{
        //数据请求返回码
        public static final int SUCCESSFUL = 0;
        //首页精选列表
        public static final String SELECTED_GAME = "https://market.x7sy.com/game/index_selected?page=1&os_type=2&sign=2267c9070c5ab7d178b32d31eb2ec6b0";
        //查询返回列表
        public static final String SEARCH_GAME = "https://market.x7sy.com/game/split_search?page=1&os_type=2&searchkey=%E6%88%91%E5%8F%ABMT3-YW&sign=a3186399568133a56c565883e409b818";

        public static final String SEARCH_KF = "https://market.x7sy.com/game/gamekf_search?os_type=2&gname=%E4%BB%99&sign=b7e6aaa64d23ed02fc2df183bfcfe329";

        //开服列表
        public static final String KF_GAME ="https://market.x7sy.com/game/gamekf_day?day=1&os_type=2&sign=178db7c55d0354db5b179706b1ab7fda";

        public static final String KF_GAME_DAY2 ="https://market.x7sy.com/game/gamekf_day?day=2&os_type=2&sign=154c62d07017cea38aabb20bad2886a5";

        public static final String HOT_SEARCH = "https://market.x7sy.com/game/hot_search?stime=1476170233603&os_type=2&sign=7e92209760986866f1eb37bbc561709b";

        public static final String GAME_DETAIL = "https://market.x7sy.com/game/get_game_info?gid=321&sign=e556d2057cb2a1fdd39ab7f821f253a4";
    }
}
