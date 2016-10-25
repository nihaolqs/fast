package com.lqs.fast.gamestore.presenter;

import com.lqs.fast.gamestore.view.IHelpCenterView;

/**
 * Created by dell on 2016/10/25.
 */

public interface IHelpCenterPresenter {
    void repalceHelpCenterView();
    void settingMessageSwitch(boolean isSwitch);
    void settingInstallSwitch(boolean isSwitch);
    void settingDeleteSwitch(boolean isSwitch);
    void checkLastVersion();
    void feedback();
    IHelpCenterView getHelpCenterView();
    void setHelpCenterView(IHelpCenterView helpCenterView);
}
