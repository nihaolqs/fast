package com.lqs.fast.gamestore.bean;

import com.lqs.fast.gamestore.bean.GameInfoBean;

import java.util.List;

/**
 * Created by dell on 2016/9/29.
 */

public class SelectedGame {

    /**
     * errorno : 0
     * errormsg :
     * selected_list : [{"guid":"391","game_logo":"http://res.x7sy.com/uploads/devloper_img/20160926/61943721228887443.png","game_name":"御天下","show_name":"御天下","gamesize":"212.42","typename":"策略","one_game_info":"您创造出一个三国征战与神话力量共存的神奇大陆","package_name":"com.ytx.sf.kuaifa.x7sy","gamediscount":"4.8","return_rate":"0","discount_type":"1","download_url":"https://down.x7sy.com/game/android/74/391_1_1-6_20160926190329_7369.apk"},{"guid":"384","game_logo":"http://res.x7sy.com/uploads/devloper_img/20160927/62807167993175443.png","game_name":"无限战争","show_name":"无限战争","gamesize":"347.39","typename":"动作","one_game_info":"网易首款即时战略RPG手游","package_name":"com.netease.kittycraft.kuaifa.x7sy","gamediscount":"5.0","return_rate":"0","discount_type":"1","download_url":"https://down.x7sy.com/game/android/74/384_1_1-0-10_20160926192453_5034.apk"},{"guid":"353","game_logo":"http://res.x7sy.com/uploads/devloper_img/20160927/51217691890372238.png","game_name":"COK列王的纷争-YW","show_name":"COK列王的纷争","gamesize":"86.20","typename":"策略","one_game_info":"全球同服 战略为王","package_name":"com.hcg.cok.ewan.x7sy","gamediscount":"5.0","return_rate":"0","discount_type":"1","download_url":"https://down.x7sy.com/game/android/115/353_1_2-13-1_20160927183113_2365.apk"},{"guid":"409","game_logo":"http://res.x7sy.com/uploads/devloper_img/20160928/73066497994294673.png","game_name":"暴风战舰","show_name":"暴风战舰","gamesize":"210.94","typename":"策略","one_game_info":"史上首款3D历史策略海战题材(航海王强者之路2）","package_name":"com.chyo.fleet.yl.x7sy","gamediscount":"5.0","return_rate":"0","discount_type":"1","download_url":"https://down.x7sy.com/game/android/74/409_1_1-5-0_20160928005304_3539.apk"},{"guid":"416","game_logo":"http://res.x7sy.com/uploads/devloper_img/20160929/31023773172016063.png","game_name":"天下","show_name":"天下","gamesize":"98.43","typename":"角色","one_game_info":"网易顶级品质旗舰，真3D极致画面，无缝大世界！ 这一切，手机上从未实现过！这天下，你从未见过！","package_name":"com.sj49you.tx.x7sy","gamediscount":"10","return_rate":"0","discount_type":"1","download_url":"https://down.x7sy.com/game/android/92/416_1_1-0-0_20160929110457_4223.apk"},{"guid":"408","game_logo":"http://res.x7sy.com/uploads/game_img/20160928/23035825121551048.png","game_name":"天龙八部3D","show_name":"天龙八部","gamesize":"212.17","typename":"角色","one_game_info":"《天龙八部3D》被誉为国民第一武侠网游","package_name":"com.cyou.cx.mtlbb.x7sy","gamediscount":"5.0","return_rate":"0","discount_type":"1","download_url":"https://down.x7sy.com/game/android/74/408_1_1-305-0-0_20160927172344_8267.apk"},{"guid":"410","game_logo":"http://res.x7sy.com/uploads/devloper_img/20160927/21305060779783786.png","game_name":"皇室战争","show_name":"皇室战争","gamesize":"96.23","typename":"策略","one_game_info":"集合MOBA、塔防、集换式卡牌等多种元素的策略卡牌游戏","package_name":"com.supercell.clashroyale.qihoo.x7sy","gamediscount":"7.5","return_rate":"0","discount_type":"1","download_url":"https://down.x7sy.com/game/android/74/410_1_1-5-0_20160927184157_6901.apk"},{"guid":"296","game_logo":"http://res.x7sy.com/uploads/devloper_img/20160921/22775137156929924_thumb.png","game_name":"三国归来","show_name":"三国归来","gamesize":"122.99","typename":"策略","one_game_info":"三国归来（首充送武神赵子龙）","package_name":"com.sj49you.sggl.x7sy","gamediscount":"5.0","return_rate":"0","discount_type":"1","download_url":"https://down.x7sy.com/game/android/92/296_1_0-1-30_20160921120210_8663.apk"},{"guid":"321","game_logo":"http://res.x7sy.com/uploads/devloper_img/20160909/41498776222090366_thumb.png","game_name":"青云志","show_name":"青云志","gamesize":"651.72","typename":"动作游戏","one_game_info":"全民修真 唯爱青云","package_name":"com.wanmei.qyz.android.ewan.x7sy","gamediscount":"5.0","return_rate":"0","discount_type":"1","download_url":"https://down.x7sy.com/game/android/115/321_1_1-0-2_20160913195053_7606.apk"},{"guid":"361","game_logo":"http://res.x7sy.com/uploads/devloper_img/20160922/98945849060335500.png","game_name":"航海王强者之路-YW","show_name":"航海王强者之路-YW","gamesize":"213.63","typename":"角色","one_game_info":"梦想起航 王者之路","package_name":"com.shanghailvbing.hhw.ewan.x7sy","gamediscount":"5.0","return_rate":"0","discount_type":"1","download_url":"https://down.x7sy.com/game/android/115/361_1_1-3-6_20160922171235_3992.apk"},{"guid":"379","game_logo":"http://res.x7sy.com/uploads/devloper_img/20160923/34822294935802927.png","game_name":"如果的世界","show_name":"如果的世界","gamesize":"164.24","typename":"角色","one_game_info":"《如果の世界》是一款纯正日漫风回合制MMORPG手游","package_name":"com.ledo.areal.kf.x7sy","gamediscount":"5.0","return_rate":"0","discount_type":"1","download_url":"https://down.x7sy.com/game/android/74/379_1_1-0-0_20160923115749_6754.apk"},{"guid":"364","game_logo":"http://res.x7sy.com/uploads/devloper_img/20160926/47554436361656931.png","game_name":"我叫MT3-YW","show_name":"我叫MT3-YW","gamesize":"400.16","typename":"角色","one_game_info":"魔幻经典回合制手游","package_name":"com.locojoy.wojmt3.ewan.x7sy","gamediscount":"5.0","return_rate":"0","discount_type":"1","download_url":"https://down.x7sy.com/game/android/115/364_1_1-4-1_20160926103520_1570.apk"},{"guid":"403","game_logo":"http://res.x7sy.com/uploads/devloper_img/20160927/89037895966852200.png","game_name":"武神列传","show_name":"武神列传","gamesize":"105.60","typename":"策略","one_game_info":"回合制模拟策略Q版手机游戏","package_name":"com.wslz.aowan.x7sy","gamediscount":"4.6","return_rate":"0","discount_type":"1","download_url":"https://down.x7sy.com/game/android/78/403_1_1-0_20160927125909_7542.apk"},{"guid":"306","game_logo":"http://res.x7sy.com/uploads/devloper_img/20160924/36067050789203153.png","game_name":"秀丽江山","show_name":"秀丽江山","gamesize":"121.69","typename":"角色扮演","one_game_info":"年度纸艺画风角色扮演动作","package_name":"com.jiqu.xljs.x7sy","gamediscount":"5.0","return_rate":"0","discount_type":"1","download_url":"https://down.x7sy.com/game/android/54/306_1_1-05-00_20160924155024_5006.apk"},{"guid":"337","game_logo":"http://res.x7sy.com/uploads/devloper_img/20160918/53297219573993472_thumb.png","game_name":"少年西游记","show_name":"少年西游记","gamesize":"81.09","typename":"卡牌","one_game_info":"4亿玩家共同期待的卡牌手游","package_name":"com.sj49you.snxyj.x7sy","gamediscount":"5.0","return_rate":"0","discount_type":"1","download_url":"https://down.x7sy.com/game/android/92/337_1_1-0-6_20160918180753_7887.apk"},{"guid":"232","game_logo":"http://res.x7sy.com/uploads/devloper_img/20160923/46645339212631930.png","game_name":"城市精灵go","show_name":"城市精灵GO","gamesize":"155.09","typename":"角色","one_game_info":"基于地理位置的交互手游","package_name":"com.tanyu.csjl.x7sy","gamediscount":"4.5","return_rate":"0","discount_type":"1","download_url":"https://down.x7sy.com/game/android/171/232_1_2-5-1_20160923193958_2459.apk"},{"guid":"248","game_logo":"http://res.x7sy.com/uploads/devloper_img/20160921/87800310571428481_thumb.png","game_name":"口袋妖怪3DS","show_name":"口袋妖怪3DS","gamesize":"221.58","typename":"角色扮演","one_game_info":"3D口袋妖怪神作，来玩就送梦幻","package_name":"com.jbgames.htgame.x7sy","gamediscount":"4.6","return_rate":"0","discount_type":"1","download_url":"https://down.x7sy.com/game/android/61/248_1_0-9-0_20160922192830_5299.apk"},{"guid":"233","game_logo":"http://res.x7sy.com/uploads/devloper_img/20160826/21481899768441511_thumb.png","game_name":"铁血沙城","show_name":"铁血沙城-跨服来袭","gamesize":"144.74","typename":"角色","one_game_info":"万人同屏，跨服来袭，再创英雄传奇","package_name":"com.topdogame.chuangqi.x7sy","gamediscount":"4.6","return_rate":"0","discount_type":"1","download_url":"https://down.x7sy.com/game/android/71/233_1_1-4-1_20160927151812_1653.apk"},{"guid":"360","game_logo":"http://res.x7sy.com/uploads/devloper_img/20160928/24622199209557940.png","game_name":"自由之战-YW","show_name":"自由之战","gamesize":"372.71","typename":"角色","one_game_info":"自由之战","package_name":"com.dw.fs.ewan.x7sy","gamediscount":"5.0","return_rate":"0","discount_type":"1","download_url":"https://down.x7sy.com/game/android/115/360_1_2-0-8-0_20160928181918_5577.apk"},{"guid":"182","game_logo":"http://res.x7sy.com/uploads/devloper_img/20160815/93126896421840475_thumb.png","game_name":"口袋妖怪重制","show_name":"口袋妖怪重制","gamesize":"164.53","typename":"卡牌","one_game_info":"口袋妖怪20周年纪念大作，最经典IP重制巨献！","package_name":"com.shouyou.kdygcz.x7sy","gamediscount":"4.2","return_rate":"0","discount_type":"1","download_url":"https://down.x7sy.com/game/android/91/182_1_1-1-1_20160923182119_7966.apk"}]
     * ad_list : [{"ad_name":"天龙八部3D","game_id":"408","ad_img":"http://res.x7sy.com/uploads/20160929/26822396455911491.jpg","ad_url":"","game_name":"天龙八部3D","package_name":"com.cyou.cx.mtlbb.x7sy","gamesize":"212.17","one_game_info":"《天龙八部3D》被誉为国民第一武侠网游"},{"ad_name":"神威三国志","game_id":"385","ad_img":"http://res.x7sy.com/uploads/20160929/80827958169134359.jpg","ad_url":"","game_name":"神威三国志","package_name":"com.yzcoo.swsgz.x7sy","gamesize":"91.50","one_game_info":"一款三国题材的策略卡牌类游戏"},{"ad_name":"探墓风云","game_id":"373","ad_img":"http://res.x7sy.com/uploads/20160923/73258828768703297.jpg","ad_url":"","game_name":"探墓风云","package_name":"com.sj49you.tmfy.x7sy","gamesize":"257.23","one_game_info":"大型3DMMO地宫探险国战手游"},{"ad_name":"妖萌战姬","game_id":"397","ad_img":"http://res.x7sy.com/uploads/20160929/56375281285711326.jpg","ad_url":"","game_name":"妖萌战姬","package_name":"com.zytx.ymzj.mox.x7sy","gamesize":"137.83","one_game_info":"无论你是收集狂人还是谋略专家，你都可以在《契约次元少女》世界中找到属于自己的乐趣！"}]
     */

    private int errorno;
    private String errormsg;
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

    private List<GameInfoBean> selected_list;
    /**
     * ad_name : 天龙八部3D
     * game_id : 408
     * ad_img : http://res.x7sy.com/uploads/20160929/26822396455911491.jpg
     * ad_url :
     * game_name : 天龙八部3D
     * package_name : com.cyou.cx.mtlbb.x7sy
     * gamesize : 212.17
     * one_game_info : 《天龙八部3D》被誉为国民第一武侠网游
     */

    private List<GameInfoBean> ad_list;

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

    public List<GameInfoBean> getAd_list() {
        return ad_list;
    }

    public void setAd_list(List<GameInfoBean> ad_list) {
        this.ad_list = ad_list;
    }




}
