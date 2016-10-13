package com.lqs.fast.gamestore.fragment;

import android.view.View;
import android.widget.ImageView;

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
    }

    private void initFindView() {
        ImageView mIvGameIcon = (ImageView) mFragmentLauout.findViewById(R.id.gameinfo_iv_gameicon);
        mFragmentLauout.findViewById(R.id.gameinfo_tv_gamename)
        mFragmentLauout.findViewById(R.id.gameinfo_tv_oneword)
        mFragmentLauout.findViewById(R.id.gameinfo_tv_discount)
        mFragmentLauout.findViewById(R.id.gameinfo_tv_discount2)
        mFragmentLauout.findViewById(R.id.gameinfo_tv_send_money)
        mFragmentLauout.findViewById(R.id.)
        mFragmentLauout.findViewById(R.id.)
        mFragmentLauout.findViewById(R.id.)
        mFragmentLauout.findViewById(R.id.)
        mFragmentLauout.findViewById(R.id.)
        mFragmentLauout.findViewById(R.id.)
        mFragmentLauout.findViewById(R.id.)
        mFragmentLauout.findViewById(R.id.)
        mFragmentLauout.findViewById(R.id.)
        mFragmentLauout.findViewById(R.id.)
        mFragmentLauout.findViewById(R.id.)
    }

    @Override
    protected void initData() {

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
