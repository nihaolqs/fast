package com.lqs.fast.fast.base.adatpter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by dell on 2016/10/14.
 */

public abstract class ABaseRecyclerViewAdapter<VH extends RecyclerView.ViewHolder,T> extends RecyclerView.Adapter<VH>{

    protected final Context mContext;
    protected final List<T> mDataList;
    protected final LayoutInflater mLayoutInflater;

    public ABaseRecyclerViewAdapter(Context context, List<T> list){
        this.mContext = context;
        this.mDataList = list;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        int[] resIDs = getItemLayoutResID();
        int resID = resIDs[viewType];
        View itemLayout = mLayoutInflater.inflate(resID, parent);
        VH viewHolder = getViewHolderInstance(itemLayout);
        return viewHolder;
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    @Override
    public int getItemViewType(int position) {
        T t = mDataList.get(position);
        int dataType = getDataType(t);
        return dataType;
    }

    protected abstract int getDataType(T t);

    protected abstract int[] getItemLayoutResID();

    protected abstract VH getViewHolderInstance(View itemView);

}
