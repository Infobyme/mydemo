package com.ty.demo.activity;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.ty.demo.R;
import com.ty.demo.aidl.IPerson;
import com.ty.demo.base.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2015/7/31.
 */
public class SingleInstanceActivity extends BaseActivity {

    @Bind(R.id.singleinstance_get)
    Button singleinstanceGet;

    private IPerson person;

    ServiceConnection conn=new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            person=IPerson.Stub.asInterface(service);

            if (person!=null){
                try {
                    Toast.makeText(baseContext,"获取值成功"+ person.getValue(),Toast.LENGTH_SHORT).show();
                } catch (RemoteException e) {
                    e.printStackTrace();
                    Toast.makeText(baseContext,"获取值失败",Toast.LENGTH_SHORT).show();
                }
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singleinstance);
        ButterKnife.bind(this);

        singleinstanceGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bindService(new Intent("forServiceAidl"),conn, Service.BIND_AUTO_CREATE);
            }
        });
    }

    @Override
    public void initView() {

    }
}
