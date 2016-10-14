package com.lqs.fast.gamestore.adatpter;

import android.content.Context;
import android.view.View;

import com.lqs.fast.fast.base.adatpter.ABaseAdatpter;
import com.lqs.fast.gamestore.bean.GameInfoBean;

import java.util.List;

/**
 * Created by dell on 2016/10/14.
 */

public class MyLvGameManagerAdatpter extends ABaseAdatpter<GameInfoBean,MyLvGameManagerAdatpter.MyViewHolder> {

    public MyLvGameManagerAdatpter(List<GameInfoBean> list, Context context) {
        super(list, context);
    }

    @Override
    protected void initItemUi(MyViewHolder tag, GameInfoBean bean) {

    }

    @Override
    protected void bindViewHolder(View convertView, MyViewHolder holder) {

    }

    @Override
    protected int[] getItemResId() {
        return new int[0];
    }

    @Override
    protected MyViewHolder getViewHolder() {
        return new MyViewHolder();
    }

    protected class MyViewHolder{

    }
}
