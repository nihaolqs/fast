package com.lqs.fast.gamestore.adatpter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.lqs.fast.fast.base.adatpter.ABaseRecyclerViewAdapter;
import com.lqs.fast.fast.utils.ImageUtils;
import com.lqs.fast.gamestore.R;

import java.util.List;

/**
 * Created by dell on 2016/10/14.
 */

public class MyRvGameImageAdatpter extends ABaseRecyclerViewAdapter<MyRvGameImageAdatpter.MyViewHolder, String> {

    private ItemOnClickListener mOnclickListener;

    public MyRvGameImageAdatpter(Context context, List<String> list) {
        super(context, list);
    }

    @Override
    protected int getDataType(String bean) {
        return 0;
    }

    @Override
    protected int[] getItemLayoutResID() {

        return new int[]{R.layout.item_rv_gameimage};
    }

    @Override
    protected MyViewHolder getViewHolderInstance(View itemView) {
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        String url = mDataList.get(position);
        ImageUtils.LoadImage(holder.mGameImage, url);
        holder.position = position;
    }

    public void setItemOnclickListener(ItemOnClickListener itemOnclickListener){
        this.mOnclickListener = itemOnclickListener;
    }


    protected class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


        ImageView mGameImage;
        int position;

        public MyViewHolder(View itemView) {
            super(itemView);
            mGameImage = (ImageView) itemView.findViewById(R.id.gameinfo_iv);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if(mOnclickListener != null){
                mOnclickListener.itemOnclick(itemView,position);
            }
        }
    }

    public interface ItemOnClickListener{
        void itemOnclick(View view,int position);
    }
}
