package com.lqs.fast.gamestore.presenter;

import android.Manifest;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.IBinder;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

import com.activeandroid.query.Delete;
import com.activeandroid.query.Select;
import com.lqs.fast.fast.base.presenter.ABasePresenter;
import com.lqs.fast.fast.base_ui.ABaseBannerFragment;
import com.lqs.fast.fast.utils.FileUtil;
import com.lqs.fast.gamestore.app.Constants;
import com.lqs.fast.gamestore.bean.SaveGameInfoBean;
import com.lqs.fast.gamestore.service.MyDownLoadService;
import com.lqs.fast.gamestore.view.IDownLoadView;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import static android.content.Context.BIND_AUTO_CREATE;

/**
 * Created by dell on 2016/10/19.
 */

public class DownLoadPresenter extends ABasePresenter implements IDownloadPresenter {
    private MyDownLoadService.MyBinder mMybinder;
    private Intent mServiceIntent;
    private ServiceConnection mSeriveConn;
    public static final String TAG = "DownLoadPresenter";
    private MyDownLoadService.IDownLoadListener mDownloadListener;
    //    private boolean isBinder;
    private Context mContext;
    private int MY_PERMISSIONS_REQUEST_READ_CONTACTS = 1;

    public DownLoadPresenter(Context context) {
        this.mContext = context;
    }

    @Override
    public String getPresenterTag() {
        return TAG;
    }

    @Override
    public void addDownLoadTask(String url) {

        if (ContextCompat.checkSelfPermission((Activity) mContext, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED
                || ContextCompat.checkSelfPermission((Activity) mContext,
                Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions((Activity) mContext,
                    new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, MY_PERMISSIONS_REQUEST_READ_CONTACTS);
        } else {
            if (mMybinder != null) {
                mMybinder.addDownLoadTask(url);
            }
        }

    }

    @Override
    public void setDownLoadListener(MyDownLoadService.IDownLoadListener listener) {
        this.mDownloadListener = listener;
        if (mMybinder != null) {
            mMybinder.setDownLoadListener(mDownloadListener);
        }
    }

    @Override
    public void removeDownLoadListener(MyDownLoadService.IDownLoadListener listener) {
        if (mMybinder != null) {
            mMybinder.removeDownLoadListener(mDownloadListener);
        }
    }

    @Override
    public void pauseDownLoadTask(String url) {
        if (mMybinder != null) {
            mMybinder.pauseDownLoadTask(url);
        }
    }

    @Override
    public void continueDownLoadTast(String url) {
        if (mMybinder != null) {
            mMybinder.continueDownLoadTast(url);
        }
    }

    @Override
    public void cancelDownLoadTask(String url) {
        if (mMybinder != null) {
            mMybinder.cancelDownLoadTask(url);
        }
    }

    @Override
    public int getDownLoadState(String url) {
        if (mMybinder != null) {
            int state = mMybinder.getDownLoadState(url);
            return state;
        }
        return 0;
    }


    @Override
    public void saveGameInfo(SaveGameInfoBean bean) {
        new Delete().from(SaveGameInfoBean.class).where("Url = ?", bean.getDownload_url()).execute();
        bean.save();
    }

    @Override
    public void checkFileExists(String urlStr, ICheckListener listener) {
//        String fileName = FileUtil.getFileName(urlStr);
//        File file = new File(Constants.getSavePath(mContext) + "/" + fileName);
//        boolean exists = file.exists();
//        URL url = null;
//        try {
//            url = new URL(urlStr);
//            URLConnection cc = url.openConnection();
//            long length = cc.getContentLength();
//            long length1 = file.length();
//            if (exists && length == length1) {
//                return true;
//            }
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return exists;
        if (mMybinder != null) {
            mMybinder.checkFile(urlStr, listener);
        }
    }

    @Override
    public void onStart(Context context) {
        super.onStart(context);
        if (context != null) {
            this.mContext = context;

            MyDownLoadService.MyBinder binder = MyDownLoadService.getBinder(mContext);
            if (binder != null) {
                this.mMybinder = binder;
                mMybinder.setDownLoadListener(mDownloadListener);
            } else {
                MyDownLoadService.addBinderListener(new MyDownLoadService.IBinderListener() {
                    @Override
                    public void onBinded() {
                        MyDownLoadService.MyBinder binder = MyDownLoadService.getBinder(mContext);
                        if (binder != null) {
                            DownLoadPresenter.this.mMybinder = binder;
                            mMybinder.setDownLoadListener(mDownloadListener);
                        }
                    }
                });
            }

//            else{
//                mServiceIntent = new Intent(context, MyDownLoadService.class);
//                context.startService(mServiceIntent);
//
//                mSeriveConn = new ServiceConnection() {
//                    @Override
//                    public void onServiceConnected(ComponentName name, IBinder service) {
//                        DownLoadPresenter.this.mMybinder = (MyDownLoadService.MyBinder) service;
//                        mMybinder.setDownLoadListener(mDownloadListener);
//                    }
//
//                    @Override
//                    public void onServiceDisconnected(ComponentName name) {
//
//                    }
//                };
//
//                    context.bindService(mServiceIntent, mSeriveConn, BIND_AUTO_CREATE);
//            }

        }
    }

    @Override
    public void onStop(Context context) {
        super.onStop(context);
//        if (isBinder) {
//            context.unbindService(mSeriveConn);
//            isBinder = false;
//        }
    }


}
