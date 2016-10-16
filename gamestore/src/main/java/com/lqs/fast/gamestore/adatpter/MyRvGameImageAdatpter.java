package com.lqs.fast.gamestore.adatpter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lqs.fast.fast.base.adatpter.ABaseRecyclerViewAdapter;
import com.lqs.fast.fast.utils.SingleFileDownLoadUtils;
import com.lqs.fast.gamestore.R;
import com.lqs.fast.gamestore.bean.GameInfoBean;

import java.util.List;

/**
 * Created by dell on 2016/10/14.
 */

public class MyRvGameImageAdatpter extends ABaseRecyclerViewAdapter<MyRvGameImageAdatpter.MyViewHolder, GameInfoBean> {


    public MyRvGameImageAdatpter(Context context, List<GameInfoBean> list) {
        super(context, list);
    }

    @Override
    protected int getDataType(GameInfoBean bean) {


    }

    @Override
    protected int[] getItemLayoutResID() {

    }

    @Override
    protected MyViewHolder getViewHolderInstance(View itemView) {
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        int itemViewType = getItemViewType(position);
        if (itemViewType == 0) {

        } else {

        }
    }

    protected class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView mIvGameIcon;
        TextView mTvGameName;
        TextView mTvGameSize;
        TextView mTvGameType;
        TextView mTvGameDescribe;
        TextView mIvState;
        LinearLayout mLlMoreoption;
        TextView mTvOpen;
        TextView mTvUnload;

        //        ImageView mIvGameIcon;
        ImageView mIvDelete;
        //        TextView mTvGameName;
        TextView mTvSpeed;
        TextView mTvDownloadState;
        TextView mTvDownloadding;
        TextView mTvInstallState;
        ImageView mIvBegin;
        TextView mTvState;
        ImageView mIvPause;

        public MyViewHolder(View itemView) {
            super(itemView);
            //type 0
            mIvGameIcon = (ImageView) itemView.findViewById(R.id.item_installed_iv_gameicon);
            mTvGameName = (TextView) itemView.findViewById(R.id.item_installed_tv_gamename);
            mTvGameSize = (TextView) itemView.findViewById(R.id.item_installed_tv_gamesize);
            mTvGameType = (TextView) itemView.findViewById(R.id.item_installed_tv_gametype);
            mTvGameDescribe = (TextView) itemView.findViewById(R.id.item_installed_tv_game_describe);
            mIvState = (TextView) itemView.findViewById(R.id.item_installed_iv_state);
            mLlMoreoption = (LinearLayout) itemView.findViewById(R.id.item_installed_ll_moreoption);
            mTvOpen = (TextView) itemView.findViewById(R.id.item_installed_tv_open);
            mTvUnload = (TextView) itemView.findViewById(R.id.item_installed_tv_unload);

            //type 1

            mIvGameIcon = (ImageView) itemView.findViewById(R.id.item_download_iv_gameicon);
            mIvDelete = (ImageView) itemView.findViewById(R.id.item_download_iv_delete);
            mTvGameName = (TextView) itemView.findViewById(R.id.item_download_tv_gamename);
            mTvSpeed = (TextView) itemView.findViewById(R.id.item_download_tv_internetspeed);
            mTvDownloadState = (TextView) itemView.findViewById(R.id.item_download_tv_download_state);
            mTvDownloadding = (TextView) itemView.findViewById(R.id.item_download_tv_downloadding);
            mTvInstallState = (TextView) itemView.findViewById(R.id.item_download_tv_install_state);
            mIvBegin = (ImageView) itemView.findViewById(R.id.item_download_iv_begin);
            mTvState = (TextView) itemView.findViewById(R.id.item_download_tv_state);
            mIvPause = (ImageView) itemView.findViewById(R.id.item_download_iv_pause);
        }

    }
}
