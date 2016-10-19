package com.lqs.fast.gamestore.bean;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

import java.util.List;

/**
 * Created by dell on 2016/10/19.
 */

@Table(name = "download_game")
public class SaveGameInfoBean extends Model{
    @Column
    private String guid;
    @Column
    private String game_logo;
    @Column
    private String game_name;
    @Column
    private String one_game_info;
    @Column
    private String package_name;
    @Column
    private String gamesize;
    @Column
    private String typename;
    @Column
    private String download_url;

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
}
