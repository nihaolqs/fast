package com.lqs.fast.gamestore.activity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.lqs.fast.fast.utils.OtherUtil;
import com.lqs.fast.gamestore.service.MyDownLoadService;

/**
 * Created by lin on 2016/10/5.
 */

public abstract class ABaseActivity extends AppCompatActivity {

    private ServiceConnection mDownloadConne;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        OtherUtil.HideStatusBar(this);
        setContentView(getLayoutResID());
        binderDownloadService();
    }

    private void binderDownloadService() {
        Intent intent = new Intent(this, MyDownLoadService.class);
        startService(intent) ;
        mDownloadConne = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                MyDownLoadService.setBinder(ABaseActivity.this, (MyDownLoadService.MyBinder) service);
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {

            }
        };
        bindService(intent, mDownloadConne,BIND_AUTO_CREATE);
    }

    protected abstract void initData();

    protected abstract void initUI();

    protected abstract int getLayoutResID();


    @Override
    protected void onDestroy() {
        super.onDestroy();
        MyDownLoadService.removeBinder(this);
        unbindService(mDownloadConne);
    }
}
