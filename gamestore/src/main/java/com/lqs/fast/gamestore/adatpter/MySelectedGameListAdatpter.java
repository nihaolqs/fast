package com.lqs.fast.gamestore.adatpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.lqs.fast.fast.base.adatpter.ABaseAdatpter;
import com.lqs.fast.fast.base.adatpter.BaseListViewAdatpter;
import com.lqs.fast.fast.utils.ImageUtils;
import com.lqs.fast.gamestore.R;
import com.lqs.fast.gamestore.bean.GameInfoBean;

import java.util.List;

/**
 * Created by dell on 2016/10/8.
 */

public class MySelectedGameListAdatpter extends ABaseAdatpter<GameInfoBean,MySelectedGameListAdatpter.ViewHolder> {

    public MySelectedGameListAdatpter(List<GameInfoBean> list, Context context) {
        super(list, context);
    }

    @Override
    protected void initItemUi(ViewHolder holder, GameInfoBean gameInfoBean) {
        String typename = gameInfoBean.getTypename();
        holder.tvGameType.setText(typename);
        String game_logo = gameInfoBean.getGame_logo();
        ImageUtils.LoadImage(holder.ivGameIco, game_logo);
        String game_name = gameInfoBean.getGame_name();
        holder.tvGameName.setText(game_name);
        String gamediscount = gameInfoBean.getGamediscount();
        holder.tvGameDiscount.setText(gamediscount);
        String gamesize = gameInfoBean.getGamesize();
        holder.tvGameSize.setText(gamesize);
        String one_game_info = gameInfoBean.getOne_game_info();
        holder.tvGameDescribe.setText(one_game_info);
        holder.tvState.setText(R.string.download);
    }


    @Override
    protected void bindViewHolder(View convertView, ViewHolder holder) {
        holder.ivGameIco = (ImageView) convertView.findViewById(R.id.item_select_iv_gameicon);
        holder.tvGameDiscount = (TextView) convertView.findViewById(R.id.item_select_tv_gamediscount);
        holder.tvGameName = (TextView) convertView.findViewById(R.id.item_select_tv_gamename);
        holder.tvGameSize = (TextView) convertView.findViewById(R.id.item_select_tv_gamesize);
        holder.tvGameType = (TextView) convertView.findViewById(R.id.item_select_tv_gametype);
        holder.tvGameDescribe = (TextView) convertView.findViewById(R.id.item_select_tv_game_describe);
        holder.tvState = (TextView) convertView.findViewById(R.id.item_select_tv_state);
    }

    @Override
    protected int[] getItemResId() {
        return new int[]{R.layout.item_main_select_rl};
    }

    @Override
    protected ViewHolder getViewHolder() {
        return new ViewHolder();
    }

    //    private final List<GameInfoBean> mList;
//    private final Context mContext;
//
//
//    public MySelectedGameListAdatpter(List<GameInfoBean> list, Context context) {
//        mList = list;
//        mContext = context;
//    }
//
//    @Override
//    public int getCount() {
//        return mList.size();
//    }
//
//    @Override
//    public Object getItem(int position) {
//        return mList.get(position);
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return position;
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        if (convertView == null) {
//            LayoutInflater inflater = LayoutInflater.from(mContext);
//            convertView = inflater.inflate(R.layout.item_main_select_rl, null);
//            initViewHolder(convertView);
//        }
//        ViewHolder holder = (ViewHolder) convertView.getTag();
//        GameInfoBean gameInfoBean = mList.get(position);
//        initItemData(holder, gameInfoBean);
//        return convertView;
//    }
//
//    private void initItemData(ViewHolder holder, GameInfoBean gameInfoBean) {
//        String typename = gameInfoBean.getTypename();
//        holder.tvGameType.setText(typename);
//        String game_logo = gameInfoBean.getGame_logo();
//        ImageUtils.LoadImage(holder.ivGameIco, game_logo);
//        String game_name = gameInfoBean.getGame_name();
//        holder.tvGameName.setText(game_name);
//        String gamediscount = gameInfoBean.getGamediscount();
//        holder.tvGameDiscount.setText(gamediscount);
//        String gamesize = gameInfoBean.getGamesize();
//        holder.tvGameSize.setText(gamesize);
//        String one_game_info = gameInfoBean.getOne_game_info();
//        holder.tvGameDescribe.setText(one_game_info);
//        holder.tvState.setText(R.string.download);
//
//    }
//
//    private void initViewHolder(View convertView) {
//        ViewHolder holder = new ViewHolder();
//        holder.ivGameIco = (ImageView) convertView.findViewById(R.id.item_select_iv_gameicon);
//        holder.tvGameDiscount = (TextView) convertView.findViewById(R.id.item_select_tv_gamediscount);
//        holder.tvGameName = (TextView) convertView.findViewById(R.id.item_select_tv_gamename);
//        holder.tvGameSize = (TextView) convertView.findViewById(R.id.item_select_tv_gamesize);
//        holder.tvGameType = (TextView) convertView.findViewById(R.id.item_select_tv_gametype);
//        holder.tvGameDescribe = (TextView) convertView.findViewById(R.id.item_select_tv_game_describe);
//        holder.tvState = (TextView) convertView.findViewById(R.id.item_select_tv_state);
//        convertView.setTag(holder);
//    }
//
    protected class ViewHolder {
        ImageView ivGameIco;
        TextView tvGameDiscount;
        TextView tvGameName;
        TextView tvGameSize;
        TextView tvGameType;
        TextView tvGameDescribe;
        TextView tvState;
    }
}
