package com.lqs.fast.gamestore.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class MyDownLoadService extends Service {
    public MyDownLoadService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
