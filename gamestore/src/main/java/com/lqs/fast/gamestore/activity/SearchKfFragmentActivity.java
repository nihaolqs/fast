package com.lqs.fast.gamestore.activity;

import android.support.v4.app.Fragment;

import com.lqs.fast.gamestore.R;
import com.lqs.fast.gamestore.app.Constants;
import com.lqs.fast.gamestore.fragment.SearchGameFragment;

/**
 * Created by dell on 2016/10/24.
 */

public class SearchKfFragmentActivity extends ABaseSingleFragmentActivity{
    @Override
    protected Fragment getFragment() {
        SearchGameFragment fragment = SearchGameFragment.getInstance(SearchGameFragment.class, Constants.Type.SEARCH_KF);
        return fragment;
    }

    @Override
    protected int getContainerViewId() {
        return R.id.fl_container;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initUI() {

    }

    @Override
    protected int getLayoutResID() {
        return R.layout.act_kaifu_search_ll;
    }
}
