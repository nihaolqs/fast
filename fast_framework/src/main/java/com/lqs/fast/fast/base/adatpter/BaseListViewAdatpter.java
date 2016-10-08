package com.lqs.fast.fast.base.adatpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.lqs.fast.fast.R;
import com.lqs.fast.fast.utils.ImageUtils;

import java.util.List;

/**
 * Created by lin on 2016/10/8.
 */

/**
 *
 * @param <T> item数据类
 * @param <H> viewholder
 */
public abstract class BaseListViewAdatpter<T,H> extends BaseAdapter{

    protected final List<T> mList;
    protected final Context mContext;

    public BaseListViewAdatpter(List<T> list,Context context){
        mList = list;
        mContext = context;
    }
    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(getItemRes(), null);
            initViewHolder(convertView);
        }
        H holder = (H) convertView.getTag();
        T t = mList.get(position);
        initItemData(holder, t);
        return convertView;
    }

    protected abstract int getItemRes();

    private void initViewHolder(View convertView) {
        H holder = getViewHolder();
        bindViewHolder(convertView, holder);
        convertView.setTag(holder);
    }

    protected abstract void initItemData(H holder, T gameInfoBean);

    protected abstract void bindViewHolder(View convertView, H holder);

    protected abstract H getViewHolder();


}
