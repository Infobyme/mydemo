package com.ty.demo.activity;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.ty.demo.R;
import com.ty.demo.utils.CommonUtil;

public class MainActivity extends Activity {
	
	
	private List<String> demoList;
	
	private ListView mListView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_main);

		initData();
		initView();
	}

	private void initData() {
		// TODO Auto-generated method stub
		
		demoList=new ArrayList<String>();
		demoList.add("FragmentTagHost");
		demoList.add("SortCity");
		demoList.add("CustomView");
		demoList.add("Barrage");
		demoList.add("AsyncTaskError");
		
	}

	private void initView() {
		// TODO Auto-generated method stub
		mListView=(ListView) findViewById(R.id.main_list);
		
		ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, R.layout.layout_item_text, demoList);
		mListView.setAdapter(adapter);
		
		mListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				String type=demoList.get(position);
				if (type.equals("FragmentTagHost")) {
					CommonUtil.toClazz(MainActivity.this, FramentTagHostActivity.class);
				}else if (type.equals("SortCity")) {
					CommonUtil.toClazz(MainActivity.this, CitySeleorActivity.class);
				}else if (type.equals("CustomView")) {
					CommonUtil.toClazz(MainActivity.this, CustomViewActivity.class);
				}else if (type.equals("Barrage")) {
					CommonUtil.toClazz(MainActivity.this, BarrageActivity.class);
				}else if (type.equals("AsyncTaskError")) {
					CommonUtil.toClazz(MainActivity.this, AnsyTaskActivity.class);
				}
				
			}
		});
	}

}
