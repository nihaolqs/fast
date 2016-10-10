package com.lqs.fast.gamestore.adatpter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.lqs.fast.fast.base.adatpter.ABaseAdatpter;
import com.lqs.fast.fast.widget.GridView4ScrollView_line;
import com.lqs.fast.gamestore.R;
import com.lqs.fast.gamestore.bean.GameInfoBean;
import com.lqs.fast.gamestore.bean.KfGame;

import java.util.List;

/**
 * Created by dell on 2016/10/10.
 */

public class MyLvKfListAdatpter extends ABaseAdatpter<KfGame.KfListBean,MyLvKfListAdatpter.MyViewHolder> {

    public MyLvKfListAdatpter(List<KfGame.KfListBean> kfListBeen, Context context) {
        super(kfListBeen, context);
    }

    @Override
    protected void initItemUi(MyViewHolder holder, KfGame.KfListBean kfListBean) {
        String section_name = kfListBean.getSection_name();
        holder.mTvKfListTime.setText(section_name);
        List<GameInfoBean> section_list = kfListBean.getSection_list();
        MyGvKfListGameListAdatpter myGvKfListGameListAdatpter = new MyGvKfListGameListAdatpter(section_list, mContext);
        holder.mGvKfListGameList.setAdapter(myGvKfListGameListAdatpter);
    }

    @Override
    protected void bindViewHolder(View convertView, MyViewHolder holder) {
        holder.mTvKfListTime = (TextView) convertView.findViewById(R.id.item_kaifulist_time_tv);
        holder.mGvKfListGameList = (GridView4ScrollView_line) convertView.findViewById(R.id.gv4svl_kaifulist_item_gamelis_gv);
    }

    @Override
    protected int[] getItemResId() {
        return new int[]{R.layout.item_kaifu_list};
    }

    @Override
    protected MyViewHolder getViewHolder() {
        return new MyViewHolder();
    }

    protected class MyViewHolder {
        TextView mTvKfListTime;
        GridView4ScrollView_line mGvKfListGameList;
    }
}
