package com.lqs.fast.gamestore.fragment;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.lqs.fast.fast.base.presenter.ABasePresenter;
import com.lqs.fast.fast.base_ui.ABaseFragment;
import com.lqs.fast.gamestore.R;
import com.lqs.fast.gamestore.activity.GameDetailActivity;
import com.lqs.fast.gamestore.adatpter.MyLvKfListAdatpter;
import com.lqs.fast.gamestore.bean.KfGame;
import com.lqs.fast.gamestore.model.KfGamePageFragmentModel;
import com.lqs.fast.gamestore.presenter.IKfGamePresenter;
import com.lqs.fast.gamestore.presenter.KfGamePageFragmentPresenter;
import com.lqs.fast.gamestore.view.IKfGameView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell on 2016/10/10.
 */

public class KFGamePageFragment extends ABaseFragment<KFGamePageFragment,String> implements IKfGameView{
    public static final String TAG = "KFGamePageFragment";
    private ListView mLvKfList;
    private ArrayList<KfGame.KfListBean> mKfList = new ArrayList<>();
    private MyLvKfListAdatpter mMyLvKfListAdatpter;

    @Override
    protected void initMvp() {
        KfGamePageFragmentPresenter presenter = new KfGamePageFragmentPresenter(getContext());
        KfGamePageFragmentModel model = new KfGamePageFragmentModel();
        this.setKfGamePresenter(presenter);
        presenter.setKfGameView(this);
        presenter.setKfGameModel(model);
        model.setKfGamePresenter(presenter);
    }

    @Override
    protected void initUI() {
        mLvKfList = (ListView) mFragmentLauout.findViewById(R.id.lv_frag_kaifu_page_kflist);
        mMyLvKfListAdatpter = new MyLvKfListAdatpter(mKfList, getContext());
        mLvKfList.setAdapter(mMyLvKfListAdatpter);
       }

    @Override
    protected void initData() {
        IKfGamePresenter kfGamePresenter = getKfGamePresenter();
        kfGamePresenter.replaceData();
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.frag_kaifu_page;
    }

    @Override
    public String getViewTag() {
        return TAG;
    }

    @Override
    public void showKfGameList(List<KfGame.KfListBean> kflist) {
        this.mKfList.addAll(kflist);
        mMyLvKfListAdatpter.notifyDataSetChanged();
    }

    @Override
    public IKfGamePresenter getKfGamePresenter() {
        IKfGamePresenter presenter = (IKfGamePresenter) getPresenter(KfGamePageFragmentPresenter.TAG);
        return presenter;
    }

    @Override
    public void setKfGamePresenter(IKfGamePresenter kfGamePresenter) {
        ABasePresenter presenter = (ABasePresenter) kfGamePresenter;
        addPresenter(presenter);
    }

    @Override
    public String getUrl() {
        return mData;
    }
}
