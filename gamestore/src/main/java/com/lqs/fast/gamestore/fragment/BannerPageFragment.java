package com.lqs.fast.gamestore.fragment;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;

import com.lqs.fast.fast.base_ui.ABaseFragment;
import com.lqs.fast.fast.utils.ImageUtils;
import com.lqs.fast.gamestore.R;
import com.lqs.fast.gamestore.activity.GameDetailActivity;
import com.lqs.fast.gamestore.bean.GameInfoBean;

/**
 * Created by dell on 2016/10/8.
 */

public class BannerPageFragment extends ABaseFragment<BannerPageFragment,GameInfoBean>{

    private ImageView mAdImage;
    public static final String TAG = "BannerPageFragment";

    @Override
    protected void initMvp() {

    }

    @Override
    protected void initUI() {
        mAdImage = (ImageView) mFragmentLauout.findViewById(R.id.iv_frag_ad_banner);
        mAdImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = getContext();
                Intent intent = new Intent(context, GameDetailActivity.class);
                intent.putExtra(GameDetailActivity.GUID_KEY,mData.getGuid());
                context.startActivity(intent);
            }
        });
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
