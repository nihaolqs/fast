package com.lqs.fast.gamestore.fragment;

import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lqs.fast.fast.base.presenter.ABasePresenter;
import com.lqs.fast.fast.base_ui.ABaseFragment;
import com.lqs.fast.fast.utils.ImageUtils;
import com.lqs.fast.gamestore.R;
import com.lqs.fast.gamestore.adatpter.MyRvGameImageAdatpter;
import com.lqs.fast.gamestore.bean.GameDetail;
import com.lqs.fast.gamestore.model.GameDetailFragmentModel;
import com.lqs.fast.gamestore.presenter.GameDetailFragmentPresenter;
import com.lqs.fast.gamestore.presenter.IGameDetailPresenter;
import com.lqs.fast.gamestore.view.IGameDetailView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lin on 2016/10/13.
 */

public class GameDetailFragment extends ABaseFragment<GameDetailFragment, String> implements IGameDetailView {
    public static final String TAG = "GameDetailFragment";
    static final int INTRODUCTION_DEFAULTLINE = 3;

    private ArrayList<String> mGameImageList = new ArrayList<>();

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
    private MyRvGameImageAdatpter mRvGameImageAdatpter;
    private TextView mGameInfoTvMore;

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
        mRvGameImageAdatpter = new MyRvGameImageAdatpter(getContext(),mGameImageList);
        mRvGameImage.setLayoutManager(new StaggeredGridLayoutManager(1,
                StaggeredGridLayoutManager.HORIZONTAL));
        mRvGameImage.setAdapter(mRvGameImageAdatpter);

        mRvGameImageAdatpter.setItemOnclickListener(new MyRvGameImageAdatpter.ItemOnClickListener() {
            @Override
            public void itemOnclick(View view, int position) {
                GameDetailImagesDialogFragment dialogFragment = new GameDetailImagesDialogFragment(mGameImageList);
                FragmentManager fm = getChildFragmentManager();
                dialogFragment.show(fm,"tag");
//                dialogFragment.setViewPageItem(position);
            }
        });

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

        mGameInfoTvMore = (TextView) mFragmentLauout.findViewById(R.id.gameinfo_tv_more);

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
    public void showGameDetail(GameDetail.GameDeatilBean bean) {

//        private ImageView mIvGameIcon;
        String game_logo = bean.getGame_logo();
        ImageUtils.LoadImage(mIvGameIcon,game_logo);

//        private RelativeLayout mTvDiscount;
        String gamediscount = bean.getGamediscount();
        if(!TextUtils.isEmpty(gamediscount)){
            mTvDiscount.setVisibility(View.VISIBLE);
            mTvDiscount2.setText(gamediscount);
        }else{
            mTvDiscount.setVisibility(View.GONE);
        }

//        private RecyclerView mRvGameImage;

        List<String> atlas_img = bean.getAtlas_img();
        if(atlas_img.size() > 0){
            mRvGameImage.setVisibility(View.VISIBLE);
            mGameImageList.clear();
            mGameImageList.addAll(atlas_img);
            mRvGameImageAdatpter.notifyDataSetChanged();
        }else {
            mRvGameImage.setVisibility(View.GONE);
        }

//        private TextView mTvGameShowName;

        String show_name = bean.getShow_name();
        mTvGameShowName.setText(show_name);

//        private TextView mTvOneWord;

        String one_game_info = bean.getOne_game_info();
        mTvOneWord.setText(one_game_info);

//        private TextView mTvDiscount2;
//        private TextView mTvSendMoney;

//        private TextView mTvIntroduction;

        String game_info = bean.getGame_info();
        mTvIntroduction.setText(game_info);
        int lineCount = mTvIntroduction.getLineCount();
        if(lineCount >= INTRODUCTION_DEFAULTLINE){
            mGameInfoTvMore.setVisibility(View.VISIBLE);
            mGameInfoTvMore.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mTvIntroduction.setEllipsize(null);
                    mTvIntroduction.setSingleLine(false);
                    mGameInfoTvMore.setVisibility(View.GONE);
                }
            });
        }else{
            mGameInfoTvMore.setVisibility(View.GONE);
        }

//        private TextView mTvGameSize;

        String gamesize = bean.getGamesize();
        mTvGameSize.setText(gamesize);

//        private TextView mTvGameVersion;

        String version = bean.getVersion();
        mTvGameVersion.setText(version);

//        private TextView mTvAndroidSystem;

        String requirement = bean.getRequirement();
        mTvAndroidSystem.setText(requirement);

//        private TextView mTvGameType;

        String typename = bean.getTypename();
        mTvGameType.setText(typename);

//        private TextView mTvGameLanguage;

        String language = bean.getLanguage();
        mTvGameLanguage.setText("中文");

//        private TextView mTvOnlineTime;

        String online_time = bean.getOnline_time();
        mTvOnlineTime.setText(online_time);

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
