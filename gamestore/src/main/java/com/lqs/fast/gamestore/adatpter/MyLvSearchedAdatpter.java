package com.lqs.fast.gamestore.adatpter;

import android.content.Context;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lqs.fast.fast.base.adatpter.ABaseAdatpter;
import com.lqs.fast.fast.utils.ImageUtils;
import com.lqs.fast.fast.widget.FlowLayout;
import com.lqs.fast.gamestore.R;
import com.lqs.fast.gamestore.bean.GameInfoBean;

import java.util.List;

/**
 * Created by dell on 2016/10/12.
 */

public class MyLvSearchedAdatpter extends ABaseAdatpter<GameInfoBean,MyLvSearchedAdatpter.MyViewHolder>{

    public MyLvSearchedAdatpter(List<GameInfoBean> list, Context context) {
        super(list, context);
    }

    @Override
    protected void initItemUi(final MyViewHolder tag, GameInfoBean bean) {
        ImageUtils.LoadImage(tag.mIvGameIcon,bean.getGame_logo());
        tag.mTvGameShowName.setText(bean.getShow_name());
        tag.mTvGameSize.setText(bean.getGamesize());
        tag.mTvGameType.setText(bean.getTypename());
        tag.mTvGameDescribe.setText(bean.getOne_game_info());
        tag.mTvState.setText(R.string.download);
        tag.mFlowLayout.removeAllViews();
        final List<String> time_list = bean.getTime_list();
        if(time_list != null)
        {
            tag.mFlowLayout.setVisibility(View.VISIBLE);

            addFlowLayoutView(tag.mFlowLayout,time_list,2);

            if(tag.mFlowLayout.getChildCount() < time_list.size())
            {
                tag.mTvKfMore.setVisibility(View.VISIBLE);
            }else{
                tag.mTvKfMore.setVisibility(View.GONE);
            }

            tag.mTvKfMore.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    addFlowLayoutView(tag.mFlowLayout,time_list,time_list.size());
                    tag.mTvKfMore.setVisibility(View.GONE);
                }
            });

        }else{
            tag.mFlowLayout.setVisibility(View.GONE);
        }
    }

    private void addFlowLayoutView(FlowLayout flowLayout,List<String> list,int maxNum){
        flowLayout.removeAllViews();
        int min = Math.min(list.size(), maxNum);
        for (int i = 0; i < min; i++){
            String s = list.get(i);
            LinearLayout flowlayout = (LinearLayout) mInflater.inflate(R.layout.item_flowlayout,null);
            TextView textView = (TextView) flowlayout.findViewById(R.id.tv_item_flowlayout);
            flowlayout.removeView(textView);
            textView.setText(s);
            flowLayout.addView(textView);
        }
    }

    @Override
    protected void bindViewHolder(View convertView, MyViewHolder holder) {
        holder.mIvGameIcon = (ImageView) convertView.findViewById(R.id.item_select_iv_gameicon);
        holder.mTvGameShowName = (TextView) convertView.findViewById(R.id.item_select_tv_gamename);
        holder.mTvGameSize = (TextView) convertView.findViewById(R.id.item_select_tv_gamesize);
        holder.mTvGameType = (TextView) convertView.findViewById(R.id.item_select_tv_gametype);
        holder.mTvGameDescribe = (TextView) convertView.findViewById(R.id.item_select_tv_game_describe);
        holder.mFlowLayout = (FlowLayout) convertView.findViewById(R.id.flow_layout);
        holder.mTvState = (TextView) convertView.findViewById(R.id.item_select_tv_state);
        holder.mTvKfMore = (TextView) convertView.findViewById(R.id.kaifu_tv_more);
    }

    @Override
    protected int[] getItemResId() {
        return new int[]{R.layout.item_kaifu_search_rl};
    }

    @Override
    protected MyViewHolder getViewHolder() {
        return new MyViewHolder();
    }

    protected class MyViewHolder{

        public ImageView mIvGameIcon;
        public TextView mTvGameShowName;
        public TextView mTvGameSize;
        public TextView mTvGameType;
        public TextView mTvGameDescribe;
        public FlowLayout mFlowLayout;
        public TextView mTvState;
        public TextView mTvKfMore;
    }
}
