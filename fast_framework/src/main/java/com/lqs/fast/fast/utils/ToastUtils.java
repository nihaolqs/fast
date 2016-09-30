package com.lqs.fast.fast.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by dell on 2016/9/30.
 */

public final class ToastUtils {
    private ToastUtils(){};

    public static void makeToast(Context context,String msg){
        Context appContext = context.getApplicationContext();
        Toast.makeText(appContext,msg,Toast.LENGTH_SHORT).show();
    }

    public static void makeToast(Context context,int resID){
        Context appContext = context.getApplicationContext();
        Toast.makeText(appContext,resID,Toast.LENGTH_SHORT).show();
    }
}
