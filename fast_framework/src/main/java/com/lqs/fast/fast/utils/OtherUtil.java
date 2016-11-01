package com.lqs.fast.fast.utils;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by dell on 2016/10/31.
 */

public class OtherUtil {
    /****************
     *
     * 发起添加群流程。QQ群的 key 为： -xxx
     * 调用 joinQQGroup(-xxx) 即可发起手Q客户端申请加群
     *
     * @param key 由官网生成的key
     * @return 返回true表示呼起手Q成功，返回fals表示呼起失败
     ******************/
    public static boolean joinQQGroup(Context context, String key) {
        Intent intent = new Intent();
        intent.setData(Uri.parse("mqqopensdkapi://bizAgent/qm/qr?url=http%3A%2F%2Fqm.qq.com%2Fcgi-bin%2Fqm%2Fqr%3Ffrom%3Dapp%26p%3Dandroid%26k%3D" + key));
        // 此Flag可根据具体产品需要自定义，如设置，则在加群界面按返回，返回手Q主界面，不设置，按返回会返回到呼起产品界面    //intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        try {
            context.startActivity(intent);
            return true;
        } catch (Exception e) {
            // 未安装手Q或安装的版本不支持
            return false;
        }
    }

    public static void telPhone(Context context, String phoneNumber) {
        try {
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:+" + phoneNumber));
            if (ActivityCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                context.startActivity(intent);
            }

        } catch (Exception e) {
            Log.e("SampleApp", "Failed to invoke call", e);
        }
    }

    public static void HideStatusBar(Activity activity)
    {
        //隐藏标题
        activity.requestWindowFeature(Window.FEATURE_NO_TITLE);

        //定义全屏参数
        int flag = WindowManager.LayoutParams.FLAG_FULLSCREEN;
        //获得窗口对象
        Window myWindow = activity.getWindow();
        //设置Flag标识
        myWindow.setFlags(flag, flag);
    }


}
