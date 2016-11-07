package com.lqs.fast.gamestore.adatpter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lqs.fast.fast.base.adatpter.ABaseAdatpter;
import com.lqs.fast.fast.utils.AppUtil;
import com.lqs.fast.fast.utils.FileUtil;
import com.lqs.fast.fast.utils.ImageUtils;
import com.lqs.fast.fast.utils.SpUtil;
import com.lqs.fast.gamestore.R;
import com.lqs.fast.gamestore.app.Constants;
import com.lqs.fast.gamestore.bean.SaveGameInfoBean;
import com.lqs.fast.gamestore.presenter.ICheckListener;
import com.lqs.fast.gamestore.presenter.IDownloadPresenter;
import com.lqs.fast.gamestore.service.MyDownLoadService;

import java.io.File;
import java.io.Serializable;
import java.util.List;

/**
 * Created by dell on 2016/10/14.
 */

public class MyLvGameManagerAdatpter extends ABaseAdatpter<SaveGameInfoBean, MyLvGameManagerAdatpter.MyViewHolder> {

    private final IDownloadPresenter mDownloadPresenter;

    public MyLvGameManagerAdatpter(List<SaveGameInfoBean> list, Context context, IDownloadPresenter downloadPresenter) {
        super(list, context);
        mDownloadPresenter = downloadPresenter;
    }

    @Override
    protected void initItemUi(final MyViewHolder tag, final SaveGameInfoBean bean, int position) {
        int itemViewType = getItemViewType(position);
        switch (itemViewType) {
            case 0: {
                ImageUtils.LoadImage(tag.mIvGameIcon, bean.getGame_logo());
                tag.mTvGameName.setText(bean.getGame_name());
                tag.mTvGameSize.setText(bean.getGamesize());
                tag.mTvGameType.setText(bean.getTypename());
                tag.mTvGameDescribe.setText(bean.getOne_game_info());
                tag.mIvState.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        tag.mLlMoreoption.setVisibility(View.VISIBLE);
                        tag.mIvState.setVisibility(View.INVISIBLE);
                    }
                });
//                tag.mLlMoreoption
                tag.mTvOpen.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        notifyDataSetChanged();
                        AppUtil.startAPk(mContext, bean.getPackage_name());
                    }
                });
                tag.mTvUnload.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AppUtil.unInstallApk(mContext, bean.getPackage_name());
                        bean.delete();
                        notifyDataSetChanged();
                    }
                });
                Boolean isDeleteInstallPackage = (Boolean) SpUtil.readSp(mContext,   //自动删除已安装
                        Constants.Settings.SP_NAME, Constants.Settings.DELETE_INSTALLPACKAGE);
                if(isDeleteInstallPackage != null && isDeleteInstallPackage ==true){
                    String fileName = MyDownLoadService.getFileName(bean.getDownload_url());
                    String filePath = Constants.getSavePath(mContext) + "/" + fileName;
                    File file = new File(filePath);
                    boolean exists = file.exists();
                    if(exists){
                        file.delete();
                    }
                }
            }
            break;
            case 1: {
                ImageUtils.LoadImage(tag.mIvGameIcon, bean.getGame_logo());
                tag.mTvGameName.setText(bean.getGame_name());
                String download_url = bean.getDownload_url();
                int downLoadState = mDownloadPresenter.getDownLoadState(download_url);


                switch (downLoadState) {
                    case MyDownLoadService.WAIT: {
                        tag.mTvDownloadState.setVisibility(View.VISIBLE);
                        tag.mTvSpeed.setVisibility(View.GONE);
                        tag.mTvDownloadState.setText("等待");
                        tag.mTvDownloadding.setVisibility(View.VISIBLE);
                        tag.mTvInstallState.setVisibility(View.GONE);
                        tag.mTvDownloadding.setText("0M/" + bean.getGamesize() + "M");
                        tag.mTvState.setText("等待");
                        tag.mTvState.setClickable(false);

                    }
                    break;
                    case MyDownLoadService.PROGRESS: {
                        tag.mTvDownloadState.setVisibility(View.GONE);
                        tag.mTvSpeed.setVisibility(View.VISIBLE);
                        tag.mTvSpeed.setText("0KB/S");
                        tag.mTvDownloadding.setVisibility(View.VISIBLE);
                        tag.mTvInstallState.setVisibility(View.GONE);
                        tag.mTvDownloadding.setText("0M/" + bean.getGamesize() + "M");
                        tag.mTvState.setText("下载中");
                        tag.mTvState.setClickable(false);
                    }
                    break;
                    case MyDownLoadService.COMPLETED: {
                        setCompletedState(tag, bean);
                    }
                    break;
                    case MyDownLoadService.FAIL: {
                        setFailState(tag, bean);
                    }
                    break;
                }
                if (downLoadState == 0) {
                    mDownloadPresenter.checkFileExists(download_url, new ICheckListener() {
                        @Override
                        public void check(boolean b) {
                            if(b){
                                setCompletedState(tag, bean);
                            }else {
                                setFailState(tag, bean);
                            }
                        }
                    });
                }

            }
            break;
        }
    }

    private void setCompletedState(MyViewHolder tag, final SaveGameInfoBean bean) {
        tag.mTvDownloadState.setVisibility(View.VISIBLE);
        tag.mTvSpeed.setVisibility(View.GONE);
        tag.mTvDownloadState.setText("下载完成");
        tag.mTvDownloadding.setVisibility(View.GONE);
        tag.mTvInstallState.setVisibility(View.VISIBLE);
        tag.mTvInstallState.setText("等待安装");
        tag.mTvState.setText("安装");
        tag.mTvState.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String filePath = Constants.getSavePath(mContext) + "/" + FileUtil.getFileName(bean.getDownload_url());
                AppUtil.installApk(mContext, filePath, true);
            }
        });
    }

    private void setFailState(final MyViewHolder tag, final SaveGameInfoBean bean) {
        tag.mTvDownloadState.setVisibility(View.VISIBLE);
        tag.mTvSpeed.setVisibility(View.GONE);
        tag.mTvDownloadState.setText("下载失败");
        tag.mTvDownloadding.setVisibility(View.VISIBLE);
        tag.mTvInstallState.setVisibility(View.GONE);
        tag.mTvState.setText("重试");
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDownloadPresenter.addDownLoadTask(bean.getDownload_url());
                tag.mTvState.setClickable(false);
            }
        };
        tag.mTvState.setOnClickListener(onClickListener);

        tag.mTvDownloadding.setText("0M/" + bean.getGamesize() + "M");
    }

    @Override
    protected void bindViewHolder(View itemView, MyViewHolder holder, int position) {

        int itemViewType = getItemViewType(position);

        if (itemViewType == 0) {
            //type 0
            holder.mIvGameIcon = (ImageView) itemView.findViewById(R.id.item_installed_iv_gameicon);
            holder.mTvGameName = (TextView) itemView.findViewById(R.id.item_installed_tv_gamename);
            holder.mTvGameSize = (TextView) itemView.findViewById(R.id.item_installed_tv_gamesize);
            holder.mTvGameType = (TextView) itemView.findViewById(R.id.item_installed_tv_gametype);
            holder.mTvGameDescribe = (TextView) itemView.findViewById(R.id.item_installed_tv_game_describe);
            holder.mIvState = (ImageView) itemView.findViewById(R.id.item_installed_iv_state);
            holder.mLlMoreoption = (LinearLayout) itemView.findViewById(R.id.item_installed_ll_moreoption);
            holder.mTvOpen = (TextView) itemView.findViewById(R.id.item_installed_tv_open);
            holder.mTvUnload = (TextView) itemView.findViewById(R.id.item_installed_tv_unload);
        } else {
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
        SaveGameInfoBean bean = mDataList.get(position);
        String package_name = bean.getPackage_name();
        boolean b = AppUtil.checkApkInstalled(mContext, package_name);
        if (b) {
            return 0;
        } else {
            return 1;
        }
    }

    protected class MyViewHolder {
        ImageView mIvGameIcon;
        TextView mTvGameName;
        TextView mTvGameSize;
        TextView mTvGameType;
        TextView mTvGameDescribe;
        ImageView mIvState;
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
