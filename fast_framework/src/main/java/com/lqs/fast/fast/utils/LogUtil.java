package com.lqs.fast.fast.utils;

import android.util.Log;

/**
 * Created by dell on 2016/9/29.
 */

public final class LogUtil {
    public static void d(String tag,String msg)
    {
        Log.d(tag, msg);
    }
    public static void d(String tag,Exception e){
        String msg = e.getMessage();
        d(tag,msg);
    }

    public static void d(Object o,Exception e){
        Class<?> oClass = o.getClass();
        String tag = oClass.getSimpleName() + ":" + oClass.getName();
        String msg = e.getMessage();
        d(tag,msg);
    }
    public static void d()
    {
        // 获得当前类名
        String tag = Thread.currentThread() .getStackTrace()[2].getClassName();
        // 获得当前方法名
        String method = Thread.currentThread() .getStackTrace()[2].getMethodName();
//        System.out.println("class name: " + clazz + " Method Name " + method);
        d(tag,"" + method);
    }
}
