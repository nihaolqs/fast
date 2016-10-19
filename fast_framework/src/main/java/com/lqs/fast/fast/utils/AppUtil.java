package com.lqs.fast.fast.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.widget.Toast;

import java.util.List;

/**
 * Created by dell on 2016/10/19.
 */

public final class AppUtil {
    private AppUtil() {
    }

    public static boolean checkApkInstalled(Context context, String packageName) {
        final PackageManager packageManager = context.getPackageManager();
        List<PackageInfo> pinfo = packageManager.getInstalledPackages(0);
        if (pinfo != null) {
            for (int i = 0; i < pinfo.size(); i++) {
                String pn = pinfo.get(i).packageName;
                if (pn.equals(packageName)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void startAPk(Context context, String appPackageName) {
        try {
            Intent intent = context.getPackageManager().getLaunchIntentForPackage(appPackageName);
            context.startActivity(intent);
        } catch (Exception e) {
            Toast.makeText(context, "没有安装", Toast.LENGTH_SHORT).show();
        }
    }

    private void installApk(Context context, String filePath, boolean isOpen) {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        i.setDataAndType(Uri.parse("file://" + filePath), "application/vnd.android.package-archive");
        context.startActivity(i);
        if (isOpen) {
            android.os.Process.killProcess(android.os.Process.myPid());
        }
    }

    public static void unInstallApk(Context context, String packageName) {
        Uri uri = Uri.parse("package:" + packageName);

        Intent intent = new Intent(Intent.ACTION_DELETE, uri);
        context.startActivity(intent);
    }
}
