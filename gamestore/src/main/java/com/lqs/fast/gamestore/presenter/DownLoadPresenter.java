package com.lqs.fast.gamestore.presenter;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;

import com.activeandroid.query.Select;
import com.lqs.fast.fast.base.presenter.ABasePresenter;
import com.lqs.fast.gamestore.bean.SaveGameInfoBean;
import com.lqs.fast.gamestore.service.MyDownLoadService;
import com.lqs.fast.gamestore.view.IDownLoadView;

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

    @Override
    public String getPresenterTag() {
        return TAG;
    }

    @Override
    public void addDownLoadTask(String url) {
        mMybinder.addDownLoadTask(url);
    }

    @Override
    public void setDownLoadListener(MyDownLoadService.IDownLoadListener listener) {
        this.mDownloadListener = listener;
        if (mMybinder != null) {
            mMybinder.setDownLoadListener(mDownloadListener);
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
        try {
            bean.delete();
        } catch (Exception e) {
        }
        bean.save();
    }

    @Override
    public void onStart(Context context) {
        super.onStart(context);
        mServiceIntent = new Intent(context, MyDownLoadService.class);
        context.startService(mServiceIntent);

        mSeriveConn = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                DownLoadPresenter.this.mMybinder = (MyDownLoadService.MyBinder) service;
                mMybinder.setDownLoadListener(mDownloadListener);
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {

            }
        };
        context.bindService(mServiceIntent, mSeriveConn, BIND_AUTO_CREATE);
    }

    @Override
    public void onStop(Context context) {
        super.onStop(context);
        context.unbindService(mSeriveConn);
    }
}
