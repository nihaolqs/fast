package com.lqs.fast.gamestore.fragment;

import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.lqs.fast.fast.base.presenter.ABasePresenter;
import com.lqs.fast.fast.base_ui.ABaseFragment;
import com.lqs.fast.fast.utils.MvpUtils;
import com.lqs.fast.gamestore.R;
import com.lqs.fast.gamestore.adatpter.MyLvGameManagerAdatpter;
import com.lqs.fast.gamestore.bean.GameInfoBean;
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

public class ManagerFragment extends ABaseFragment<ManagerFragment,String> implements IManagerView,IDownLoadView{
    public static final String TAG = "ManagerFragment";
    private ListView mLvGameManager;
    private TextView mTvPhoneMemory;
    private TextView mTvAlready;
    private TextView mTvAvailable;

    private ArrayList<SaveGameInfoBean> mGameInfoBeenList = new ArrayList<>();
    @Override
    protected void initMvp() {
        ManagerFragmentModel managerFragmentModel = new ManagerFragmentModel();
        ManagerFragmentPresenter managerFragmentPresenter = new ManagerFragmentPresenter(getContext());
        MvpUtils.initMVP(managerFragmentModel,managerFragmentPresenter,this);
    }

    @Override
    protected void initUI() {
        initFindView();
        initListView();
    }

    private void initListView() {
        MyLvGameManagerAdatpter myLvGameManagerAdatpter = new MyLvGameManagerAdatpter(mGameInfoBeenList,getContext(),getDownLoadPresenter());
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

            }

            @Override
            public void progress(String url, int progre) {

            }

            @Override
            public void completed(String url) {

            }

            @Override
            public void fail(String url) {

            }

            @Override
            public void speed(String url, long speed) {

            }

            @Override
            public void downloadedSize(String url, long size) {

            }
        });
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
