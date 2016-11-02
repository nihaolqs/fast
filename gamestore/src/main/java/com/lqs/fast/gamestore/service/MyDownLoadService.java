package com.lqs.fast.gamestore.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Binder;
import android.os.Environment;
import android.os.IBinder;
import android.util.Log;

import com.lqs.fast.fast.utils.AppUtil;
import com.lqs.fast.fast.utils.SingleFileDownLoadUtils;
import com.lqs.fast.fast.utils.SpUtil;
import com.lqs.fast.gamestore.app.Constants;
import com.lqs.fast.gamestore.presenter.ICheckListener;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static android.os.Environment.getDownloadCacheDirectory;

public class MyDownLoadService extends Service {

    public static final int WAIT = 1;  //等待下载
    public static final int PROGRESS = 2;  //下载进行中
    public static final int COMPLETED = 3;  //下载完成
    public static final int FAIL = 4;  //下载失败
    public static final int MAXTHREAD = 2;

    private final ExecutorService mFixedThreadPool;
    private HashMap<String, Integer> mDownLoadStateMap = new HashMap<>();
    private HashMap<String, MyDownLoadService.DownLoadTask> mDawnLoadTaskMap = new HashMap<>();

    private MyDownLoadService.IDownLoadListener mListener;

    public MyDownLoadService() {

        mFixedThreadPool = Executors.newFixedThreadPool(MAXTHREAD);
    }


    private void addDownLoadTask(String url) {
        MyDownLoadService.DownLoadTask downLoadTask = new MyDownLoadService.DownLoadTask(url);
        mFixedThreadPool.execute(downLoadTask);
    }

    private void setListener(MyDownLoadService.IDownLoadListener listener) {
        this.mListener = listener;
    }

    private int getDownLoadState(String url) {
        Integer integer = mDownLoadStateMap.get(url);
        if (integer == null) {
            return 0;
        }
        return integer;
    }


    public interface IDownLoadListener {
        void wail(String url);  //等待

        void progress(String url, int progre);  //下载中

        void completed(String url);  //完成

        void fail(String url);  //失败

        void speed(String url, long speed);  //下载速度

        void downloadedSize(String url, long size);  //已经下载大小
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

        private String mFileUrl;
        private boolean isCancel;

        public DownLoadTask(String url) {
            this.mFileUrl = url;
            mDownLoadStateMap.put(url, WAIT);
            mDawnLoadTaskMap.put(url, this);
            mListener.wail(url);
        }

        public void threadPause() {
            try {
                Thread.currentThread().wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public void threadContinue() {
            Thread.currentThread().notify();
        }

        public void threadCancel() {
            this.isCancel = true;
        }


        @Override
        public void run() {
            InputStream is = null;
            OutputStream os = null;
            String fileName = getFileName(mFileUrl);
//
            String filePath = Constants.SAVEPATH + "/" + fileName;
            File file = new File(filePath);
            try {
                mDownLoadStateMap.put(mFileUrl, PROGRESS);
                mListener.progress(mFileUrl, 0);
                URL url = new URL(mFileUrl);
                URLConnection cc = url.openConnection();
                long length = cc.getContentLength();
                is = url.openStream();


                os = new FileOutputStream(filePath);
                byte[] bs = new byte[1024];
                int len = -1;
                long sum = 0;
                int point = 0;
                long oldTime = 0;
                while (-1 != (len = is.read(bs))) {
                    os.write(bs, 0, len);
                    sum += len;

                    if (isCancel) {
                        mListener.fail(mFileUrl);
                        return;
                    }

                    long l = System.currentTimeMillis();

                    long speed = len * 1000 / (l - oldTime);

                    mListener.speed(mFileUrl, speed);

                    mListener.downloadedSize(mFileUrl, sum);

//                    Log.d("run",sum + "/" + length);
                    point = (int) ((sum * 100) / length);
                    mListener.progress(mFileUrl, point);

                }
                mListener.progress(mFileUrl, 100);
                mListener.completed(mFileUrl);
                mDownLoadStateMap.put(mFileUrl, COMPLETED);
                Boolean isAutoInstall = (Boolean) SpUtil.readSp(MyDownLoadService.this, Constants.Settings.SP_NAME, Constants.Settings.AUTOMATIC_INSTALL);
                if (isAutoInstall != null && isAutoInstall == true) {   //自动安装
                    AppUtil.installApk(MyDownLoadService.this, filePath, true);
                }


            } catch (MalformedURLException e) {
                mListener.fail(mFileUrl);
                mDownLoadStateMap.put(mFileUrl, FAIL);
                file.delete();
                e.printStackTrace();
            } catch (IOException e) {
                mListener.fail(mFileUrl);
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


    @Override
    public IBinder onBind(Intent intent) {
        return new MyBinder();
    }


    public class MyBinder extends Binder {
        public void setDownLoadListener(MyDownLoadService.IDownLoadListener listener) {
            MyDownLoadService.this.setListener(listener);
        }

        public void addDownLoadTask(String url) {
            MyDownLoadService.this.addDownLoadTask(url);
        }

        public void pauseDownLoadTask(String url) {
            DownLoadTask downLoadTask = mDawnLoadTaskMap.get(url);
            downLoadTask.threadPause();
        }

        public void continueDownLoadTast(String url) {
            DownLoadTask downLoadTask = mDawnLoadTaskMap.get(url);
            downLoadTask.threadContinue();
        }

        public void cancelDownLoadTask(String url) {
            DownLoadTask downLoadTask = mDawnLoadTaskMap.get(url);
            downLoadTask.threadCancel();
        }

        public int getDownLoadState(String url) {
            int state = MyDownLoadService.this.getDownLoadState(url);
            return state;
        }
    }

    public void getLength(String url, ICheckListener listener) {
        MyCheckTask myCheckTask = new MyCheckTask(url, listener);
        mFixedThreadPool.execute(myCheckTask);
    }

    class MyCheckTask implements Runnable {
        private String mUrl;
        private ICheckListener mListener;

        public MyCheckTask(String url, ICheckListener listener) {
            this.mUrl = url;
            this.mListener = listener;
        }

        @Override
        public void run() {

            String fileName = getFileName(mUrl);
            String filepath = Constants.SAVEPATH + "/" + fileName;
            File file = new File(filepath);
            boolean exists = file.exists();
            if (!exists) {
                mListener.check(false);
                return;
            }
            long length = file.length();
            try {
                URL url = new URL(mUrl);
                URLConnection connection = url.openConnection();
                int contentLength = connection.getContentLength();
                if (length == contentLength) {
                   mListener.check(true);
                    return;
                }
            } catch (MalformedURLException e) {
                mListener.check(false);
            } catch (IOException e) {
                e.printStackTrace();
                mListener.check(false);
            }

        }
    }

}
