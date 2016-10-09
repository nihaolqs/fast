package com.lqs.fast.fast.utils;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by dell on 2016/10/9.
 */

public class SingleFileDownLoadUtils {
    public static final int WAIT = 1;  //等待下载
    public static final int PROGRESS = 2;  //下载进行中
    public static final int COMPLETED = 3;  //下载完成
    public static final int FAIL = 4;  //下载失败
    private Context mContext;
    private static SingleFileDownLoadUtils sInstance;
    private final ExecutorService mFixedThreadPool;
    private HashMap<String, Integer> mDownLoadStateMap = new HashMap<>();
    private HashMap<String, DownLoadTask> mDawnLoadTaskMap = new HashMap<>();

    private SingleFileDownLoadUtils(Context context, int maxThread) {
        this.mContext = context;
        mFixedThreadPool = Executors.newFixedThreadPool(maxThread);

    }

    public void addDownLoadTask(String url, IDownLoadListener listener) {
        DownLoadTask downLoadTask = new DownLoadTask(url, listener);
        mFixedThreadPool.execute(downLoadTask);


    }

    public void setListener(String url, IDownLoadListener listener) {
        DownLoadTask downLoadTask = mDawnLoadTaskMap.get(url);
        downLoadTask.setListener(listener);
    }

    public int getDownLoadState(String url) {
        Integer integer = mDownLoadStateMap.get(url);
        if (integer == null) {
            return 0;
        }
        return integer;
    }

    public static SingleFileDownLoadUtils getInstance(Context context, int maxThread) {
        if (sInstance == null) {
            sInstance = new SingleFileDownLoadUtils(context, maxThread);
        }
        return sInstance;
    }

    public interface IDownLoadListener {
        void wail();

        void progress(int progre);

        void completed();

        void fail();
    }

    public static String getFileName(String pathandname) {

        int start = pathandname.lastIndexOf("/");
        int end = pathandname.lastIndexOf(".");
        if (start != -1 && end != -1) {
            return pathandname.substring(start + 1);
        } else {
            return null;
        }
    }

    private class DownLoadTask implements Runnable {
        private IDownLoadListener mListener;
        private String mFileUrl;

        public DownLoadTask(String url, IDownLoadListener listener) {
            this.mListener = listener;
            this.mFileUrl = url;
            mDownLoadStateMap.put(url, WAIT);
            mDawnLoadTaskMap.put(url, this);
            mListener.wail();
        }

        public void setListener(IDownLoadListener listener) {
            this.mListener = listener;
        }

        @Override
        public void run() {
            InputStream is = null;
            OutputStream os = null;
            String fileName = getFileName(mFileUrl);
            String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
            String filePath = absolutePath + "/" + fileName;
            File file = new File(filePath);
            try {
                mDownLoadStateMap.put(mFileUrl, PROGRESS);
                mListener.progress(0);
                URL url = new URL(mFileUrl);
                URLConnection cc = url.openConnection();
                long length = cc.getContentLength();
                is = url.openStream();


                os = new FileOutputStream(filePath);
                byte[] bs = new byte[1024];
                int len = -1;
                long sum = 0;
                int point = 0;
                while (-1 != (len = is.read(bs))) {
                    os.write(bs, 0, len);
                    sum += len;
//                    if (sum * 100 / length > point) {
////                        point += 5;
                    Log.d("run",sum + "/" + length);
                        point = (int)((sum * 100) / length);
                        mListener.progress(point);
//                        point ++;
//                    }
                }
                mListener.progress(100);
                mListener.completed();
                mDownLoadStateMap.put(mFileUrl, COMPLETED);

            } catch (MalformedURLException e) {
                mListener.fail();
                mDownLoadStateMap.put(mFileUrl, FAIL);
                file.delete();
                e.printStackTrace();
            } catch (IOException e) {
                mListener.fail();
                mDownLoadStateMap.put(mFileUrl, FAIL);
                file.delete();
                e.printStackTrace();
            } finally {
                mDawnLoadTaskMap.remove(mFileUrl);
                if (is != null) {
                    try {
                        is.close();
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
                if (os != null) {
                    try {
                        os.flush();
                        os.close();
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}
