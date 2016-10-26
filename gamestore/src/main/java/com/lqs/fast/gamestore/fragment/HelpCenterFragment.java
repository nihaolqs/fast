package com.lqs.fast.gamestore.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lqs.fast.fast.base.presenter.ABasePresenter;
import com.lqs.fast.fast.base_ui.ABaseFragment;
import com.lqs.fast.fast.utils.ToastUtils;
import com.lqs.fast.gamestore.R;
import com.lqs.fast.gamestore.presenter.HelpCenterFragmentPresenter;
import com.lqs.fast.gamestore.presenter.IHelpCenterPresenter;
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
    private boolean isAutoSentMessage;
    private boolean isAutoInstall;
    private boolean isAutoDeleteInstalled;

    @Override
    protected void initMvp() {
        HelpCenterFragmentPresenter presenter = new HelpCenterFragmentPresenter(getContext());
        this.setHelpCenterPresenter(presenter);
        presenter.setHelpCenterView(this);
    }

    @Override
    protected void initUI() {
        findView();
        initSetOnClick();
    }

    private void initSetOnClick() {
        mLlAutoMaticInstall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IHelpCenterPresenter presenter = getHelpCenterPresenter();
                presenter.settingInstallSwitch(!isAutoInstall);
            }
        });

        mLlDeleteInstallPackage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IHelpCenterPresenter presenter = getHelpCenterPresenter();
                presenter.settingDeleteSwitch(!isAutoDeleteInstalled);
            }
        });
        mLlSendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IHelpCenterPresenter presenter = getHelpCenterPresenter();
                presenter.settingMessageSwitch(!isAutoSentMessage);
            }
        });

        mLlUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IHelpCenterPresenter presenter = getHelpCenterPresenter();
                presenter.checkLastVersion();
            }
        });
        mLlFeedBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IHelpCenterPresenter presenter = getHelpCenterPresenter();
                presenter.feedback();
            }
        });

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
        this.isAutoSentMessage = isSwitch;
        showSwitch(isSwitch,mIvMessageSwitch);
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
        this.isAutoInstall = isSwitch;
        showSwitch(isSwitch, mIvInstallSwitch);
    }

    @Override
    public void showDeleteSwitch(boolean isSwitch) {
        this.isAutoDeleteInstalled = isSwitch;
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

    @Override
    public IHelpCenterPresenter getHelpCenterPresenter() {
        ABasePresenter presenter = getPresenter(HelpCenterFragmentPresenter.TAG);
        return (IHelpCenterPresenter) presenter;
    }

    @Override
    public void setHelpCenterPresenter(IHelpCenterPresenter helpCenterPresenter) {
        addPresenter((ABasePresenter) helpCenterPresenter);
    }
}
