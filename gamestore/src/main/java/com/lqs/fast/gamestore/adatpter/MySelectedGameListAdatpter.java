package com.lqs.fast.gamestore.adatpter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.lqs.fast.fast.base.adatpter.ABaseAdatpter;
import com.lqs.fast.fast.base.adatpter.BaseListViewAdatpter;
import com.lqs.fast.fast.utils.ImageUtils;
import com.lqs.fast.fast.utils.SingleFileDownLoadUtils;
import com.lqs.fast.gamestore.R;
import com.lqs.fast.gamestore.bean.GameInfoBean;

import java.util.List;

/**
 * Created by dell on 2016/10/8.
 */

public class MySelectedGameListAdatpter extends ABaseAdatpter<GameInfoBean,MySelectedGameListAdatpter.ViewHolder> {

    public MySelectedGameListAdatpter(List<GameInfoBean> list, Context context) {
        super(list, context);
    }

    @Override
    protected void initItemUi(final ViewHolder holder, final GameInfoBean gameInfoBean) {
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
        holder.tvState.setText(R.string.download);

        final SingleFileDownLoadUtils singleFileDownLoadUtils = SingleFileDownLoadUtils.getInstance(mContext, 2);
        final SingleFileDownLoadUtils.IDownLoadListener iDownLoadListener = new SingleFileDownLoadUtils.IDownLoadListener() {

            @Override
            public void wail() {
                holder.tvState.post(new Runnable() {
                    @Override
                    public void run() {
                        holder.tvState.setText("等待");
                    }
                });
            }

            @Override
            public void progress(final int progre) {
                holder.tvState.post(new Runnable() {
                    @Override
                    public void run() {
                        holder.tvState.setText(progre + "%");
                    }
                });

            }

            @Override
            public void completed() {
                holder.tvState.post(new Runnable() {
                    @Override
                    public void run() {
                        holder.tvState.setText("安装");
                    }
                });

            }

            @Override
            public void fail() {
                holder.tvState.post(new Runnable() {
                    @Override
                    public void run() {
                        holder.tvState.setText("重试");
                    }
                });

            }
        };
        final String download_url = gameInfoBean.getDownload_url();

        int state = singleFileDownLoadUtils.getDownLoadState(download_url);
        switch (state){
            case 1: iDownLoadListener.wail();
                break;
            case 2: singleFileDownLoadUtils.setListener(download_url,iDownLoadListener);
                break;
            case 3:iDownLoadListener.completed();
                break;
            case 4:iDownLoadListener.fail();
        }

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int downLoadState = singleFileDownLoadUtils.getDownLoadState(download_url);
                if(downLoadState == 0 || downLoadState == 4)
                {
                    singleFileDownLoadUtils.addDownLoadTask(download_url, iDownLoadListener);
                }else if(downLoadState == 3)
                {
                    //TODO 安装
                    String fileName = SingleFileDownLoadUtils.getFileName(gameInfoBean.getDownload_url());
                    String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
                    String filePath = absolutePath + "/" + fileName;
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    i.setDataAndType(Uri.parse("file://" + filePath), "application/vnd.android.package-archive");
                    mContext.startActivity(i);
                    android.os.Process.killProcess(android.os.Process.myPid());
                }
            }
        };
        holder.tvState.setOnClickListener(listener);

    }


    @Override
    protected void bindViewHolder(View convertView, ViewHolder holder) {
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
