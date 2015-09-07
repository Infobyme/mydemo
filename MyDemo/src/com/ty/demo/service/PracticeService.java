package com.ty.demo.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by Administrator on 2015/8/17.
 */
public class PracticeService extends Service {

    private static final String TAG="TAG";

    private MyBinder myBinder=new MyBinder();

    @Override
    public void onCreate() {
        super.onCreate();
        Log.v(TAG,"onCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.v(TAG,"onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.v(TAG,"onDestroy");
        super.onDestroy();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return myBinder;
    }

   public class MyBinder extends Binder{
        public void startDownload(){
            Log.v(TAG,"startDownload()");
        }
    }
}
