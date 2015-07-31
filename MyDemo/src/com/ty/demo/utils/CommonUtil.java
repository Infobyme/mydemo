package com.ty.demo.utils;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class CommonUtil {

	/**
	 * 活动之间跳转 不带参数的
	 * @param context 上下文
	 * @param clazz 跳转到的活动
	 */
	public static void toClazz(Context context, Class clazz) {

		Intent intent = new Intent(context, clazz);
		context.startActivity(intent);
	}

	/**
	 * 活动之间跳转 带参数的
	 * @param context 上下文
	 * @param clazz 跳转到的活动
	 * @param bundle 需要带的参数
	 */
	public static void toClazz(Context context, Class clazz,Bundle bundle) {
		Intent intent = new Intent(context, clazz);
		intent.putExtras(bundle);
		context.startActivity(intent);
	}
}
