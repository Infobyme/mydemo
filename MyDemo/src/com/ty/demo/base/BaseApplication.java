package com.ty.demo.base;

import android.app.Application;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2015/10/15.
 */
public class BaseApplication extends Application {

    private BaseApplication application;
    @Override
    public void onCreate() {
        super.onCreate();
        application=this;
    }
}
