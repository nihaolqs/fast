package com.lqs.fast.gamestore.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by lin on 2016/10/13.
 */

public class GameDetail implements Serializable {

    /**
     * errorno : 0
     * errormsg :
     * game_info : {"game_name":"青云志","show_name":"青云志","game_logo":"http://res.x7sy.com/uploads/devloper_img/20160909/41498776222090366_thumb.png","requirement":"Android 2.3.1","gamesize":"651.72","version":"1.0.2","os_type":"2","typename":"动作游戏","language":"1","online_time":"2016-09-14","game_info":"青云志》手游是电视剧《青云志》唯一正版同名手游，电视剧拍摄地实地取景，完美世界资深美术团队制作，首次引入Inferno 3D终极交互式高清视觉设计系统，打造超凡画质，完美复刻电视剧场景。音乐采用了《青云志》电视剧原声，为玩家带来360度的全3D全景沉浸式游戏体验！","download_url":"https://down.x7sy.com/game/android/115/321_1_1-0-2_20160913195053_7606.apk","atlas_img":["http://res.x7sy.com/uploads/game_img/20160909/36368727993562731790384_thumb.jpg","http://res.x7sy.com/uploads/game_img/20160909/47864599431912491890389_thumb.jpg","http://res.x7sy.com/uploads/game_img/20160909/46909345870090051990392_thumb.jpg","http://res.x7sy.com/uploads/game_img/20160909/15614221036932549690400_thumb.jpg","http://res.x7sy.com/uploads/game_img/20160909/54206898703679627790403_thumb.jpg"],"gamediscount":"5.0","return_rate":"0","discount_type":"1","package_name":"com.wanmei.qyz.android.ewan.x7sy","one_game_info":"全民修真 唯爱青云","game_online":1}
     */

    private int errorno;
    private String errormsg;
    /**
     * game_name : 青云志
     * show_name : 青云志
     * game_logo : http://res.x7sy.com/uploads/devloper_img/20160909/41498776222090366_thumb.png
     * requirement : Android 2.3.1
     * gamesize : 651.72
     * version : 1.0.2
     * os_type : 2
     * typename : 动作游戏
     * language : 1
     * online_time : 2016-09-14
     * game_info : 青云志》手游是电视剧《青云志》唯一正版同名手游，电视剧拍摄地实地取景，完美世界资深美术团队制作，首次引入Inferno 3D终极交互式高清视觉设计系统，打造超凡画质，完美复刻电视剧场景。音乐采用了《青云志》电视剧原声，为玩家带来360度的全3D全景沉浸式游戏体验！
     * download_url : https://down.x7sy.com/game/android/115/321_1_1-0-2_20160913195053_7606.apk
     * atlas_img : ["http://res.x7sy.com/uploads/game_img/20160909/36368727993562731790384_thumb.jpg","http://res.x7sy.com/uploads/game_img/20160909/47864599431912491890389_thumb.jpg","http://res.x7sy.com/uploads/game_img/20160909/46909345870090051990392_thumb.jpg","http://res.x7sy.com/uploads/game_img/20160909/15614221036932549690400_thumb.jpg","http://res.x7sy.com/uploads/game_img/20160909/54206898703679627790403_thumb.jpg"]
     * gamediscount : 5.0
     * return_rate : 0
     * discount_type : 1
     * package_name : com.wanmei.qyz.android.ewan.x7sy
     * one_game_info : 全民修真 唯爱青云
     * game_online : 1
     */

    private GameDeatilBean game_info;

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

    public GameDeatilBean getGame_info() {
        return game_info;
    }

    public void setGame_info(GameDeatilBean game_info) {
        this.game_info = game_info;
    }

    public static class GameDeatilBean {
        private String game_name;
        private String show_name;
        private String game_logo;
        private String requirement;
        private String gamesize;
        private String version;
        private String os_type;
        private String typename;
        private String language;
        private String online_time;
        private String game_info;
        private String download_url;
        private String gamediscount;
        private String return_rate;
        private String discount_type;
        private String package_name;
        private String one_game_info;
        private int game_online;
        private List<String> atlas_img;

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

        public String getGame_logo() {
            return game_logo;
        }

        public void setGame_logo(String game_logo) {
            this.game_logo = game_logo;
        }

        public String getRequirement() {
            return requirement;
        }

        public void setRequirement(String requirement) {
            this.requirement = requirement;
        }

        public String getGamesize() {
            return gamesize;
        }

        public void setGamesize(String gamesize) {
            this.gamesize = gamesize;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public String getOs_type() {
            return os_type;
        }

        public void setOs_type(String os_type) {
            this.os_type = os_type;
        }

        public String getTypename() {
            return typename;
        }

        public void setTypename(String typename) {
            this.typename = typename;
        }

        public String getLanguage() {
            return language;
        }

        public void setLanguage(String language) {
            this.language = language;
        }

        public String getOnline_time() {
            return online_time;
        }

        public void setOnline_time(String online_time) {
            this.online_time = online_time;
        }

        public String getGame_info() {
            return game_info;
        }

        public void setGame_info(String game_info) {
            this.game_info = game_info;
        }

        public String getDownload_url() {
            return download_url;
        }

        public void setDownload_url(String download_url) {
            this.download_url = download_url;
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

        public String getPackage_name() {
            return package_name;
        }

        public void setPackage_name(String package_name) {
            this.package_name = package_name;
        }

        public String getOne_game_info() {
            return one_game_info;
        }

        public void setOne_game_info(String one_game_info) {
            this.one_game_info = one_game_info;
        }

        public int getGame_online() {
            return game_online;
        }

        public void setGame_online(int game_online) {
            this.game_online = game_online;
        }

        public List<String> getAtlas_img() {
            return atlas_img;
        }

        public void setAtlas_img(List<String> atlas_img) {
            this.atlas_img = atlas_img;
        }
    }
}
