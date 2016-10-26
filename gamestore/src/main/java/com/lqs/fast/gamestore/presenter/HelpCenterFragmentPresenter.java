package com.lqs.fast.gamestore.presenter;

import android.content.Context;

import com.lqs.fast.fast.base.presenter.ABasePresenter;
import com.lqs.fast.fast.base.view.ABaseView;
import com.lqs.fast.fast.utils.SpUtil;
import com.lqs.fast.gamestore.app.Constants;
import com.lqs.fast.gamestore.fragment.HelpCenterFragment;
import com.lqs.fast.gamestore.view.IHelpCenterView;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by dell on 2016/10/25.
 */

public class HelpCenterFragmentPresenter extends ABasePresenter implements IHelpCenterPresenter {
    public static final String TAG = "HelpCenterFragmentPresenter";
    private Context mContext;

    public HelpCenterFragmentPresenter(Context context) {
        super();
        this.mContext = context;
    }

    @Override
    public String getPresenterTag() {
        return TAG;
    }

    @Override
    public void repalceHelpCenterView() {
        Map<String, Serializable> spData = SpUtil.readSp(mContext, Constants.Settings.SP_NAME,
                Constants.Settings.AUTOMATIC_INSTALL, Constants.Settings.DELETE_INSTALLPACKAGE,
                Constants.Settings.SEND_MESSAGE);
        Boolean autoInstall = (Boolean) spData.get(Constants.Settings.AUTOMATIC_INSTALL);
        Boolean deleteInstallPackage = (Boolean) spData.get(Constants.Settings.DELETE_INSTALLPACKAGE);
        Boolean sendMessage = (Boolean) spData.get(Constants.Settings.SEND_MESSAGE);
        IHelpCenterView helpCenterView = getHelpCenterView();
        if (deleteInstallPackage != null) {
            helpCenterView.showDeleteSwitch(deleteInstallPackage);
        } else {
            helpCenterView.showDeleteSwitch(false);
        }

        if (helpCenterView != null) {
            helpCenterView.showInstallSwitch(autoInstall);
        } else {
            helpCenterView.showInstallSwitch(false);
        }

        if (sendMessage != null) {
            helpCenterView.showMessageSwitch(sendMessage);
        } else {
            helpCenterView.showMessageSwitch(false);
        }
//        helpCenterView.showInstallSwitch(autoInstall);
//        helpCenterView.showMessageSwitch(sendMessage);
    }

    @Override
    public void settingMessageSwitch(boolean isSwitch) {
        SpUtil.editSp(mContext, Constants.Settings.SEND_MESSAGE, isSwitch, Constants.Settings.SP_NAME);
        repalceHelpCenterView();
    }

    @Override
    public void settingInstallSwitch(boolean isSwitch) {
        SpUtil.editSp(mContext, Constants.Settings.AUTOMATIC_INSTALL, isSwitch, Constants.Settings.SP_NAME);
        repalceHelpCenterView();
    }

    @Override
    public void settingDeleteSwitch(boolean isSwitch) {
        SpUtil.editSp(mContext, Constants.Settings.DELETE_INSTALLPACKAGE, isSwitch, Constants.Settings.SP_NAME);
        repalceHelpCenterView();
    }

    @Override
    public void checkLastVersion() {
        IHelpCenterView helpCenterView = getHelpCenterView();
        helpCenterView.showUpdate(false);
    }

    @Override
    public void feedback() {

    }

    @Override
    public IHelpCenterView getHelpCenterView() {
        ABaseView view = getView(HelpCenterFragment.TAG);
        return (IHelpCenterView) view;
    }

    @Override
    public void setHelpCenterView(IHelpCenterView helpCenterView) {
        addView((ABaseView) helpCenterView);
    }
}
