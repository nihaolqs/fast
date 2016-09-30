package com.lqs.fast.gamestore.bean;

import com.lqs.fast.gamestore.bean.GameInfoBean;

import java.util.List;

/**
 * Created by dell on 2016/9/29.
 */

public class KfGame {

    /**
     * errorno : 0
     * errormsg :
     * kf_list : [{"section_name":"08:00","section_list":[{"guid":"297","game_logo":"http://res.x7sy.com/uploads/devloper_img/20160830/72794628637248137_thumb.png","game_name":"挂机吧主公","show_name":"挂机吧主公","package_name":"com.shenxiuinfo.sg.x7sy","gamesize":"57.09","gamediscount":"4.5","return_rate":"0","discount_type":"1","one_game_info":"全球第一放置手游"}]},{"section_name":"10:00","section_list":[{"guid":"315","game_logo":"http://res.x7sy.com/uploads/devloper_img/20160920/88607647078368733_thumb.png","game_name":"世界英雄","show_name":"世界英雄","package_name":"com.acchappy.worldhero.xiaoqi.x7sy","gamesize":"131.62","gamediscount":"4.8","return_rate":"0","discount_type":"1","one_game_info":"打造属于你的英雄战队"},{"guid":"403","game_logo":"http://res.x7sy.com/uploads/devloper_img/20160927/89037895966852200.png","game_name":"武神列传","show_name":"武神列传","package_name":"com.wslz.aowan.x7sy","gamesize":"105.60","gamediscount":"4.6","return_rate":"0","discount_type":"1","one_game_info":"回合制模拟策略Q版手机游戏"},{"guid":"254","game_logo":"http://res.x7sy.com/uploads/devloper_img/20160829/63229753894840801_thumb.png","game_name":"热血战神","show_name":"热血战神-送屠龙","package_name":"com.rxzs.aowan.x7sy","gamesize":"156.16","gamediscount":"5.0","return_rate":"0","discount_type":"1","one_game_info":"狼烟起，西风烈，ARPG经典热血传奇手游！"},{"guid":"183","game_logo":"http://res.x7sy.com/uploads/devloper_img/20160815/93586383464243034_thumb.png","game_name":"天天爆三国","show_name":"天天爆三国","package_name":"com.ttbsg.xiaoqi.x7sy","gamesize":"76.66","gamediscount":"4.5","return_rate":"0","discount_type":"1","one_game_info":"挂机手游海量三国人物，横扫千军荡平三国"},{"guid":"235","game_logo":"http://res.x7sy.com/uploads/devloper_img/20160905/26774733218647078_thumb.png","game_name":"帝霸","show_name":"帝霸","package_name":"com.platform2y9y.shenhai.diba.x7sy","gamesize":"96.13","gamediscount":"4.6","return_rate":"0","discount_type":"1","one_game_info":"小乔与您在三国一起成就帝王霸业！"},{"guid":"187","game_logo":"http://res.x7sy.com/uploads/devloper_img/20160815/68431950490440854_thumb.png","game_name":"烈火一刀","show_name":"烈火一刀-经典重现","package_name":"com.szym.lhyd.chs.x7sy","gamesize":"144.21","gamediscount":"5.0","return_rate":"0","discount_type":"1","one_game_info":"《烈火一刀》颠覆传统RPG，成就PK王者"},{"guid":"185","game_logo":"http://res.x7sy.com/uploads/devloper_img/20160815/30115146688029255_thumb.png","game_name":"作妖计","show_name":"作妖计-污力滔滔","package_name":"com.mykj.zyj.x7sy","gamesize":"117.66","gamediscount":"5.0","return_rate":"0","discount_type":"1","one_game_info":"暑期最热策略卡牌，架空三国棒打西游"},{"guid":"182","game_logo":"http://res.x7sy.com/uploads/devloper_img/20160815/93126896421840475_thumb.png","game_name":"口袋妖怪重制","show_name":"口袋妖怪重制","package_name":"com.shouyou.kdygcz.x7sy","gamesize":"164.53","gamediscount":"4.2","return_rate":"0","discount_type":"1","one_game_info":"口袋妖怪20周年纪念大作，最经典IP重制巨献！"},{"guid":"284","game_logo":"http://res.x7sy.com/uploads/devloper_img/20160927/83580299282672749.png","game_name":"数码宝贝大冒险","show_name":"数码宝贝大冒险-数码暴龙","package_name":"com.youmi.shuma.x7sy","gamesize":"165.32","gamediscount":"5.0","return_rate":"0","discount_type":"1","one_game_info":"冒险吧，成为驯兽师之王的男人！"},{"guid":"127","game_logo":"http://res.x7sy.com/uploads/devloper_img/20160815/67430827417342425_thumb.png","game_name":"死神觉醒","show_name":"死神觉醒-千年最强","package_name":"com.xhhd.bleach.kyx.x7sy","gamesize":"465.92","gamediscount":"5.0","return_rate":"0","discount_type":"1","one_game_info":"热血格斗手游《死神觉醒》改编自超人气动漫《死神BLEACH》"},{"guid":"217","game_logo":"http://res.x7sy.com/uploads/devloper_img/20160811/98653626664408578_thumb.png","game_name":"王者SF","show_name":"王者SF","package_name":"com.quhai.wzsf.chs.x7sy","gamesize":"143.64","gamediscount":"4.3","return_rate":"0","discount_type":"1","one_game_info":"一款支持多人同屏PK的角色扮演类游戏"},{"guid":"233","game_logo":"http://res.x7sy.com/uploads/devloper_img/20160826/21481899768441511_thumb.png","game_name":"铁血沙城","show_name":"铁血沙城-跨服来袭","package_name":"com.topdogame.chuangqi.x7sy","gamesize":"144.74","gamediscount":"4.6","return_rate":"0","discount_type":"1","one_game_info":"万人同屏，跨服来袭，再创英雄传奇"},{"guid":"230","game_logo":"http://res.x7sy.com/uploads/devloper_img/20160831/36931540921035106_thumb.png","game_name":"三剑豪2","show_name":"三剑豪2","package_name":"com.windplay.sanjianhao2.x7sy","gamesize":"311.25","gamediscount":"4.6","return_rate":"0","discount_type":"1","one_game_info":"浪漫江湖，御剑问情（送极品装备）林心如代言"},{"guid":"303","game_logo":"http://res.x7sy.com/uploads/devloper_img/20160831/95237339813239166_thumb.png","game_name":"御剑情缘","show_name":"御剑情缘","package_name":"com.shouyou.yjqy.x7sy","gamesize":"281.54","gamediscount":"5.0","return_rate":"0","discount_type":"1","one_game_info":"御剑情缘-仙剑云之凡全明星出演 首款3D双飞御剑手游"},{"guid":"300","game_logo":"http://res.x7sy.com/uploads/devloper_img/20160831/92616853186337742_thumb.png","game_name":"三国群英传","show_name":"三国群英传","package_name":"com.kx.sgqyz.yueeyou.x7sy","gamesize":"188.46","gamediscount":"5.0","return_rate":"0","discount_type":"1","one_game_info":"佩剑提枪，上马来战！"},{"guid":"283","game_logo":"http://res.x7sy.com/uploads/devloper_img/20160831/47379167137432868_thumb.png","game_name":"魔法门挂机","show_name":"魔法门挂机-英雄无敌","package_name":"com.legu.hommapk.x7sy","gamesize":"57.59","gamediscount":"4.6","return_rate":"0","discount_type":"1","one_game_info":"英雄无敌手游版，第三代挂机系统，轻松不累福利多！今日新服开启，7天狂欢神装神将送不停！"}]},{"section_name":"11:00","section_list":[{"guid":"330","game_logo":"http://res.x7sy.com/uploads/devloper_img/20160921/78567170097869465.png","game_name":"灵武九天","show_name":"灵武九天","package_name":"com.cy.lwjt.x7sy","gamesize":"110.66","gamediscount":"4.6","return_rate":"0","discount_type":"1","one_game_info":"《灵武九天》是一款万人跨服竞技，热血PK手游。"},{"guid":"269","game_logo":"http://res.x7sy.com/uploads/devloper_img/20160826/31335568923604749_thumb.png","game_name":"蜀山天下","show_name":"蜀山天下","package_name":"com.youai.sstx.x7sy","gamesize":"63.17","gamediscount":"10","return_rate":"0","discount_type":"1","one_game_info":"十年一觉仙侠梦，今日御剑上蜀山！"},{"guid":"351","game_logo":"http://res.x7sy.com/uploads/devloper_img/20160923/72433713094198984.png","game_name":"新世纪福音战士OL","show_name":"新世纪福音战士OL","package_name":"com.heitao.eva.x7sy","gamesize":"232.07","gamediscount":"4.8","return_rate":"0","discount_type":"1","one_game_info":"新世纪福音战士OL-日漫神作EVA"},{"guid":"265","game_logo":"http://res.x7sy.com/uploads/devloper_img/20160824/78395431736520841_thumb.png","game_name":"烈火之刃","show_name":"烈火之刃","package_name":"com.lhzr.xc.x7sy","gamesize":"107.67","gamediscount":"10","return_rate":"54","discount_type":"2","one_game_info":"烈火之刃超人气ARPG传奇手游，经典热血传奇PK!"},{"guid":"369","game_logo":"http://res.x7sy.com/uploads/devloper_img/20160921/22074415508839909.png","game_name":"我欲封天之至尊归来","show_name":"我欲封天之至尊归来","package_name":"com.cm.wyftzz.x7sy","gamesize":"162.62","gamediscount":"4.8","return_rate":"0","discount_type":"1","one_game_info":"至尊卡牌 极致爽快体验 无限送钻石"},{"guid":"321","game_logo":"http://res.x7sy.com/uploads/devloper_img/20160909/41498776222090366_thumb.png","game_name":"青云志","show_name":"青云志","package_name":"com.wanmei.qyz.android.ewan.x7sy","gamesize":"651.72","gamediscount":"5.0","return_rate":"0","discount_type":"1","one_game_info":"全民修真 唯爱青云"},{"guid":"172","game_logo":"http://res.x7sy.com/uploads/devloper_img/20160814/57438762954655013_thumb.png","game_name":"葫芦娃","show_name":"葫芦娃","package_name":"com.sj49you.hlwh.x7sy","gamesize":"96.43","gamediscount":"4.8","return_rate":"0","discount_type":"1","one_game_info":"再现最真实的童年记忆, 唤醒你内心深处的童年梦"},{"guid":"212","game_logo":"http://res.x7sy.com/uploads/devloper_img/20160826/44348637294741027_thumb.png","game_name":"热血至尊","show_name":"热血至尊－经典传奇","package_name":"com.zhidian.rxzz.x7sy","gamesize":"76.81","gamediscount":"4.5","return_rate":"0","discount_type":"1","one_game_info":"指尖与视觉双重爽虐的MMORPG动作手游"},{"guid":"240","game_logo":"http://res.x7sy.com/uploads/devloper_img/20160820/78932736083476799_thumb.png","game_name":"三国龙翔传","show_name":"三国龙翔传","package_name":"com.reagame.sglxz.az.x7sy","gamesize":"94.85","gamediscount":"4.8","return_rate":"0","discount_type":"1","one_game_info":"共享国战盛宴 携名将开疆扩土"},{"guid":"174","game_logo":"http://res.x7sy.com/uploads/devloper_img/20160815/29857513394030992_thumb.png","game_name":"傲视沙城","show_name":"傲视沙城-碎屛公会战","package_name":"com.yileweb.assc.x7sy","gamesize":"167.67","gamediscount":"4.3","return_rate":"0","discount_type":"1","one_game_info":"全民PK热潮，尽享王城之巅至尊荣耀！"},{"guid":"172","game_logo":"http://res.x7sy.com/uploads/devloper_img/20160814/57438762954655013_thumb.png","game_name":"葫芦娃","show_name":"葫芦娃","package_name":"com.sj49you.hlwh.x7sy","gamesize":"96.43","gamediscount":"4.8","return_rate":"0","discount_type":"1","one_game_info":"再现最真实的童年记忆, 唤醒你内心深处的童年梦"}]},{"section_name":"20:00","section_list":[{"guid":"403","game_logo":"http://res.x7sy.com/uploads/devloper_img/20160927/89037895966852200.png","game_name":"武神列传","show_name":"武神列传","package_name":"com.wslz.aowan.x7sy","gamesize":"105.60","gamediscount":"4.6","return_rate":"0","discount_type":"1","one_game_info":"回合制模拟策略Q版手机游戏"}]}]
     */

    private int errorno;
    private String errormsg;
    /**
     * section_name : 08:00
     * section_list : [{"guid":"297","game_logo":"http://res.x7sy.com/uploads/devloper_img/20160830/72794628637248137_thumb.png","game_name":"挂机吧主公","show_name":"挂机吧主公","package_name":"com.shenxiuinfo.sg.x7sy","gamesize":"57.09","gamediscount":"4.5","return_rate":"0","discount_type":"1","one_game_info":"全球第一放置手游"}]
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
        private String section_name;
        /**
         * guid : 297
         * game_logo : http://res.x7sy.com/uploads/devloper_img/20160830/72794628637248137_thumb.png
         * game_name : 挂机吧主公
         * show_name : 挂机吧主公
         * package_name : com.shenxiuinfo.sg.x7sy
         * gamesize : 57.09
         * gamediscount : 4.5
         * return_rate : 0
         * discount_type : 1
         * one_game_info : 全球第一放置手游
         */

        private List<GameInfoBean> section_list;

        public String getSection_name() {
            return section_name;
        }

        public void setSection_name(String section_name) {
            this.section_name = section_name;
        }

        public List<GameInfoBean> getSection_list() {
            return section_list;
        }

        public void setSection_list(List<GameInfoBean> section_list) {
            this.section_list = section_list;
        }
    }
}
