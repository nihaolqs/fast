package com.lqs.fast.myapplication;

import java.util.List;

/**
 * Created by dell on 2016/9/30.
 */

public class kfgamen {

    /**
     * errorno : 0
     * errormsg :
     * kf_list : [{"guid":"338","game_logo":"http://res.x7sy.com/uploads/devloper_img/20160926/65529378609881419.png","game_name":"仙迹","show_name":"仙迹（2016仙侠巨作）","one_game_info":"全民修仙，挂机PK手游！","package_name":"com.yqwmg.xianji.x7sy","gamediscount":"4.5","return_rate":"0","discount_type":"1","gamesize":"93.91","typename":"角色","download_url":"https://down.x7sy.com/game/android/131/338_1_1-1-0_20160919184146_2789.apk","time_list":["16/09/30 10:00","16/10/01 10:00","16/10/03 10:00","16/10/05 10:00","16/10/07 10:00","16/10/10 10:00","16/10/13 10:00","16/10/16 10:00","16/10/19 10:00","16/10/22 10:00","16/10/25 10:00","16/10/28 10:00","16/10/31 10:00"]}]
     */

    private int errorno;
    private String errormsg;
    /**
     * guid : 338
     * game_logo : http://res.x7sy.com/uploads/devloper_img/20160926/65529378609881419.png
     * game_name : 仙迹
     * show_name : 仙迹（2016仙侠巨作）
     * one_game_info : 全民修仙，挂机PK手游！
     * package_name : com.yqwmg.xianji.x7sy
     * gamediscount : 4.5
     * return_rate : 0
     * discount_type : 1
     * gamesize : 93.91
     * typename : 角色
     * download_url : https://down.x7sy.com/game/android/131/338_1_1-1-0_20160919184146_2789.apk
     * time_list : ["16/09/30 10:00","16/10/01 10:00","16/10/03 10:00","16/10/05 10:00","16/10/07 10:00","16/10/10 10:00","16/10/13 10:00","16/10/16 10:00","16/10/19 10:00","16/10/22 10:00","16/10/25 10:00","16/10/28 10:00","16/10/31 10:00"]
     */

    private List<KfListBean> kf_list;

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

    public List<KfListBean> getKf_list() {
        return kf_list;
    }

    public void setKf_list(List<KfListBean> kf_list) {
        this.kf_list = kf_list;
    }

    public static class KfListBean {
        private String guid;
        private String game_logo;
        private String game_name;
        private String show_name;
        private String one_game_info;
        private String package_name;
        private String gamediscount;
        private String return_rate;
        private String discount_type;
        private String gamesize;
        private String typename;
        private String download_url;
        private List<String> time_list;

        public String getGuid() {
            return guid;
        }

        public void setGuid(String guid) {
            this.guid = guid;
        }

        public String getGame_logo() {
            return game_logo;
        }

        public void setGame_logo(String game_logo) {
            this.game_logo = game_logo;
        }

        public String getGame_name() {
            return game_name;
        }

        public void setGame_name(String game_name) {
            this.game_name = game_name;
        }

        public String getShow_name() {
            return show_name;
        }

        public void setShow_name(String show_name) {
            this.show_name = show_name;
        }

        public String getOne_game_info() {
            return one_game_info;
        }

        public void setOne_game_info(String one_game_info) {
            this.one_game_info = one_game_info;
        }

        public String getPackage_name() {
            return package_name;
        }

        public void setPackage_name(String package_name) {
            this.package_name = package_name;
        }

        public String getGamediscount() {
            return gamediscount;
        }

        public void setGamediscount(String gamediscount) {
            this.gamediscount = gamediscount;
        }

        public String getReturn_rate() {
            return return_rate;
        }

        public void setReturn_rate(String return_rate) {
            this.return_rate = return_rate;
        }

        public String getDiscount_type() {
            return discount_type;
        }

        public void setDiscount_type(String discount_type) {
            this.discount_type = discount_type;
        }

        public String getGamesize() {
            return gamesize;
        }

        public void setGamesize(String gamesize) {
            this.gamesize = gamesize;
        }

        public String getTypename() {
            return typename;
        }

        public void setTypename(String typename) {
            this.typename = typename;
        }

        public String getDownload_url() {
            return download_url;
        }

        public void setDownload_url(String download_url) {
            this.download_url = download_url;
        }

        public List<String> getTime_list() {
            return time_list;
        }

        public void setTime_list(List<String> time_list) {
            this.time_list = time_list;
        }
    }
}
