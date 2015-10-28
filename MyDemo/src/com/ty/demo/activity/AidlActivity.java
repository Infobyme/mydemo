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
import com.ty.demo.entity.Person;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2015/10/19.
 */
public class AidlActivity extends BaseActivity implements View.OnClickListener {


    @Bind(R.id.aidl_bind)
    Button aidlBind;
    @Bind(R.id.aidl_unbind)
    Button aidlUnbind;

    private IPerson iPerson;

    public ServiceConnection conn=new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            iPerson= IPerson.Stub.asInterface(service);

            if (iPerson!=null){
                try {
                    iPerson.setValue("Sercie AIDL");
                    Toast.makeText(baseContext,"赋值成功",Toast.LENGTH_SHORT).show();
                } catch (RemoteException e) {
                    e.printStackTrace();
                    Toast.makeText(baseContext,"赋值失败",Toast.LENGTH_SHORT).show();
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
        setContentView(R.layout.activity_aidl);
        ButterKnife.bind(this);
        initView();
    }

    @Override
    public void initView() {

        aidlBind.setOnClickListener(this);
        aidlUnbind.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.aidl_bind:
                Intent intent=new Intent("forServiceAidl");
                bindService(intent,conn, Service.BIND_AUTO_CREATE);
                break;
            case R.id.aidl_unbind:
                unbindService(conn);
                break;
        }

    }
}
