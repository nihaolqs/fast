package com.lqs.fast.fast.utils;

/**
 * Created by dell on 2016/10/19.
 */

public final class FileUtil {
    private FileUtil(){}

    public static String getFileName(String pathandname) {

        int start = pathandname.lastIndexOf("/");
        int end = pathandname.lastIndexOf(".");
        if (start != -1 && end != -1) {
            return pathandname.substring(start + 1);
        } else {
            return null;
        }
    }

    public static String formatDownLoadSpeed(long speed){
        StringBuffer sb = new StringBuffer();
        double kb = speed / 1024.0; //KB
        double m = kb / 1024;  //MB
        if (m>1){
            sb.append(m).append("M");
        }else{
            sb.append(kb).append("KB");
        }
        return sb.toString();
    }

    public static String formatSize(long size){
        StringBuffer sb = new StringBuffer();
        double k = size / 1024.0;
        double m = k / 1024;
        double g = m / 1024;
        if(g > 1){
            sb.append(g).append("G");
        }else if(m > 1){
            sb.append(m).append("M");
        }else{
            sb.append(k).append("KB");
        }

        return sb.toString();
    }
}
