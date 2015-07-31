package com.ty.demo.utils;

import android.app.Activity;
import android.util.DisplayMetrics;

public class MeasureUtil {
	
	
	public static int[] getScreenSize(Activity activity){
		
		DisplayMetrics dm=new DisplayMetrics();
		
		activity.getWindowManager().getDefaultDisplay().getMetrics(dm);
		
		return new int[]{dm.widthPixels,dm.heightPixels};
		
	}

}
