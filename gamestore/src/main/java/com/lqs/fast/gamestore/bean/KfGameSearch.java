package com.lqs.fast.gamestore.bean;

import com.lqs.fast.gamestore.bean.GameInfoBean;

import java.util.List;

/**
 * Created by dell on 2016/9/30.
 */

public class KfGameSearch implements ISearch{

    /**
     * errorno : 0
     * errormsg :
     * kf_list : [{"guid":"389","game_logo":"http://res.x7sy.com/uploads/devloper_img/20160923/32217316233628023.png","game_name":"西游之紫霞仙子","show_name":"西游之紫霞仙子","one_game_info":"紫霞下凡妖猴复活，人间大战一触即发","package_name":"com.zxxz.aowan.x7sy","gamediscount":"4.8","return_rate":"0","discount_type":"1","gamesize":"76.27","typename":"角色","download_url":"https://down.x7sy.com/game/android/78/389_1_1-3-0_20160923185217_5977.apk","time_list":["16/09/28 10:00","16/10/01 10:00","16/10/06 10:00","16/10/13 10:00"]},{"guid":"338","game_logo":"http://res.x7sy.com/uploads/devloper_img/20160926/65529378609881419.png","game_name":"仙迹","show_name":"仙迹（2016仙侠巨作）","one_game_info":"全民修仙，挂机PK手游！","package_name":"com.yqwmg.xianji.x7sy","gamediscount":"4.5","return_rate":"0","discount_type":"1","gamesize":"93.91","typename":"角色","download_url":"https://down.x7sy.com/game/android/131/338_1_1-1-0_20160919184146_2789.apk","time_list":["16/09/30 10:00","16/10/01 10:00","16/10/03 10:00","16/10/05 10:00","16/10/07 10:00","16/10/10 10:00","16/10/13 10:00","16/10/16 10:00","16/10/19 10:00","16/10/22 10:00","16/10/25 10:00","16/10/28 10:00","16/10/31 10:00"]},{"guid":"308","game_logo":"http://res.x7sy.com/uploads/devloper_img/20160926/34832182818072998.png","game_name":"诛仙战纪","show_name":"诛仙战纪","one_game_info":"背负三尺锋,腰悬锁妖壶,斩魔修道心,九天凭御风","package_name":"com.yzcoo.tnts.x7sy","gamediscount":"4.6","return_rate":"0","discount_type":"1","gamesize":"115.41","typename":"角色","download_url":"https://down.x7sy.com/game/android/98/308_1_1-03-02_20160929171122_2906.apk","time_list":["16/09/30 14:00","16/10/01 14:00","16/10/02 14:00","16/10/04 14:00","16/10/07 14:00","16/10/11 14:00","16/10/15 14:00"]}]
     */

    private int errorno;
    private String errormsg;
    /**
     * guid : 389
     * game_logo : http://res.x7sy.com/uploads/devloper_img/20160923/32217316233628023.png
     * game_name : 西游之紫霞仙子
     * show_name : 西游之紫霞仙子
     * one_game_info : 紫霞下凡妖猴复活，人间大战一触即发
     * package_name : com.zxxz.aowan.x7sy
     * gamediscount : 4.8
     * return_rate : 0
     * discount_type : 1
     * gamesize : 76.27
     * typename : 角色
     * download_url : https://down.x7sy.com/game/android/78/389_1_1-3-0_20160923185217_5977.apk
     * time_list : ["16/09/28 10:00","16/10/01 10:00","16/10/06 10:00","16/10/13 10:00"]
     */

    private List<GameInfoBean> kf_list;

    public int getErrorno() {
        return errorno;
    }

    public void setErrorno(int errorno) {
        this.errorno = errorno;
    }

    public String getErrormsg() {
        return errormsg;
    }

    @Override
    public List<GameInfoBean> getSearched() {
        return kf_list;
    }

    public void setErrormsg(String errormsg) {
        this.errormsg = errormsg;
    }

    public List<GameInfoBean> getKf_list() {
        return kf_list;
    }

    public void setKf_list(List<GameInfoBean> kf_list) {
        this.kf_list = kf_list;
    }


}
