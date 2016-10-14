package com.lqs.fast.gamestore.fragment;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lqs.fast.fast.base.model.ReplaceDataListener;
import com.lqs.fast.fast.base.presenter.ABasePresenter;
import com.lqs.fast.fast.base_ui.ABaseFragment;
import com.lqs.fast.gamestore.R;
import com.lqs.fast.gamestore.bean.GameDetail;
import com.lqs.fast.gamestore.model.GameDetailFragmentModel;
import com.lqs.fast.gamestore.model.IGameDetailModel;
import com.lqs.fast.gamestore.presenter.GameDetailFragmentPresenter;
import com.lqs.fast.gamestore.presenter.IGameDetailPresenter;
import com.lqs.fast.gamestore.view.IGameDetailView;

/**
 * Created by lin on 2016/10/13.
 */

public class GameDetailFragment extends ABaseFragment<GameDetailFragment, String> implements IGameDetailView {
    public static final String TAG = "GameDetailFragment";
    private ImageView mIvGameIcon;
    private RelativeLayout mTvDiscount;
    private RecyclerView mRvGameImage;
    private TextView mTvGameShowName;
    private TextView mTvOneWord;
    private TextView mTvDiscount2;
    private TextView mTvSendMoney;
    private TextView mTvIntroduction;
    private TextView mTvGameSize;
    private TextView mTvGameVersion;
    private TextView mTvAndroidSystem;
    private TextView mTvGameType;
    private TextView mTvGameLanguage;
    private TextView mTvOnlineTime;

    @Override
    protected void initMvp() {
        GameDetailFragmentPresenter presenter = new GameDetailFragmentPresenter(getContext());
        GameDetailFragmentModel model = new GameDetailFragmentModel();
        this.setGameDetailPresenter(presenter);
        presenter.setGameDetailView(this);
        presenter.setGameDetailModel(model);
        model.setGameDetailPresenter(presenter);
    }

    @Override
    protected void initUI() {
        initFindView();
        initRecyclerView();
    }

    private void initRecyclerView() {
        mRvGameImage.setAdapter();
    }

    private void initFindView() {
        mIvGameIcon = (ImageView) mFragmentLauout.findViewById(R.id.gameinfo_iv_gameicon);
        mTvDiscount = (RelativeLayout) mFragmentLauout.findViewById(R.id.gameinfo_tv_discount);
        mRvGameImage = (RecyclerView) mFragmentLauout.findViewById(R.id.rv_gameimage);
        mTvGameShowName = (TextView) mFragmentLauout.findViewById(R.id.gameinfo_tv_gamename);
        mTvOneWord = (TextView) mFragmentLauout.findViewById(R.id.gameinfo_tv_oneword);
        mTvDiscount2 = (TextView) mFragmentLauout.findViewById(R.id.gameinfo_tv_discount2);
        mTvSendMoney = (TextView) mFragmentLauout.findViewById(R.id.gameinfo_tv_send_money);
        mTvIntroduction = (TextView) mFragmentLauout.findViewById(R.id.gameinfo_tv_introduction);
//      TextViewragmentLauout.findViewById(R.id.gameinfo_tv_introduction);
        mTvGameSize = (TextView) mFragmentLauout.findViewById(R.id.gameinfo_tv_gamesize);
        mTvGameVersion = (TextView) mFragmentLauout.findViewById(R.id.gameinfo_tv_gameversion);
        mTvAndroidSystem = (TextView) mFragmentLauout.findViewById(R.id.gameinfo_tv_androidsystem);
        mTvGameType = (TextView) mFragmentLauout.findViewById(R.id.gameinfo_tv_gametype);
        mTvGameLanguage = (TextView) mFragmentLauout.findViewById(R.id.gameinfo_tv_gamelanguage);
        mTvOnlineTime = (TextView) mFragmentLauout.findViewById(R.id.gameinfo_tv_online_time);

    }

    @Override
    protected void initData() {
        IGameDetailPresenter presenter = getGameDetailPresenter();
        presenter.replaceData();
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.act_gameinfo;
    }

    @Override
    public String getViewTag() {
        return TAG;
    }

    @Override
    public void showGameDetail(GameDetail.GameDeatilBean gameDeatilBean) {

    }

    @Override
    public IGameDetailPresenter getGameDetailPresenter() {
        IGameDetailPresenter presenter = (IGameDetailPresenter) getPresenter(GameDetailFragmentPresenter.TAG);
        return presenter;
    }

    @Override
    public void setGameDetailPresenter(IGameDetailPresenter gameDetailPresenter) {
        addPresenter((ABasePresenter) gameDetailPresenter);
    }

    @Override
    public String getGuid() {
        return mData;
    }

}
