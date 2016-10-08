package com.lqs.fast.gamestore.fragment;

import android.view.View;
import android.widget.ImageView;

import com.lqs.fast.fast.base_ui.ABaseFragment;
import com.lqs.fast.fast.utils.ImageUtils;
import com.lqs.fast.gamestore.R;
import com.lqs.fast.gamestore.bean.GameInfoBean;

/**
 * Created by dell on 2016/10/8.
 */

public class BannerPageFragment extends ABaseFragment<BannerPageFragment,GameInfoBean>{

    private ImageView mAdImage;
    public static final String TAG = "BannerPageFragment";

    @Override
    protected void initUI() {
        mAdImage = (ImageView) mFragmentLauout.findViewById(R.id.iv_frag_ad_banner);
    }

    @Override
    protected void initData() {
        String ad_img = mData.getAd_img();
        ImageUtils.LoadImage(mAdImage,ad_img);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_ad_banner;
    }

    @Override
    public String getViewTag() {
        return TAG;
    }
}
