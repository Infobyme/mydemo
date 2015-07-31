package com.ty.demo.activity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.ty.demo.R;
import com.ty.demo.adapter.SortAdapter;
import com.ty.demo.base.BaseActivity;
import com.ty.demo.entity.City;
import com.ty.demo.modle.PinyinComparator;
import com.ty.demo.utils.StringUtil;

public class CitySeleorActivity extends BaseActivity{
	
	
	private ListView mListView;
	private SortAdapter mAdapter;
	
	private List<City> cityList;
	private PinyinComparator pinyincomparator;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.layout_city);
		
		
		initData();
		initView();
		
	}

	private void initData() {
		// TODO Auto-generated method stub
		pinyincomparator=new PinyinComparator();
		cityList=new ArrayList<City>();
		String[] array=getResources().getStringArray(R.array.city_data);
		
		for (int i = 0; i < array.length; i++) {
			City city=new City();
			String name=array[i];
			city.setName(name);
			
			String pinyin=StringUtil.converterToSpell(name).toUpperCase();
			
			pinyin=pinyin.substring(0, 1);
			
			if (pinyin.matches("[A-Z]")) {
				city.setSortLetters(pinyin);
			}else{
				city.setSortLetters("#");
			}
			cityList.add(city);
		}
		Collections.sort(cityList, pinyincomparator);
		
	}

	public void initView() {
		// TODO Auto-generated method stub
		mListView=(ListView) findViewById(R.id.city_list);
		mAdapter=new SortAdapter(baseContext, cityList);
		
		mListView.setAdapter(mAdapter);
	}

}
