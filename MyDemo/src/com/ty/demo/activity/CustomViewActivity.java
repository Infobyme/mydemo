package com.ty.demo.activity;

import com.ty.demo.R;
import com.ty.demo.view.CustomView;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;

public class CustomViewActivity extends Activity{
	
	private CustomView mView;
	int i=0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_customview);
		
		mView=(CustomView) findViewById(R.id.customview_view);
		
//		new Thread(mView).start();
		
		
//		new Thread(new Runnable() {
//			
//			@Override
//			public void run() {
//				
//				while (i<200) {
//					i++;
//					if (i==200) {
//						i=0;
//					}
//					try {
//						Thread.sleep(100);
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//					mHandler.sendEmptyMessage(0);
//					
//				}
//				
//			}
//		}).start();
		
	}
	
	Handler mHandler=new Handler(){
		public void handleMessage(android.os.Message msg) {
//			mView.setRadiu(i);
		};
	};

}
