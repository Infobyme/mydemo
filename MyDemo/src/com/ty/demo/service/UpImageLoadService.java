package com.ty.demo.service;


import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.ty.demo.activity.IntnetServerActivity;

/**
 * Created by Administrator on 2015/8/3.
 */
public class UpImageLoadService extends IntentService {


    public static final String  ACTION_UP_IMAGE="com.ty.demo.action.UP_IMAGE";
    public static final String  EXTRA_IMG_PATH="com.ty.demo.param.IMAGE_PATH";

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public UpImageLoadService() {
        super("UpImageLoadService");
    }


    @Override
    public void onCreate() {
        super.onCreate();

        Log.v("TAG", "onCreate");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        Log.v("TAG", "onDestroy");
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        if (intent!=null){

            final String action=intent.getAction();

            if (ACTION_UP_IMAGE.equals(action)){
                final String path=intent.getStringExtra(EXTRA_IMG_PATH);

                handleUpLoadImage(path);
            }

        }

    }


    /**
     * 上传的方法
     * @param paht  图片的地址
     */
    private void handleUpLoadImage(String path){

        Log.e("TAG","handleUpLoadImage");

        try {
            Thread.sleep(3000);

            Intent newIntent=new Intent(IntnetServerActivity.UPLOAD_RESTULT);
            newIntent.putExtra(EXTRA_IMG_PATH,path);

            sendBroadcast(newIntent);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 开启这个服务
     * @param context 上下文
     * @param path 图片的地址
     */
    public static void startUpLoadImage(Context context, String path){

        Log.e("TAG","startUpLoadImage");
        Intent intent=new Intent(context,UpImageLoadService.class);
        intent.setAction(ACTION_UP_IMAGE);
        intent.putExtra(EXTRA_IMG_PATH,path);
        context.startService(intent);

    }
}
