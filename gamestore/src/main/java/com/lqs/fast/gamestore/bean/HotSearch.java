package com.lqs.fast.gamestore.bean;

import java.util.List;

/**
 * Created by dell on 2016/10/11.
 */

public class HotSearch {

    /**
     * errorno : 0
     * errormsg :
     * hot_list : [{"game_logo":"http://res.x7sy.com/uploads/devloper_img/20160909/41498776222090366_thumb.png","game_name":"青云志","show_name":"青云志"},{"game_logo":"http://res.x7sy.com/uploads/devloper_img/20160926/47554436361656931.png","game_name":"我叫MT3-YW","show_name":"我叫MT3-YW"},{"game_logo":"http://res.x7sy.com/uploads/devloper_img/20160926/65529378609881419.png","game_name":"仙迹","show_name":"仙迹"},{"game_logo":"http://res.x7sy.com/uploads/devloper_img/20160918/53297219573993472_thumb.png","game_name":"少年西游记","show_name":"少年西游记"}]
     */

    private int errorno;
    private String errormsg;
    /**
     * game_logo : http://res.x7sy.com/uploads/devloper_img/20160909/41498776222090366_thumb.png
     * game_name : 青云志
     * show_name : 青云志
     */

    private List<GameInfoBean> hot_list;

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

    public List<GameInfoBean> getHot_list() {
        return hot_list;
    }

    public void setHot_list(List<GameInfoBean> hot_list) {
        this.hot_list = hot_list;
    }


}
