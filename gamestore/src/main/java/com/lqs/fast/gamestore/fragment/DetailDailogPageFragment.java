package com.lqs.fast.gamestore.fragment;

import android.view.View;
import android.widget.ImageView;

import com.lqs.fast.fast.base_ui.ABaseFragment;
import com.lqs.fast.fast.utils.ImageUtils;
import com.lqs.fast.gamestore.R;

/**
 * Created by dell on 2016/10/17.
 */

public class DetailDailogPageFragment extends ABaseFragment<DetailDailogPageFragment,String>{

    private ImageView mIvImage;

    @Override
    protected void initMvp() {

    }

    @Override
    protected void initUI() {
        mIvImage = (ImageView) mFragmentLauout.findViewById(R.id.iv_dialog_image);
        ImageUtils.LoadImage(mIvImage, mData);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected int getLayoutResId() {
        return R.layout.item_detaildialog_images;
    }

    @Override
    public String getViewTag() {
        return null;
    }
}
