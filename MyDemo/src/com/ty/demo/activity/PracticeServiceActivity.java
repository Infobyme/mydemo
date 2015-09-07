package com.ty.demo.activity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;

import com.ty.demo.R;
import com.ty.demo.base.BaseActivity;
import com.ty.demo.service.PracticeService;

/**
 * Created by Administrator on 2015/8/3.
 */
public class PracticeServiceActivity extends BaseActivity implements View.OnClickListener{


    private PracticeService.MyBinder myBinder;

    ServiceConnection connection=new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            myBinder= (PracticeService.MyBinder) service;
            myBinder.startDownload();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_practiceservice);
        initView();
    }

    @Override
    public void initView() {
        findViewById(R.id.start_service).setOnClickListener(this);
        findViewById(R.id.stop_service).setOnClickListener(this);
        findViewById(R.id.bind_service).setOnClickListener(this);
        findViewById(R.id.unbind_service).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.start_service:
                Intent startIntent=new Intent(this, PracticeService.class);
                startService(startIntent);
            break;
            case R.id.stop_service:
                Intent stopIntent=new Intent(this, PracticeService.class);
                stopService(stopIntent);
            break;
            case R.id.bind_service:
                Intent bindIntent=new Intent(this,PracticeService.class);
                bindService(bindIntent,connection,BIND_AUTO_CREATE);
                break;
            case R.id.unbind_service:
                unbindService(connection);
                break;
        }
    }


}
