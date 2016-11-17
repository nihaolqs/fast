package com.lqs.fast.fast.utils;

import android.Manifest;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.compat.BuildConfig;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.webkit.MimeTypeMap;
import android.widget.Toast;

import java.io.File;
import java.util.List;

/**
 * Created by dell on 2016/10/19.
 */

public final class AppUtil {
    private static final int MY_PERMISSIONS_REQUEST_CALL_PHONE = 888;

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

    public static void installApk(Context context, String filePath, boolean isOpen) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
//        ComponentName comp;
//        if(android.os.Build.VERSION.SDK_INT < 23){
//            comp = new ComponentName("com.android.packageinstaller", "com.android.packageinstaller.PackageInstallerActivity");
//        }else{
//            comp = new ComponentName("com.google.android.packageinstaller", "com.android.packageinstaller.PackageInstallerActivity");
//        }
//        由于没有在Activity环境下启动Activity,设置下面的标签
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION | Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
        Uri contentUri = FileProvider.getUriForFile(context, "com.lqs.fast.gamestore.fileProvider", new File(filePath));
        intent.setDataAndType(contentUri, "application/vnd.android.package-archive");
//        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        intent.setComponent(comp);
        context.startActivity(intent);
//        if (isOpen) {
//            android.os.Process.killProcess(android.os.Process.myPid());
//        }
//        openFile(new File(filePath),context);
    }

    public static void unInstallApk(Context context, String packageName) {
        Uri uri = Uri.parse("package:" + packageName);

        Intent intent = new Intent(Intent.ACTION_DELETE, uri);
        context.startActivity(intent);
    }

    public static void openFile(File file, Context context) {
        Intent var2 = new Intent();
        var2.addFlags(268435456);
        var2.setAction("android.intent.action.VIEW");
        String var3 = getMIMEType(file);
        var2.setDataAndType(Uri.fromFile(file), var3);
        try {
            context.startActivity(var2);
        } catch (Exception var5) {
            var5.printStackTrace();
            Toast.makeText(context, "没有找到打开此类文件的程序", Toast.LENGTH_SHORT).show();
        }
    }

    public static String getMIMEType(File file) {
        String mineType = "";
        String fileName = file.getName();
        String var3 = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length()).toLowerCase();
        mineType = MimeTypeMap.getSingleton().getMimeTypeFromExtension(var3);
        return mineType;
    }
}
