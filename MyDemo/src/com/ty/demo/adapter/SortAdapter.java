package com.ty.demo.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.SectionIndexer;
import android.widget.TextView;

import com.ty.demo.R;
import com.ty.demo.entity.City;

public class SortAdapter extends BaseAdapter implements SectionIndexer {

	private Context mContext;
	private List<City> mList;

	public SortAdapter(Context context, List<City> list) {
		this.mContext = context;
		this.mList = list;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mList.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return mList.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		CityHolder holder=null;
		
		if (convertView==null) {
			convertView=LayoutInflater.from(mContext).inflate(R.layout.layout_city_item, null);
			
			holder=new CityHolder();
			holder.nav=(TextView) convertView.findViewById(R.id.item_city_nav);
			holder.context=(TextView) convertView.findViewById(R.id.item_city_context);
			
			convertView.setTag(holder);
			
		}else{
			holder=(CityHolder) convertView.getTag();
		}
		
		int section=getSectionForPosition(position);

		
		if (position==getPositionForSection(section)) {
			holder.nav.setVisibility(View.VISIBLE);
			holder.nav.setText(mList.get(position).getSortLetters());
		}else{
			holder.nav.setVisibility(View.GONE);
		}
		
		holder.context.setText(mList.get(position).getName());
		
		return convertView;
	}

	@Override
	public Object[] getSections() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getPositionForSection(int section) {
		
		for (int i = 0; i < getCount(); i++) {
			
			char pinyin=mList.get(i).getSortLetters().toUpperCase().charAt(0);
			
			if (pinyin==section) {
				return i;
			}
			
		}
		return -1;
	}

	@Override
	public int getSectionForPosition(int position) {
		return mList.get(position).getSortLetters().charAt(0);
	}

	class CityHolder {
		TextView nav;
		TextView context;
	}

}
