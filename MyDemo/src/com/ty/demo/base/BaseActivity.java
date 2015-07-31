package com.ty.demo.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;

public abstract class BaseActivity extends Activity{
	
	public Context baseContext;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		baseContext=this;
	}

	public abstract void initView();


	/**
	 * 获取屏幕宽高
	 * @return
	 */
	public int[] getScreenSize(){

		DisplayMetrics dm=new DisplayMetrics();

		getWindowManager().getDefaultDisplay().getMetrics(dm);

		return new int[]{dm.widthPixels,dm.heightPixels};

	}

}
