package com.lqs.fast.gamestore.model;

import com.lqs.fast.gamestore.bean.GameInfoBean;

import java.util.List;

/**
 * Created by dell on 2016/9/29.
 */

public class SearchGame {

    /**
     * errorno : 0
     * errormsg :
     * selected_list : [{"guid":"321","game_logo":"http://res.x7sy.com/uploads/devloper_img/20160909/41498776222090366_thumb.png","game_name":"青云志","show_name":"青云志","gamesize":"651.72","typename":"动作游戏","one_game_info":"全民修真 唯爱青云","gamediscount":"5.0","download_url":"https://down.x7sy.com/game/android/115/321_1_1-0-2_20160913195053_7606.apk","package_name":"com.wanmei.qyz.android.ewan.x7sy","return_rate":"0","discount_type":"1"},{"guid":"354","game_logo":"http://res.x7sy.com/uploads/game_img/20160923/85263663763331839.png","game_name":"青丘狐传说-YW","show_name":"青丘狐传说","gamesize":"364.38","typename":"角色","one_game_info":"御剑飞行  甜蜜双飞","gamediscount":"5.0","download_url":"https://down.x7sy.com/game/android/115/354_1_1-3-0_20160923195249_1663.apk","package_name":"com.zlongame.qqh.ewan.x7sy","return_rate":"0","discount_type":"1"}]
     */

    private int errorno;
    private String errormsg;
    /**
     * guid : 321
     * game_logo : http://res.x7sy.com/uploads/devloper_img/20160909/41498776222090366_thumb.png
     * game_name : 青云志
     * show_name : 青云志
     * gamesize : 651.72
     * typename : 动作游戏
     * one_game_info : 全民修真 唯爱青云
     * gamediscount : 5.0
     * download_url : https://down.x7sy.com/game/android/115/321_1_1-0-2_20160913195053_7606.apk
     * package_name : com.wanmei.qyz.android.ewan.x7sy
     * return_rate : 0
     * discount_type : 1
     */

    private List<GameInfoBean> selected_list;

    public int getErrorno() {
        return errorno;
    }

    public void setErrorno(int errorno) {
        this.errorno = errorno;
    }

    public String getErrormsg() {
        return errormsg;
    }

    public void setErrormsg(String errormsg) {
        this.errormsg = errormsg;
    }

    public List<GameInfoBean> getSelected_list() {
        return selected_list;
    }

    public void setSelected_list(List<GameInfoBean> selected_list) {
        this.selected_list = selected_list;
    }
}
