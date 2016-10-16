package com.lqs.fast.gamestore.adatpter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lqs.fast.fast.base.adatpter.ABaseAdatpter;
import com.lqs.fast.gamestore.R;
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
    protected void bindViewHolder(View itemView, MyViewHolder holder) {
        
            //type 0

        holder.mIvGameIcon = (ImageView) itemView.findViewById(R.id.item_installed_iv_gameicon);
        holder.mTvGameName = (TextView) itemView.findViewById(R.id.item_installed_tv_gamename);
        holder.mTvGameSize = (TextView) itemView.findViewById(R.id.item_installed_tv_gamesize);
        holder.mTvGameType = (TextView) itemView.findViewById(R.id.item_installed_tv_gametype);
        holder.mTvGameDescribe = (TextView) itemView.findViewById(R.id.item_installed_tv_game_describe);
        holder.mIvState = (TextView) itemView.findViewById(R.id.item_installed_iv_state);
        holder.mLlMoreoption = (LinearLayout) itemView.findViewById(R.id.item_installed_ll_moreoption);
        holder.mTvOpen = (TextView) itemView.findViewById(R.id.item_installed_tv_open);
        holder.mTvUnload = (TextView) itemView.findViewById(R.id.item_installed_tv_unload);

            //type 1

        holder.mIvGameIcon = (ImageView) itemView.findViewById(R.id.item_download_iv_gameicon);
        holder.mIvDelete = (ImageView) itemView.findViewById(R.id.item_download_iv_delete);
        holder.mTvGameName = (TextView) itemView.findViewById(R.id.item_download_tv_gamename);
        holder.mTvSpeed = (TextView) itemView.findViewById(R.id.item_download_tv_internetspeed);
        holder.mTvDownloadState = (TextView) itemView.findViewById(R.id.item_download_tv_download_state);
        holder.mTvDownloadding = (TextView) itemView.findViewById(R.id.item_download_tv_downloadding);
        holder.mTvInstallState = (TextView) itemView.findViewById(R.id.item_download_tv_install_state);
        holder.mIvBegin = (ImageView) itemView.findViewById(R.id.item_download_iv_begin);
        holder.mTvState = (TextView) itemView.findViewById(R.id.item_download_tv_state);
        holder.mIvPause = (ImageView) itemView.findViewById(R.id.item_download_iv_pause);
    }

    @Override
    protected int[] getItemResId() {
        return new int[]{R.layout.item_manager_installed_rl, R.layout.item_manager_download_rl};

    }

    @Override
    protected MyViewHolder getViewHolder() {
        return new MyViewHolder();
    }

    @Override
    public int getItemViewType(int position) {
        //todo 错误
//        String download_url = bean.getDownload_url();
//        SingleFileDownLoadUtils singleFileDownLoadUtils = SingleFileDownLoadUtils.getInstance(mContext, 2);
//        int downLoadState = singleFileDownLoadUtils.getDownLoadState(download_url);
//        if (downLoadState == SingleFileDownLoadUtils.PROGRESS) {
//            return 1;
//        }
        return 0;
    }

    protected class MyViewHolder{
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

    }
}
