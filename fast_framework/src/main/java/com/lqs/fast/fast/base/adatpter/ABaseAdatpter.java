package com.lqs.fast.fast.base.adatpter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by dell on 2016/9/30.
 */

/**
 * @param <T> 行布局数据类型
 * @param <H> ViewHolder类型
 */
public abstract class ABaseAdatpter<T, H> extends BaseAdapter {
    protected final LayoutInflater mInflater;
    protected Context mContext;
    protected List<T> mDataList;

    public ABaseAdatpter(List<T> tList, Context context) {
        mDataList = tList;
        this.mContext = context;
        mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return mDataList.size();
    }

    @Override
    public Object getItem(int position) {
        return mDataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        int itemViewType = getItemViewType(position);
        if (convertView == null) {
            int[] itemResId = getItemResId();
            int resId = itemResId[itemViewType];
//            Log.i("convertView",""+convertView);
            convertView = mInflater.inflate(resId, null);
//            Log.i("convertView",""+convertView);
            H holder = getViewHolder();
            bindViewHolder(convertView, holder,position);
            convertView.setTag(holder);
        }
        H tag = (H) convertView.getTag();
        T t = mDataList.get(position);
        initItemUi(tag,t,position);
        return convertView;
    }

    protected abstract void initItemUi(H tag, T t, int position);

    protected abstract void bindViewHolder(View convertView, H holder, int position);

    protected abstract int[] getItemResId();

    protected abstract H getViewHolder();
}
