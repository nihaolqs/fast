package com.lqs.fast.gamestore.fragment;

import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.lqs.fast.fast.base_ui.ABaseFragment;
import com.lqs.fast.fast.utils.MvpUtils;
import com.lqs.fast.gamestore.R;
import com.lqs.fast.gamestore.bean.GameInfoBean;
import com.lqs.fast.gamestore.model.ManagerFragmentModel;
import com.lqs.fast.gamestore.presenter.IManagerPresenter;
import com.lqs.fast.gamestore.presenter.ManagerFragmentPresenter;
import com.lqs.fast.gamestore.view.IManagerView;

import java.util.List;

/**
 * Created by dell on 2016/10/14.
 */

public class ManagerFragment extends ABaseFragment<ManagerFragment,String> implements IManagerView{
    public static final String TAG = "ManagerFragment";
    private ListView mLvGameManager;
    private TextView mTvPhoneMemory;
    private TextView mTvAlready;
    private TextView mTvAvailable;


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
        mLvGameManager.setAdapter();
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
    public void showDownLoadedGame(List<GameInfoBean> list) {

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
}
