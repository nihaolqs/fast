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
import com.lqs.fast.fast.widget.FlowLayout;
import com.lqs.fast.gamestore.R;
import com.lqs.fast.gamestore.app.Constants;
import com.lqs.fast.gamestore.bean.GameInfoBean;
import com.lqs.fast.gamestore.presenter.ICheckListener;
import com.lqs.fast.gamestore.presenter.IDownloadPresenter;
import com.lqs.fast.gamestore.service.MyDownLoadService;

import java.util.List;

/**
 * Created by dell on 2016/10/12.
 */

public class MyLvSearchedAdatpter extends ABaseAdatpter<GameInfoBean,MyLvSearchedAdatpter.MyViewHolder>{

    private IDownloadPresenter mDownloadPresenter;

    public MyLvSearchedAdatpter(List<GameInfoBean> list, Context context, IDownloadPresenter downloadPresenter) {
        super(list, context);
        this.mDownloadPresenter = downloadPresenter;
    }

    @Override
    protected void initItemUi(final MyViewHolder tag, final GameInfoBean bean, int position) {
        ImageUtils.LoadImage(tag.mIvGameIcon,bean.getGame_logo());
        tag.mTvGameShowName.setText(bean.getShow_name());
        tag.mTvGameSize.setText(bean.getGamesize());
        tag.mTvGameType.setText(bean.getTypename());
        tag.mTvGameDescribe.setText(bean.getOne_game_info());
        tag.mTvState.setText(R.string.download);
        int state = mDownloadPresenter.getDownLoadState(bean.getDownload_url());
//        if(state == 0 && MyDownLoadService)
//        if(state == MyDownLoadService.COMPLETED){
//
//        }else if(state == 0){
//
//        }
        if(state == MyDownLoadService.FAIL){
            tag.mTvState.setText(R.string.retry);
        }
        if(state == 0 || state == MyDownLoadService.FAIL) {

            tag.mTvState.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mDownloadPresenter.addDownLoadTask(bean.getDownload_url());
                }
            });
        }
        mDownloadPresenter.checkFileExists(bean.getDownload_url(), new ICheckListener() {
            @Override
            public void check(boolean b) {
                if(b){
                    tag.mTvState.setText("安装");
                    tag.mTvState.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String fileName = MyDownLoadService.getFileName(bean.getDownload_url());
                            String filePath = Constants.getSavePath(mContext) + "/" +fileName;
                            AppUtil.installApk(mContext,filePath,true);
                        }
                    });
                }
            }
        });

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
    protected void bindViewHolder(View convertView, MyViewHolder holder, int position) {
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
