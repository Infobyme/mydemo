package com.ty.demo.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;

import com.ty.demo.R;
import com.ty.demo.fragment.Fragment1;
import com.ty.demo.fragment.Fragment2;
import com.ty.demo.fragment.Fragment3;

public class FramentTagHostActivity extends FragmentActivity {

	private FragmentTabHost fth;

	private String[] stringArray = new String[] { "好友", "信息", "通知" };
	
	private Class[] clazzArray=new Class[]{Fragment1.class,Fragment2.class,Fragment3.class};

	@Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		setContentView(R.layout.layout_fragment_tabhost);

		fth = (FragmentTabHost) findViewById(R.id.fragmenttabhost);
		fth.setup(this, getSupportFragmentManager(), R.id.tabhost_content);
		
		for (int i = 0; i < stringArray.length; i++) {
			
			TabSpec spec=fth.newTabSpec(i+"").setIndicator(getTabItemView(i));
			
			fth.addTab(spec, clazzArray[i], null);
		}
		fth.setCurrentTabByTag("0");
//		int result=0;
//		int resou=getResources().getIdentifier("status_bar_height","dimen", "android");
//
//		Log.v("TAG", resou+"=resou");
//		if (resou>0) {
//			result=getResources().getDimensionPixelSize(resou);
//		}
//		
//		Log.v("TAG", result+"=result");
	}
	
	private  View getTabItemView(int index){
		View view=LayoutInflater.from(this).inflate(R.layout.layout_tab_item, null);
		
		ImageView iv=(ImageView) view.findViewById(R.id.tab_item_image);
		TextView tv=(TextView) view.findViewById(R.id.tab_item_text);
		
		iv.setImageResource(R.drawable.ic_launcher);
		tv.setText(stringArray[index]);
		
		return view;
	}

}
