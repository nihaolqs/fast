package com.lqs.fast.gamestore.adatpter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.lqs.fast.fast.base.adatpter.ABaseAdatpter;
import com.lqs.fast.fast.utils.ImageUtils;
import com.lqs.fast.gamestore.R;
import com.lqs.fast.gamestore.bean.GameInfoBean;

import java.util.List;

/**
 * Created by dell on 2016/10/10.
 */

public class MyGvKfListGameListAdatpter extends ABaseAdatpter<GameInfoBean,MyGvKfListGameListAdatpter.MyViewHolder>{

    public MyGvKfListGameListAdatpter(List<GameInfoBean> list, Context context) {
        super(list, context);
    }

    @Override
    protected void initItemUi(MyViewHolder tag, GameInfoBean bean, int position) {
        String show_name = bean.getShow_name();
        tag.tvGameShowName.setText(show_name);
        String gamediscount = bean.getGamediscount();
        tag.tvGameDiscount.setText(gamediscount);
        String game_logo = bean.getGame_logo();
        ImageUtils.LoadImage(tag.ivGameIcon,game_logo);
    }

    @Override
    protected void bindViewHolder(View convertView, MyViewHolder holder) {
        holder.ivGameIcon = (ImageView) convertView.findViewById(R.id.item_kaifulist_icon_iv_left);
        holder.tvGameShowName = (TextView) convertView.findViewById(R.id.item_kaifulist_gamename_tv_left);
        holder.tvGameDiscount = (TextView) convertView.findViewById(R.id.item_kaifulist_gamediscount_tv_left);
    }

    @Override
    protected int[] getItemResId() {
        return new int[]{R.layout.item_gv4svl_kaifulist_item_gamelist_gv};
    }

    @Override
    protected MyViewHolder getViewHolder() {
        return new MyViewHolder();
    }

    protected class MyViewHolder{
        ImageView ivGameIcon;
        TextView tvGameShowName;
        TextView tvGameDiscount;
    }
}
