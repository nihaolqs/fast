package com.lqs.fast.gamestore.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.lqs.fast.fast.base.presenter.ABasePresenter;
import com.lqs.fast.fast.base_ui.ABaseFragment;
import com.lqs.fast.fast.utils.AppUtil;
import com.lqs.fast.fast.utils.FileUtil;
import com.lqs.fast.fast.utils.MvpUtils;
import com.lqs.fast.gamestore.R;
import com.lqs.fast.gamestore.activity.GameDetailActivity;
import com.lqs.fast.gamestore.adatpter.MyLvGameManagerAdatpter;
import com.lqs.fast.gamestore.app.Constants;
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
    private boolean isPause;

    private ArrayList<SaveGameInfoBean> mGameInfoBeenList = new ArrayList<>();
    private MyLvGameManagerAdatpter mMyLvGameManagerAdatpter;
    private MyDownLoadService.IDownLoadListener mDownLoadListener;

    @Override
    protected void initMvp() {
        ManagerFragmentModel managerFragmentModel = new ManagerFragmentModel();
        ManagerFragmentPresenter managerFragmentPresenter = new ManagerFragmentPresenter(getContext());
        MvpUtils.initMVP(managerFragmentModel, managerFragmentPresenter, this);
        DownLoadPresenter downLoadPresenter = new DownLoadPresenter(getContext());
        this.setDownLoadPresenter(downLoadPresenter);

        downLoadPresenter.onStart(getContext());
//        setDownLoadListener();
    }

    @Override
    protected void initUI() {
        initFindView();
        initListView();
    }

    private void initListView() {
        mMyLvGameManagerAdatpter = new MyLvGameManagerAdatpter(mGameInfoBeenList, getContext(), getDownLoadPresenter());
        mLvGameManager.setAdapter(mMyLvGameManagerAdatpter);
        mLvGameManager.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Context context = getContext();
                Intent intent = new Intent(context, GameDetailActivity.class);
                SaveGameInfoBean saveGameInfoBean = mGameInfoBeenList.get(position - mLvGameManager.getHeaderViewsCount());
                intent.putExtra(GameDetailActivity.GUID_KEY,saveGameInfoBean.getGuid());
                context.startActivity(intent);
            }
        });
    }

    private void initFindView() {
        mLvGameManager = (ListView) mFragmentLauout.findViewById(R.id.fragmain_namager_lv);
        mTvPhoneMemory = (TextView) mFragmentLauout.findViewById(R.id.frag_download_phoneMemoryInfo_tv);
        mTvAlready = (TextView) mFragmentLauout.findViewById(R.id.frag_download_already);
        mTvAvailable = (TextView) mFragmentLauout.findViewById(R.id.frag_download_available);

    }

    @Override
    protected void initData() {
        new Handler(getContext().getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                IManagerPresenter presenter = getManagerPresenter();
                presenter.replaceData();
            }
        });

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
        mGameInfoBeenList.clear();
        mGameInfoBeenList.addAll(list);
        mMyLvGameManagerAdatpter.notifyDataSetChanged();
    }

    @Override
    public void showPhoneMemoryInfo(String phoneMemoryInfo) {
        mTvPhoneMemory.setText(phoneMemoryInfo);
    }

    @Override
    public void showDownloadAlready(String downloadAlreadyinfo) {
        mTvAlready.setText(downloadAlreadyinfo);
    }

    @Override
    public void showDownloadAvailable(String downloadAvailableinfo) {
        mTvAvailable.setText(downloadAvailableinfo);
    }

    @Override
    public IManagerPresenter getManagerPresenter() {
        ABasePresenter presenter = getPresenter(ManagerFragmentPresenter.TAG);
        return (IManagerPresenter) presenter;
    }

    @Override
    public void setManagerPresenter(IManagerPresenter managerPresenter) {
        addPresenter((ABasePresenter) managerPresenter);
    }

    @Override
    public void onStart() {
        super.onStart();
        ABasePresenter downLoadPresenter = (ABasePresenter) getDownLoadPresenter();
        downLoadPresenter.onStart(getContext());
        setDownLoadListener();
        isPause = false;
    }

    @Override
    public void onPause() {
        super.onPause();
        removeDownLoadListener();
        isPause = true;
    }

    //    @Override
//    public void onStop() {
//        super.onStop();
//        ABasePresenter downLoadPresenter = (ABasePresenter) getDownLoadPresenter();
//        downLoadPresenter.onStop(getContext());
//    }

    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            DownLoadPresenter downLoadPresenter = new DownLoadPresenter(getContext());
            this.setDownLoadPresenter(downLoadPresenter);
            Context context = getContext();
            if (context != null) {
                downLoadPresenter.onStart(context);
//                setDownLoadListener();
            }

        } else {
            DownLoadPresenter downLoadPresenter = (DownLoadPresenter) getDownLoadPresenter();

            if (downLoadPresenter != null) {
                downLoadPresenter.onStop(getContext());
            }
        }
    }

    @Override
    public void setDownLoadListener() {
        mDownLoadListener = new MyDownLoadService.IDownLoadListener() {
            @Override
            public void wail(String url) {
                setItemDownloadStateWail(url);
            }

            @Override
            public void progress(String url, final int progre) {
                if (!isPause) {
                    setItemDownloadState(url, progre + "%",null);
                }
            }

            @Override
            public void completed(String url) {
                if (!isPause) {
                    String fileName = FileUtil.getFileName(url);
                    final String filePath = Constants.getSavePath(getContext()) + "/" + fileName;
                    setItemDownloadState(url, "完成", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            AppUtil.installApk(getContext(),filePath,true);
                        }
                    });
                }
            }

            @Override
            public void fail(final String url) {
                if (!isPause) {
                    setItemDownloadState(url, "重试", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            getDownLoadPresenter().addDownLoadTask(url);
                        }
                    });
                }
            }

            @Override
            public void speed(String url, final long speed) {
                if (!isPause) {
                    setItemDownloadStateSpeed(url, speed);
                }
            }

            @Override
            public void downloadedSize(String url, final long size) {
                {
                    setItemDownloadStateSize(url, size);
                }
            }
        };
        getDownLoadPresenter().setDownLoadListener(mDownLoadListener);
    }

    @Override
    public void removeDownLoadListener() {
        getDownLoadPresenter().removeDownLoadListener(mDownLoadListener);
    }

    private void setItemDownloadStateSpeed(String url, final long speed) {
        Handler handler = new Handler(getContext().getMainLooper());
        for (int i = 0; i < mGameInfoBeenList.size(); i++) {
            int itemViewType = mMyLvGameManagerAdatpter.getItemViewType(i);
            final SaveGameInfoBean bean = mGameInfoBeenList.get(i);
            if (bean.getDownload_url().equals(url) &&
                    i >= mLvGameManager.getFirstVisiblePosition() &&
                    i <= mLvGameManager.getLastVisiblePosition() &&
                    itemViewType == 1) {
                View itemView = mLvGameManager.getChildAt(i - mLvGameManager.getFirstVisiblePosition());
                final TextView mTvSpeed = (TextView) itemView.findViewById(R.id.item_download_tv_internetspeed);
                final TextView mTvDownloadState = (TextView) itemView.findViewById(R.id.item_download_tv_download_state);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        mTvDownloadState.setVisibility(View.GONE);
                        mTvSpeed.setVisibility(View.VISIBLE);
                        mTvSpeed.setText(FileUtil.formatDownLoadSpeed(speed));
//                        mTvDownloadState.setText(100000000+"");
                    }
                });
            }
        }
    }

    private void setItemDownloadStateSize(String url, final long size) {
        Handler handler = new Handler(getContext().getMainLooper());
        for (int i = 0; i < mGameInfoBeenList.size(); i++) {
            int itemViewType = mMyLvGameManagerAdatpter.getItemViewType(i);
            final SaveGameInfoBean bean = mGameInfoBeenList.get(i);
            if (bean.getDownload_url().equals(url) &&
                    i >= mLvGameManager.getFirstVisiblePosition() &&
                    i <= mLvGameManager.getLastVisiblePosition() &&
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

    private void setItemDownloadState(String url, final String stateStr, View.OnClickListener onClickListener) {
        Handler handler = new Handler(getContext().getMainLooper());
        for (int i = 0; i < mGameInfoBeenList.size(); i++) {
            int itemViewType = mMyLvGameManagerAdatpter.getItemViewType(i);
            final SaveGameInfoBean bean = mGameInfoBeenList.get(i);
            if (bean.getDownload_url().equals(url) &&
                    i >= mLvGameManager.getFirstVisiblePosition() &&
                    i < mLvGameManager.getLastVisiblePosition() &&
                    itemViewType == 1) {
                View itemView = mLvGameManager.getChildAt(i - mLvGameManager.getFirstVisiblePosition());
                final TextView tvState = (TextView) itemView.findViewById(R.id.item_download_tv_state);
                tvState.setOnClickListener(onClickListener);
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
        Handler handler = new Handler(getContext().getMainLooper());
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
                        mTvSpeed.setText("0KB/s");
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
