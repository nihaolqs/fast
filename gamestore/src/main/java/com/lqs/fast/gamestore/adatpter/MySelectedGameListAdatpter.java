package com.lqs.fast.gamestore.adatpter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.lqs.fast.fast.base.adatpter.ABaseAdatpter;
import com.lqs.fast.fast.utils.AppUtil;
import com.lqs.fast.fast.utils.ImageUtils;
import com.lqs.fast.gamestore.R;
import com.lqs.fast.gamestore.app.Constants;
import com.lqs.fast.gamestore.bean.GameInfoBean;
import com.lqs.fast.gamestore.bean.SaveGameInfoBean;
import com.lqs.fast.gamestore.presenter.ICheckListener;
import com.lqs.fast.gamestore.presenter.IDownloadPresenter;
import com.lqs.fast.gamestore.service.MyDownLoadService;

import java.util.List;

/**
 * Created by dell on 2016/10/8.
 */

public class MySelectedGameListAdatpter extends ABaseAdatpter<GameInfoBean, MySelectedGameListAdatpter.ViewHolder> {

    private final IDownloadPresenter mDownloadPresenter;

    public MySelectedGameListAdatpter(List<GameInfoBean> list, Context context, IDownloadPresenter downloadPresenter) {
        super(list, context);
        this.mDownloadPresenter = downloadPresenter;
    }

    @Override
    protected void initItemUi(final ViewHolder holder, final GameInfoBean gameInfoBean, int position) {
        String typename = gameInfoBean.getTypename();
        holder.tvGameType.setText(typename);
        String game_logo = gameInfoBean.getGame_logo();
        ImageUtils.LoadImage(holder.ivGameIco, game_logo);
        String game_name = gameInfoBean.getGame_name();
        holder.tvGameName.setText(game_name);
        String gamediscount = gameInfoBean.getGamediscount();
        holder.tvGameDiscount.setText(gamediscount);
        String gamesize = gameInfoBean.getGamesize();
        holder.tvGameSize.setText(gamesize);
        String one_game_info = gameInfoBean.getOne_game_info();
        holder.tvGameDescribe.setText(one_game_info);

        int state = getState(gameInfoBean);
        switch (state) {
            case 0:
                setState(holder, "下载");
                break;
            case 1:
                setState(holder, "等待");
                break;
            case 2:
                setState(holder, "0%");
                break;
            case 3:
                setState(holder, "安装");
                break;
            case 4:
                setState(holder, "重试");
                break;
        }

        holder.tvState.setText(R.string.download);

//        final SingleFileDownLoadUtils singleFileDownLoadUtils = SingleFileDownLoadUtils.getInstance(mContext, 2);
//        final SingleFileDownLoadUtils.IDownLoadListener iDownLoadListener = new SingleFileDownLoadUtils.IDownLoadListener() {
//
//            @Override
//            public void wail() {
//                holder.tvState.post(new Runnable() {
//                    @Override
//                    public void run() {
//                        holder.tvState.setText("等待");
//                    }
//                });
//            }
//
//            @Override
//            public void progress(final int progre) {
//                holder.tvState.post(new Runnable() {
//                    @Override
//                    public void run() {
//                        holder.tvState.setText(progre + "%");
//                    }
//                });
//
//            }
//
//            @Override
//            public void completed() {
//                holder.tvState.post(new Runnable() {
//                    @Override
//                    public void run() {
//                        holder.tvState.setText("安装");
//                    }
//                });
//
//            }
//
//            @Override
//            public void fail() {
//                holder.tvState.post(new Runnable() {
//                    @Override
//                    public void run() {
//                        holder.tvState.setText("重试");
//                    }
//                });
//
//            }
//        };


//        int state = singleFileDownLoadUtils.getDownLoadState(download_url);
//        switch (state){
//            case 1: iDownLoadListener.wail();
//                break;
//            case 2: singleFileDownLoadUtils.setListener(download_url,iDownLoadListener);
//                break;
//            case 3:iDownLoadListener.completed();
//                break;
//            case 4:iDownLoadListener.fail();
//        }

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String download_url = gameInfoBean.getDownload_url();
//                int downLoadState = mDownloadPresenter.getDownLoadState(download_url);
                int downLoadState = getState(gameInfoBean);
                if (downLoadState == 0 || downLoadState == 4) {
                    mDownloadPresenter.addDownLoadTask(download_url);
                    SaveGameInfoBean bean = SaveGameInfoBean.getInstance4GameInfoBean(gameInfoBean);

                    mDownloadPresenter.saveGameInfo(bean);
                } else if (downLoadState == 3) {
                    //TODO 安装
                    String fileName = MyDownLoadService.getFileName(gameInfoBean.getDownload_url());
//                    String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
                    String filePath = Constants.getSavePath(mContext) + "/" + fileName;
//                    Intent i = new Intent(Intent.ACTION_VIEW);
//                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                    i.setDataAndType(Uri.parse("file://" + filePath), "application/vnd.android.package-archive");
//                    mContext.startActivity(i);
//                    android.os.Process.killProcess(android.os.Process.myPid());
                    AppUtil.installApk(mContext,filePath,Constants.FILEPROVIDER);
                }
            }
        };
        holder.tvState.setOnClickListener(listener);

        mDownloadPresenter.checkFileExists(gameInfoBean.getDownload_url(), new ICheckListener() {
            @Override
            public void check(boolean b) {
                if(b){
                    new Handler(mContext.getMainLooper()).post(new Runnable() {
                        @Override
                        public void run() {
                            holder.tvState.setText("安装");
                        }
                    });

                    holder.tvState.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String fileName = MyDownLoadService.getFileName(gameInfoBean.getDownload_url());
                            String filePath = Constants.getSavePath(mContext) + "/" + fileName;
                            AppUtil.installApk(mContext,filePath,Constants.FILEPROVIDER);
                        }
                    });
                }
            }
        });

    }

    private int getState(GameInfoBean gameInfoBean) {
        int state = mDownloadPresenter.getDownLoadState(gameInfoBean.getDownload_url());
//        if (state == 0) {
//            boolean fileExists = mDownloadPresenter.isFileExists(gameInfoBean.getDownload_url());
//            if (fileExists){
//                state = 3;
//            }
//        }
        return state;
    }


    private void setState(final ViewHolder holder, final String state) {
        holder.tvState.post(new Runnable() {
            @Override
            public void run() {
                holder.tvState.setText(state);
            }
        });
    }


    @Override
    protected void bindViewHolder(View convertView, ViewHolder holder, int position) {
        holder.ivGameIco = (ImageView) convertView.findViewById(R.id.item_select_iv_gameicon);
        holder.tvGameDiscount = (TextView) convertView.findViewById(R.id.item_select_tv_gamediscount);
        holder.tvGameName = (TextView) convertView.findViewById(R.id.item_select_tv_gamename);
        holder.tvGameSize = (TextView) convertView.findViewById(R.id.item_select_tv_gamesize);
        holder.tvGameType = (TextView) convertView.findViewById(R.id.item_select_tv_gametype);
        holder.tvGameDescribe = (TextView) convertView.findViewById(R.id.item_select_tv_game_describe);
        holder.tvState = (TextView) convertView.findViewById(R.id.item_select_tv_state);
    }

    @Override
    protected int[] getItemResId() {
        return new int[]{R.layout.item_main_select_rl};
    }

    @Override
    protected ViewHolder getViewHolder() {
        return new ViewHolder();
    }


    //    private final List<GameInfoBean> mList;
//    private final Context mContext;
//
//
//    public MySelectedGameListAdatpter(List<GameInfoBean> list, Context context) {
//        mList = list;
//        mContext = context;
//    }
//
//    @Override
//    public int getCount() {
//        return mList.size();
//    }
//
//    @Override
//    public Object getItem(int position) {
//        return mList.get(position);
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return position;
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        if (convertView == null) {
//            LayoutInflater inflater = LayoutInflater.from(mContext);
//            convertView = inflater.inflate(R.layout.item_main_select_rl, null);
//            initViewHolder(convertView);
//        }
//        ViewHolder holder = (ViewHolder) convertView.getTag();
//        GameInfoBean gameInfoBean = mList.get(position);
//        initItemData(holder, gameInfoBean);
//        return convertView;
//    }
//
//    private void initItemData(ViewHolder holder, GameInfoBean gameInfoBean) {
//        String typename = gameInfoBean.getTypename();
//        holder.tvGameType.setText(typename);
//        String game_logo = gameInfoBean.getGame_logo();
//        ImageUtils.LoadImage(holder.ivGameIco, game_logo);
//        String game_name = gameInfoBean.getGame_name();
//        holder.tvGameName.setText(game_name);
//        String gamediscount = gameInfoBean.getGamediscount();
//        holder.tvGameDiscount.setText(gamediscount);
//        String gamesize = gameInfoBean.getGamesize();
//        holder.tvGameSize.setText(gamesize);
//        String one_game_info = gameInfoBean.getOne_game_info();
//        holder.tvGameDescribe.setText(one_game_info);
//        holder.tvState.setText(R.string.download);
//
//    }
//
//    private void initViewHolder(View convertView) {
//        ViewHolder holder = new ViewHolder();
//        holder.ivGameIco = (ImageView) convertView.findViewById(R.id.item_select_iv_gameicon);
//        holder.tvGameDiscount = (TextView) convertView.findViewById(R.id.item_select_tv_gamediscount);
//        holder.tvGameName = (TextView) convertView.findViewById(R.id.item_select_tv_gamename);
//        holder.tvGameSize = (TextView) convertView.findViewById(R.id.item_select_tv_gamesize);
//        holder.tvGameType = (TextView) convertView.findViewById(R.id.item_select_tv_gametype);
//        holder.tvGameDescribe = (TextView) convertView.findViewById(R.id.item_select_tv_game_describe);
//        holder.tvState = (TextView) convertView.findViewById(R.id.item_select_tv_state);
//        convertView.setTag(holder);
//    }
//
    protected class ViewHolder {
        ImageView ivGameIco;
        TextView tvGameDiscount;
        TextView tvGameName;
        TextView tvGameSize;
        TextView tvGameType;
        TextView tvGameDescribe;
        TextView tvState;
    }
}
