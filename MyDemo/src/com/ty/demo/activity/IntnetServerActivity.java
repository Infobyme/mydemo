package com.ty.demo.activity;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ty.demo.R;
import com.ty.demo.base.BaseActivity;
import com.ty.demo.service.UpImageLoadService;

/**
 * Created by Administrator on 2015/8/3.
 */
public class IntnetServerActivity extends BaseActivity {


    public static final String UPLOAD_RESTULT = "com.ty.demo.UPLOAD_RESTULT";


    private LinearLayout rootLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intentservice);
        initView();

        IntentFilter filter=new IntentFilter(UPLOAD_RESTULT);

        registerReceiver(upLoadImageReceiver,filter);
    }

    @Override
    public void initView() {

        rootLayout = (LinearLayout) findViewById(R.id.intentservice_root);

    }

    private int i = 0;

    /**
     * 添加一个IntentService
     * @param veiw
     */
    public void addTask(View veiw) {

        String path = "/sdcard/images/" + (++i) + ".png";

        UpImageLoadService.startUpLoadImage(baseContext, path);

        TextView tv = new TextView(this);

        tv.setText(path + " is uploading....");
        tv.setTag(path);

        rootLayout.addView(tv);


    }


    BroadcastReceiver upLoadImageReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {


                String path = intent.getStringExtra(UpImageLoadService.EXTRA_IMG_PATH);

                TextView tv = (TextView) rootLayout.findViewWithTag(path);

                tv.setText(path + " upload success");

            Toast.makeText(baseContext,"BroadcastReceiver",Toast.LENGTH_SHORT);
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(upLoadImageReceiver);
    }
}
