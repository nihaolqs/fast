package com.lqs.fast.gamestore.view;

/**
 * Created by dell on 2016/10/25.
 */

public interface IHelpCenterView {
    void showMessageSwitch(boolean isSwitch);
    void showInstallSwitch(boolean isSwitch);
    void showDeleteSwitch(boolean isSwitch);
    void showVersion(String version);
    void showUpdate(boolean isUpdate);
}
