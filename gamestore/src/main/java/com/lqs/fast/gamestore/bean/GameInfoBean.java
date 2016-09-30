package com.lqs.fast.gamestore.bean;

import java.util.List;

/**
 * Created by dell on 2016/9/29.
 */

public class GameInfoBean {

    /**
     * guid : 391
     * game_logo : http://res.x7sy.com/uploads/devloper_img/20160926/61943721228887443.png
     * game_name : 御天下
     * show_name : 御天下
     * gamesize : 212.42
     * typename : 策略
     * one_game_info : 您创造出一个三国征战与神话力量共存的神奇大陆
     * package_name : com.ytx.sf.kuaifa.x7sy
     * gamediscount : 4.8
     * return_rate : 0
     * discount_type : 1
     * download_url : https://down.x7sy.com/game/android/74/391_1_1-6_20160926190329_7369.apk
     */

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
