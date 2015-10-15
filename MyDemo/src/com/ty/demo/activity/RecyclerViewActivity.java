package com.ty.demo.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ty.demo.R;
import com.ty.demo.adapter.RecyclerViewAdapter;
import com.ty.demo.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2015/10/15.
 */
public class RecyclerViewActivity extends BaseActivity {


    RecyclerView recyclerview;


    private List<String> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_recyclerview);
        recyclerview= (RecyclerView) findViewById(R.id.recyclerview);
        initView();

    }

    @Override
    public void initView() {
        mData = new ArrayList<String>();
//        LinearLayoutManager  mManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
//        LinearLayoutManager  mManager = new LinearLayoutManager(this);
//        GridLayoutManager mManager=new GridLayoutManager(this ,4);
        StaggeredGridLayoutManager mManager=new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
        initData();
        recyclerview.setLayoutManager(mManager);
        recyclerview.setAdapter(new RecyclerViewAdapter(baseContext,mData));

    }

    private void initData() {
        for (int i = 'A'; i <= 'Z'; i++) {
            mData.add((char) i + "");
        }
    }
}
