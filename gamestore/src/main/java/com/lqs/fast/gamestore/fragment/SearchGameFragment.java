package com.lqs.fast.gamestore.fragment;

import android.content.Context;
import android.content.Intent;
import android.text.InputType;
import android.text.method.CharacterPickerDialog;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.lqs.fast.fast.base.presenter.ABasePresenter;
import com.lqs.fast.fast.base_ui.ABaseFragment;
import com.lqs.fast.fast.utils.AppUtil;
import com.lqs.fast.gamestore.R;
import com.lqs.fast.gamestore.activity.GameDetailActivity;
import com.lqs.fast.gamestore.adatpter.MyHotSearchAdatpter;
import com.lqs.fast.gamestore.adatpter.MyLvSearchedAdatpter;
import com.lqs.fast.gamestore.app.Constants;
import com.lqs.fast.gamestore.bean.GameInfoBean;
import com.lqs.fast.gamestore.bean.KfGameSearch;
import com.lqs.fast.gamestore.bean.SearchGame;
import com.lqs.fast.gamestore.model.SearchGameFragmentModle;
import com.lqs.fast.gamestore.presenter.DownLoadPresenter;
import com.lqs.fast.gamestore.presenter.IDownloadPresenter;
import com.lqs.fast.gamestore.presenter.ISearchGamePresenter;
import com.lqs.fast.gamestore.presenter.SearchGameFragmentPresenter;
import com.lqs.fast.gamestore.service.MyDownLoadService;
import com.lqs.fast.gamestore.view.IDownLoadView;
import com.lqs.fast.gamestore.view.ISearchGameView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell on 2016/10/11.
 */

public class SearchGameFragment extends ABaseFragment<SearchGameFragment, String> implements ISearchGameView, IDownLoadView {
    public static final String TAG = "SearchGameFragment";

    private ArrayList<GameInfoBean> mHotCearchGame = new ArrayList<>();
    private ArrayList<GameInfoBean> mSearchedGame = new ArrayList<>();
    private GridView mGvHotSearch;
    private ListView mLvSearched;
    private MyHotSearchAdatpter mMyHotSearchAdatpter;
    private MyLvSearchedAdatpter mMyLvSearchedAdatpter;
    private LinearLayout mLlsearFragMoren;
    private TextView mTvSearFragNothing;
    private ImageView mIvSearchFragSearch;
    private EditText mEtSearchContent;
    private MyDownLoadService.IDownLoadListener mDownloadListenrt;

    @Override
    protected void initMvp() {
        SearchGameFragmentPresenter presenter = new SearchGameFragmentPresenter(getContext());
        SearchGameFragmentModle modle = null;
        if (mData.equals(Constants.Type.SEARCH_GAME)) {

            modle = new SearchGameFragmentModle<SearchGame>();
        } else {
            modle = new SearchGameFragmentModle<KfGameSearch>();
        }
        this.setSearchGamePresenter(presenter);
        presenter.setSerachGameView(this);
        presenter.setSearchGameModel(modle);
        modle.setSearchGamePresenter(presenter);
        DownLoadPresenter downLoadPresenter = new DownLoadPresenter(getContext());
        this.setDownLoadPresenter(downLoadPresenter);

        setDownLoadListener();
        downLoadPresenter.onStart(getContext());

    }


    @Override
    protected void initUI() {
        initGvHotSearch();

        initLvSearched();

        initFindView();

        initOnClick();

    }

    private void initOnClick() {
        mIvSearchFragSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ISearchGamePresenter presenter = getSearchGamePresenter();
                presenter.searchGame();
            }
        });
    }

    private void initFindView() {
        mLlsearFragMoren = (LinearLayout) mFragmentLauout.findViewById(R.id.searFrag_moren_ll);
        mTvSearFragNothing = (TextView) mFragmentLauout.findViewById(R.id.searFrag_nothing_tv);

        mIvSearchFragSearch = (ImageView) mFragmentLauout.findViewById(R.id.searchFrag_search);

        mEtSearchContent = (EditText) mFragmentLauout.findViewById(R.id.search_content);

        mEtSearchContent.setInputType(InputType.TYPE_NULL);

        mEtSearchContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEtSearchContent.setInputType(InputType.TYPE_CLASS_TEXT);
                mEtSearchContent.requestFocus();
            }
        });


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ABasePresenter downLoadPresenter = (ABasePresenter) getDownLoadPresenter();
        downLoadPresenter.onStop(getContext());
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {

            ABasePresenter downLoadPresenter = (ABasePresenter) getDownLoadPresenter();
            if (downLoadPresenter != null) {
//                setDownLoadListener();
                downLoadPresenter.onStart(getContext());
            }
        } else {
            ABasePresenter downLoadPresenter = (ABasePresenter) getDownLoadPresenter();
            if (downLoadPresenter != null) {
                downLoadPresenter.onStop(getContext());
            }
        }
    }

//    @Override
//    public void onResume() {
//        super.onResume();
//
//    }

    @Override
    public void onStart() {
        super.onStart();

//        setDownLoadListener();
    }

    @Override
    public void onStop() {
        super.onStop();
        removeDownLoadListener();
    }

    private void initLvSearched() {
        mLvSearched = (ListView) mFragmentLauout.findViewById(R.id.frag_search_lv);
        mMyLvSearchedAdatpter = new MyLvSearchedAdatpter(mSearchedGame, getContext(), getDownLoadPresenter());
        mLvSearched.setAdapter(mMyLvSearchedAdatpter);
        mLvSearched.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Context context = getContext();
                Intent intent = new Intent(context, GameDetailActivity.class);
                GameInfoBean gameInfoBean = mSearchedGame.get(position - mLvSearched.getHeaderViewsCount());
                intent.putExtra(GameDetailActivity.GUID_KEY,gameInfoBean.getGuid());
                context.startActivity(intent);
            }
        });
    }

    private void initGvHotSearch() {
        mGvHotSearch = (GridView) mFragmentLauout.findViewById(R.id.gv_frag_search_hotsearch);
        mMyHotSearchAdatpter = new MyHotSearchAdatpter(mHotCearchGame, getContext());
        mGvHotSearch.setAdapter(mMyHotSearchAdatpter);
        mGvHotSearch.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                GameInfoBean gameInfoBean = mHotCearchGame.get(position);
                String game_name = gameInfoBean.getGame_name();
                mEtSearchContent.setText(game_name);
                ISearchGamePresenter presenter = getSearchGamePresenter();
                presenter.searchGame();
            }
        });
    }


    @Override
    protected void initData() {
        ISearchGamePresenter presenter = (ISearchGamePresenter) getPresenter(SearchGameFragmentPresenter.TAG);
        presenter.replaceData();
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.frag_search;
    }

    @Override
    public String getViewTag() {
        return TAG;
    }

    @Override
    public void showHotSearchGameList(List<GameInfoBean> gameList) {
        mLlsearFragMoren.setVisibility(View.VISIBLE);
        mTvSearFragNothing.setVisibility(View.GONE);
        mHotCearchGame.clear();
        mHotCearchGame.addAll(gameList);
        mMyHotSearchAdatpter.notifyDataSetChanged();
    }

    @Override
    public void showSearchedGameList(List<GameInfoBean> gameList) {
        mLlsearFragMoren.setVisibility(View.GONE);
        mSearchedGame.clear();
        mSearchedGame.addAll(gameList);
        mMyLvSearchedAdatpter.notifyDataSetChanged();
    }

    @Override
    public void showSearchedError() {
        mLlsearFragMoren.setVisibility(View.VISIBLE);
        mTvSearFragNothing.setVisibility(View.VISIBLE);
    }

    @Override
    public void showSearchHistory(List<String> strList) {

    }

    @Override
    public void setSearchGamePresenter(ISearchGamePresenter searchGamePresenter) {
        ABasePresenter presenter = (ABasePresenter) searchGamePresenter;
        addPresenter(presenter);
    }

    @Override
    public ISearchGamePresenter getSearchGamePresenter() {
        ISearchGamePresenter presenter = (ISearchGamePresenter) getPresenter(SearchGameFragmentPresenter.TAG);
        return presenter;
    }

    @Override
    public String getSearchType() {
        return mData;
    }

    @Override
    public String getSearchContent() {
        return mEtSearchContent.getText().toString();
    }

    @Override
    public void setDownLoadListener() {
        IDownloadPresenter downLoadPresenter = getDownLoadPresenter();
        mDownloadListenrt = new MyDownLoadService.IDownLoadListener() {
            @Override
            public void wail(String url) {
                initItemState(url, "等待", null);
            }

            @Override
            public void progress(String url, int progre) {
                initItemState(url, "" + progre, null);
            }

            @Override
            public void completed(final String url) {
                initItemState(url, "安装", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String filePath = Constants.getSavePath(getContext()) + "/" + MyDownLoadService.getFileName(url);
                        AppUtil.installApk(getContext(), filePath, Constants.FILEPROVIDER);
                    }
                });

            }

            @Override
            public void fail(final String url) {
                initItemState(url, "重试", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        IDownloadPresenter presenter = getDownLoadPresenter();
                        presenter.addDownLoadTask(url);
                    }
                });
            }

            @Override
            public void speed(String url, long speed) {

            }

            @Override
            public void downloadedSize(String url, long size) {

            }
        };
        downLoadPresenter.setDownLoadListener(mDownloadListenrt);
    }

    @Override
    public void removeDownLoadListener() {
        getDownLoadPresenter().removeDownLoadListener(mDownloadListenrt);
    }

    private void initItemState(String url, final String strState, View.OnClickListener onClickListener) {
        for (int i = mLvSearched.getFirstVisiblePosition(); i <= mLvSearched.getLastVisiblePosition(); i++) {
            GameInfoBean gameInfoBean = mSearchedGame.get(i);
            if (gameInfoBean.getDownload_url().equals(url)) {
                View childAt = mLvSearched.getChildAt(i - mLvSearched.getFirstVisiblePosition());
                final TextView itemState = (TextView) childAt.findViewById(R.id.item_select_tv_state);
                itemState.setOnClickListener(onClickListener);
                itemState.post(new Runnable() {
                    @Override
                    public void run() {
                        itemState.setText(strState + "%");
                    }
                });

            }
        }
    }

    @Override
    public void setDownLoadPresenter(IDownloadPresenter downLoadPresenter) {
//        DownLoadPresenter presenter = new DownLoadPresenter(getContext());
        addPresenter((ABasePresenter) downLoadPresenter);
    }

    @Override
    public IDownloadPresenter getDownLoadPresenter() {
        ABasePresenter presenter = getPresenter(DownLoadPresenter.TAG);
        return (IDownloadPresenter) presenter;
    }
}
