package com.lqs.fast.gamestore.fragment;

import android.os.Handler;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.lqs.fast.fast.base.presenter.ABasePresenter;
import com.lqs.fast.fast.base_ui.ABaseFragment;
import com.lqs.fast.fast.utils.FileUtil;
import com.lqs.fast.fast.utils.MvpUtils;
import com.lqs.fast.gamestore.R;
import com.lqs.fast.gamestore.adatpter.MyLvGameManagerAdatpter;
import com.lqs.fast.gamestore.bean.SaveGameInfoBean;
import com.lqs.fast.gamestore.model.ManagerFragmentModel;
import com.lqs.fast.gamestore.presenter.DownLoadPresenter;
import com.lqs.fast.gamestore.presenter.IDownloadPresenter;
import com.lqs.fast.gamestore.presenter.IManagerPresenter;
import com.lqs.fast.gamestore.presenter.ManagerFragmentPresenter;
import com.lqs.fast.gamestore.service.MyDownLoadService;
import com.lqs.fast.gamestore.view.IDownLoadView;
import com.lqs.fast.gamestore.view.IManagerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell on 2016/10/14.
 */

public class ManagerFragment extends ABaseFragment<ManagerFragment, String> implements IManagerView, IDownLoadView {
    public static final String TAG = "ManagerFragment";
    private ListView mLvGameManager;
    private TextView mTvPhoneMemory;
    private TextView mTvAlready;
    private TextView mTvAvailable;

    private ArrayList<SaveGameInfoBean> mGameInfoBeenList = new ArrayList<>();
    private MyLvGameManagerAdatpter mMyLvGameManagerAdatpter;

    @Override
    protected void initMvp() {
        ManagerFragmentModel managerFragmentModel = new ManagerFragmentModel();
        ManagerFragmentPresenter managerFragmentPresenter = new ManagerFragmentPresenter(getContext());
        MvpUtils.initMVP(managerFragmentModel, managerFragmentPresenter, this);
    }

    @Override
    protected void initUI() {
        initFindView();
        initListView();
    }

    private void initListView() {
        mMyLvGameManagerAdatpter = new MyLvGameManagerAdatpter(mGameInfoBeenList, getContext(), getDownLoadPresenter());
        mLvGameManager.setAdapter(null);
    }

    private void initFindView() {
        mLvGameManager = (ListView) mFragmentLauout.findViewById(R.id.fragmain_namager_lv);
        mTvPhoneMemory = (TextView) mFragmentLauout.findViewById(R.id.frag_download_phoneMemoryInfo_tv);
        mTvAlready = (TextView) mFragmentLauout.findViewById(R.id.frag_download_already);
        mTvAvailable = (TextView) mFragmentLauout.findViewById(R.id.frag_download_available);

    }

    @Override
    protected void initData() {
        IManagerPresenter presenter = getManagerPresenter();
        presenter.replaceData();
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.frag_manager;
    }

    @Override
    public String getViewTag() {
        return TAG;
    }

    @Override
    public void showDownLoadedGame(List<SaveGameInfoBean> list) {

    }

    @Override
    public void showPhoneMemoryInfo(String phoneMemoryInfo) {

    }

    @Override
    public void showDownloadAlready(String downloadAlreadyinfo) {

    }

    @Override
    public void showDownloadAvailable(String downloadAvailableinfo) {

    }

    @Override
    public IManagerPresenter getManagerPresenter() {
        return null;
    }

    @Override
    public void setManagerPresenter(IManagerPresenter managerPresenter) {

    }

    @Override
    public void onStart() {
        super.onStart();
        ABasePresenter downLoadPresenter = (ABasePresenter) getDownLoadPresenter();
        downLoadPresenter.onStart(getContext());
    }

    @Override
    public void onStop() {
        super.onStop();
        ABasePresenter downLoadPresenter = (ABasePresenter) getDownLoadPresenter();
        downLoadPresenter.onStop(getContext());
    }

    @Override
    public void setDownLoadListener() {
        getDownLoadPresenter().setDownLoadListener(new MyDownLoadService.IDownLoadListener() {
            @Override
            public void wail(String url) {
                setItemDownloadStateWail(url);
            }

            @Override
            public void progress(String url, final int progre) {
                setItemDownloadState(url, progre+"%");
            }

            @Override
            public void completed(String url) {
                setItemDownloadState(url, "完成");
            }

            @Override
            public void fail(String url) {
                setItemDownloadState(url, "重试");
            }

            @Override
            public void speed(String url, final long speed) {
                setItemDownloadStateSpeed(url, speed);
            }

            @Override
            public void downloadedSize(String url, final long size) {
                setItemDownloadStateSize(url, size);
            }
        });
    }

    private void setItemDownloadStateSpeed(String url, final long speed) {
        Handler handler = new Handler();
        for (int i = 0; i < mGameInfoBeenList.size(); i++) {
            int itemViewType = mMyLvGameManagerAdatpter.getItemViewType(i);
            final SaveGameInfoBean bean = mGameInfoBeenList.get(i);
            if (bean.getDownload_url().equals(url) &&
                    i >= mLvGameManager.getFirstVisiblePosition() &&
                    i < mLvGameManager.getLastVisiblePosition() &&
                    itemViewType == 1) {
                View itemView = mLvGameManager.getChildAt(i - mLvGameManager.getFirstVisiblePosition());
                final TextView mTvSpeed = (TextView) itemView.findViewById(R.id.item_download_tv_internetspeed);
                final TextView mTvDownloadState = (TextView) itemView.findViewById(R.id.item_download_tv_download_state);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        mTvDownloadState.setVisibility(View.GONE);
                        mTvSpeed.setVisibility(View.VISIBLE);
                        mTvDownloadState.setText(FileUtil.formatDownLoadSpeed(speed));
                    }
                });
            }
        }
    }

    private void setItemDownloadStateSize(String url, final long size) {
        Handler handler = new Handler();
        for (int i = 0; i < mGameInfoBeenList.size(); i++) {
            int itemViewType = mMyLvGameManagerAdatpter.getItemViewType(i);
            final SaveGameInfoBean bean = mGameInfoBeenList.get(i);
            if (bean.getDownload_url().equals(url) &&
                    i >= mLvGameManager.getFirstVisiblePosition() &&
                    i < mLvGameManager.getLastVisiblePosition() &&
                    itemViewType == 1) {
                View itemView = mLvGameManager.getChildAt(i - mLvGameManager.getFirstVisiblePosition());
                final TextView mTvDownloadding = (TextView) itemView.findViewById(R.id.item_download_tv_downloadding);
                final TextView mTvInstallState = (TextView) itemView.findViewById(R.id.item_download_tv_install_state);
                final String gamesize = mGameInfoBeenList.get(i).getGamesize();
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        mTvInstallState.setVisibility(View.GONE);
                        mTvDownloadding.setVisibility(View.VISIBLE);
                        mTvDownloadding.setText(FileUtil.formatSize(size) + "/" + gamesize);
                    }
                });
            }
        }
    }

    private void setItemDownloadState(String url, final String stateStr) {
        Handler handler = new Handler();
        for (int i = 0; i < mGameInfoBeenList.size(); i++) {
            int itemViewType = mMyLvGameManagerAdatpter.getItemViewType(i);
            final SaveGameInfoBean bean = mGameInfoBeenList.get(i);
            if (bean.getDownload_url().equals(url) &&
                    i >= mLvGameManager.getFirstVisiblePosition() &&
                    i < mLvGameManager.getLastVisiblePosition() &&
                    itemViewType == 1) {
                View itemView = mLvGameManager.getChildAt(i - mLvGameManager.getFirstVisiblePosition());
                final TextView tvState = (TextView) itemView.findViewById(R.id.item_download_tv_state);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        tvState.setText(stateStr);
                    }
                });
            }
        }
    }

    private void setItemDownloadStateWail(String url) {
        Handler handler = new Handler();
        for (int i = 0; i < mGameInfoBeenList.size(); i++) {
            int itemViewType = mMyLvGameManagerAdatpter.getItemViewType(i);
            final SaveGameInfoBean bean = mGameInfoBeenList.get(i);
            if (bean.getDownload_url().equals(url) &&
                    i >= mLvGameManager.getFirstVisiblePosition() &&
                    i < mLvGameManager.getLastVisiblePosition() &&
                    itemViewType == 1) {
                View itemView = mLvGameManager.getChildAt(i - mLvGameManager.getFirstVisiblePosition());
                final TextView mTvSpeed = (TextView) itemView.findViewById(R.id.item_download_tv_internetspeed);
                final TextView mTvDownloadState = (TextView) itemView.findViewById(R.id.item_download_tv_download_state);
                final TextView mTvDownloadding = (TextView) itemView.findViewById(R.id.item_download_tv_downloadding);
                final TextView mTvInstallState = (TextView) itemView.findViewById(R.id.item_download_tv_install_state);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        mTvDownloadState.setVisibility(View.VISIBLE);
                        mTvSpeed.setVisibility(View.GONE);
                        mTvDownloadState.setText("等待");
                        mTvDownloadding.setVisibility(View.VISIBLE);
                        mTvInstallState.setVisibility(View.GONE);
                        mTvDownloadding.setText("0M/" + bean.getGamesize() + "M");
                    }
                });


            }
        }
    }

    @Override
    public void setDownLoadPresenter(IDownloadPresenter downLoadPresenter) {
        addPresenter((ABasePresenter) downLoadPresenter);
    }

    @Override
    public IDownloadPresenter getDownLoadPresenter() {
        ABasePresenter presenter = getPresenter(DownLoadPresenter.TAG);
        return (IDownloadPresenter) presenter;
    }
}
