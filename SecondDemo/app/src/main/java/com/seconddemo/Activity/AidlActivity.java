package com.seconddemo.Activity;

import android.app.Activity;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;
import android.widget.Toast;

import com.seconddemo.R;
import com.ty.demo.aidl.IPerson;

/**
 * Created by Administrator on 2015/10/28.
 */
public class AidlActivity extends Activity {

    IPerson iPerson;

    ServiceConnection comm=new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {

            iPerson= IPerson.Stub.asInterface(service);

            if (iPerson!=null){
                try {
                    Toast.makeText(AidlActivity.this, "获取值成功" + iPerson.getValue(), Toast.LENGTH_SHORT).show();
                } catch (RemoteException e) {
                    e.printStackTrace();
                    Toast.makeText(AidlActivity.this,"获取值失败",Toast.LENGTH_SHORT).show();
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

        findViewById(R.id.aidl_reder).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                bindService(new Intent("forServiceAidl"),comm, Service.BIND_AUTO_CREATE);
            }
        });
    }
}
