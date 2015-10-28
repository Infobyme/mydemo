package com.ty.demo.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import com.ty.demo.aidl.IPerson;
import com.ty.demo.entity.Person;

/**
 * Created by Administrator on 2015/10/19.
 */
public class PersonService extends Service {

    private IPerson.Stub iPerson=new Person();

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.v("TAG","service onBind");
        return iPerson;
    }
}
