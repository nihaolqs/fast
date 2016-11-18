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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

    private static HashMap<Context, MyBinder> mBinderMap = new HashMap<>();

    private static ArrayList<IBinderListener> sBinderListener = new ArrayList<>();

    //    private MyDownLoadService.IDownLoadListener mListener;
    private ArrayList<IDownLoadListener> mListeners = new ArrayList<>();
    private final ExecutorService mCachedThreadPool;

    public static MyBinder getBinder(Context context) {
        return mBinderMap.get(context);
    }

    public static void setBinder(Context context, MyBinder myBinder) {
        mBinderMap.put(context, myBinder);

        for (IBinderListener listener : sBinderListener
                ) {

            listener.onBinded();
        }

        sBinderListener.clear();
    }

    public static void removeBinder(Context context) {

        mBinderMap.remove(context);
    }

    public static void addBinderListener(IBinderListener binderListener) {
        sBinderListener.add(binderListener);
    }

    public MyDownLoadService() {

        mFixedThreadPool = Executors.newFixedThreadPool(MAXTHREAD);
        mCachedThreadPool = Executors.newCachedThreadPool();
    }


    private void addDownLoadTask(String url) {
        MyDownLoadService.DownLoadTask downLoadTask = new MyDownLoadService.DownLoadTask(url);
        mFixedThreadPool.execute(downLoadTask);
    }

    private void setListener(MyDownLoadService.IDownLoadListener listener) {
//        this.mListener = listener;
        synchronized (mListeners) {
            this.mListeners.add(listener);
        }
    }

    private void removeListener(IDownLoadListener listener) {
        synchronized (mListeners) {
            mListeners.remove(listener);
        }
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
        private boolean isPause = false;

        public DownLoadTask(String url) {
            this.mFileUrl = url;
            mDownLoadStateMap.put(url, WAIT);
            mDawnLoadTaskMap.put(url, this);
            for (IDownLoadListener listener : mListeners
                    ) {
                if (listener != null) {
                    listener.wail(url);
                }
            }
//            mListener.wail(url);
        }

        public boolean isPause() {
            return isPause;
        }


        public void threadPause() {

            isPause = true;

        }

        public void threadContinue() {
            synchronized (this) {
                isPause = false;
                this.notifyAll();
            }

        }

        public void threadCancel() {
            threadContinue();
            this.isCancel = true;

        }


        @Override
        public void run() {
            InputStream is = null;
            OutputStream os = null;
            String fileName = getFileName(mFileUrl);
//
            String filePath = Constants.getSavePath(MyDownLoadService.this) + "/" + fileName;
            File file = new File(filePath);
//            boolean isDirectory = file.isDirectory();
//            if(!isDirectory){
//                file.mkdirs();
//            }
            try {
                mDownLoadStateMap.put(mFileUrl, PROGRESS);
                for (IDownLoadListener listener : mListeners
                        ) {
                    if (listener != null) {
                        listener.progress(mFileUrl, 0);
                    }
                }
//                mListener.progress(mFileUrl, 0);
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
                long leng = 0;
                while (-1 != (len = is.read(bs))) {
                    synchronized (this) {
                        os.write(bs, 0, len);
                        sum += len;

                        if (isCancel) {
                            throw new IOException();
//                        for (IDownLoadListener listener : mListeners
//                                ) {
//                            listener.fail(mFileUrl);
//                        }
////                        mListener.fail(mFileUrl);
//                        return;
                        }

                        long l = System.currentTimeMillis();

                        long l1 = l - oldTime;
                        if (l1 > 100) {
                            long speed = (sum - leng) * 1000 / l1;
                            Log.e("speed", "" + speed);

//                    mListener.speed(mFileUrl, speed);

//                    mListener.downloadedSize(mFileUrl, sum);

//                    Log.d("run",sum + "/" + length);
                            point = (int) ((sum * 100) / length);
//                    mListener.progress(mFileUrl, point);
                            synchronized (mListeners) {
                                for (IDownLoadListener listener : mListeners
                                        ) {
//                        Log.e("listener",""+listener);
                                    if (listener != null) {
                                        listener.speed(mFileUrl, speed);
                                        listener.downloadedSize(mFileUrl, sum);
                                        listener.progress(mFileUrl, point);
                                    }
                                }
                            }
                            oldTime = l;
                            leng = sum;
                            Log.e("下载", mFileUrl + "  " + sum);
                        }
                        if (isPause) {
                            try {
                                this.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }

                }
//                mListener.progress(mFileUrl, 100);
//                mListener.completed(mFileUrl);
                for (IDownLoadListener listener : mListeners
                        ) {
                    if (listener != null) {
                        listener.progress(mFileUrl, 100);
                        listener.completed(mFileUrl);
                    }
                }
                mDownLoadStateMap.put(mFileUrl, COMPLETED);
                Boolean isAutoInstall = (Boolean) SpUtil.readSp(MyDownLoadService.this, Constants.Settings.SP_NAME, Constants.Settings.AUTOMATIC_INSTALL);
                if (isAutoInstall != null && isAutoInstall == true) {   //自动安装
                    AppUtil.installApk(MyDownLoadService.this, filePath, Constants.FILEPROVIDER);
                }


            } catch (MalformedURLException e) {
//                mListener.fail(mFileUrl);
                for (IDownLoadListener listener : mListeners
                        ) {
                    listener.fail(mFileUrl);
                }
                mDownLoadStateMap.put(mFileUrl, FAIL);
                file.delete();
                e.printStackTrace();
            } catch (IOException e) {
//                mListener.fail(mFileUrl);
                for (IDownLoadListener listener : mListeners
                        ) {
                    if (listener != null) {
                        listener.fail(mFileUrl);
                    }
                }
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

    public interface IBinderListener {
        void onBinded();
    }


    public class MyBinder extends Binder {
        public void setDownLoadListener(MyDownLoadService.IDownLoadListener listener) {
            MyDownLoadService.this.setListener(listener);
        }

        public void removeDownLoadListener(MyDownLoadService.IDownLoadListener listener) {
            MyDownLoadService.this.removeListener(listener);
        }

        public void addDownLoadTask(String url) {
            MyDownLoadService.this.addDownLoadTask(url);
        }

        public Boolean isPauseTask(String url) {
            DownLoadTask downLoadTask = mDawnLoadTaskMap.get(url);
            if (downLoadTask == null) {
                return null;
            } else {
                return downLoadTask.isPause();
            }
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
            if (downLoadTask != null) {
                downLoadTask.threadCancel();
            }
        }

        public int getDownLoadState(String url) {
            int state = MyDownLoadService.this.getDownLoadState(url);
            return state;
        }

        public void checkFile(String url, ICheckListener listener) {
            MyDownLoadService.this.checkFile(url, listener);
        }
    }

    public void checkFile(String url, ICheckListener listener) {
        MyCheckTask myCheckTask = new MyCheckTask(url, listener);
        mCachedThreadPool.execute(myCheckTask);
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
            String filepath = Constants.getSavePath(MyDownLoadService.this) + "/" + fileName;
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
                } else {
                    mListener.check(false);
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
