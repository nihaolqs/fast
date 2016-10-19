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
 * Created by dell on 2016/10/12.
 */

public class MyHotSearchAdatpter extends ABaseAdatpter<GameInfoBean,MyHotSearchAdatpter.ViewHolder>{

    public MyHotSearchAdatpter(List<GameInfoBean> list, Context context) {
        super(list, context);
    }

    @Override
    protected void initItemUi(ViewHolder tag, GameInfoBean bean, int position) {
        String game_logo = bean.getGame_logo();
        String show_name = bean.getShow_name();
        ImageView mIvGameIco = tag.mIvGameIco;
        TextView mTvShowGameName = tag.mTvShowGameName;
        ImageUtils.LoadImage(mIvGameIco,game_logo);
        mTvShowGameName.setText(show_name);
    }

    @Override
    protected void bindViewHolder(View convertView, ViewHolder holder, int position) {
        holder.mIvGameIco = (ImageView) convertView.findViewById(R.id.iv_itemhotsearchgame_gameico);
        holder.mTvShowGameName = (TextView) convertView.findViewById(R.id.tv_itemhotsearch_showgamename);
    }

    @Override
    protected int[] getItemResId() {
        return new int[]{R.layout.item_hot_searchgame};
    }

    @Override
    protected ViewHolder getViewHolder() {
        return new ViewHolder();
    }

    protected class ViewHolder{

        public ImageView mIvGameIco;
        public TextView mTvShowGameName;
    }
}
