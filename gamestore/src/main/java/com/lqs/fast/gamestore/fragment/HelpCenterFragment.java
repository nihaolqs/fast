package com.lqs.fast.gamestore.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lqs.fast.fast.base_ui.ABaseFragment;
import com.lqs.fast.fast.utils.ToastUtils;
import com.lqs.fast.gamestore.R;
import com.lqs.fast.gamestore.view.IHelpCenterView;

/**
 * Created by dell on 2016/10/25.
 */

public class HelpCenterFragment extends ABaseFragment<HelpCenterFragment, String> implements IHelpCenterView {
    public static final String TAG = "HelpCenterFragment";
    private LinearLayout mLlSendMessage;
    private LinearLayout mLlAutoMaticInstall;
    private LinearLayout mLlDeleteInstallPackage;
    private LinearLayout mLlUpdate;
    private LinearLayout mLlFeedBack;
    private ImageView mIvMessageSwitch;
    private ImageView mIvInstallSwitch;
    private ImageView mIvDeleteSwitch;
    private TextView mTvVersion;

    @Override
    protected void initMvp() {

    }

    @Override
    protected void initUI() {
        findView();
    }

    private void findView() {
        mLlSendMessage = (LinearLayout) mFragmentLauout.findViewById(R.id.ll_fra_helpcenter_send_message);
        mLlAutoMaticInstall = (LinearLayout) mFragmentLauout.findViewById(R.id.ll_fragment_helpcenter_automatic_install);
        mLlDeleteInstallPackage = (LinearLayout) mFragmentLauout.findViewById(R.id.ll_fragment_helpcenter_delete_installpackage);
        mLlUpdate = (LinearLayout) mFragmentLauout.findViewById(R.id.ll_fragment_helpcenter_update);
        mLlFeedBack = (LinearLayout) mFragmentLauout.findViewById(R.id.ll_fragment_helpcenter_feedback);
        mIvMessageSwitch = (ImageView) mFragmentLauout.findViewById(R.id.iv_frag_helpcenter_message_switch);
        mIvInstallSwitch = (ImageView) mFragmentLauout.findViewById(R.id.iv_frag_helpcenter_automatic_install_switch);
        mIvDeleteSwitch = (ImageView) mFragmentLauout.findViewById(R.id.iv_frag_helpcenter_delete_installpackage_switch);
        mTvVersion = (TextView) mFragmentLauout.findViewById(R.id.tv_fragment_helpcenter_version);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected int getLayoutResId() {
        return R.layout.frag_helpcenter;
    }

    @Override
    public String getViewTag() {
        return TAG;
    }

    @Override
    public void showMessageSwitch(boolean isSwitch) {

    }

    private void showSwitch(boolean isSwitch, ImageView switchImageView) {
        if(isSwitch){
            switchImageView.setImageResource(R.mipmap.helpcenter_switch_on);
        }else {
            switchImageView.setImageResource(R.mipmap.helpcenter_switch_off);
        }
    }

    @Override
    public void showInstallSwitch(boolean isSwitch) {
        showSwitch(isSwitch, mIvInstallSwitch);
    }

    @Override
    public void showDeleteSwitch(boolean isSwitch) {
        showSwitch(isSwitch, mIvDeleteSwitch);
    }

    @Override
    public void showVersion(String version) {
        mTvVersion.setText(version);
    }

    @Override
    public void showUpdate(boolean isUpdate) {
        if(isUpdate){

        }else {
            ToastUtils.makeToast(getContext(),"已经是最新版本");
        }
    }
}
