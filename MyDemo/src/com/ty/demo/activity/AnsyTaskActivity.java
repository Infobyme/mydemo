package com.ty.demo.activity;

import android.os.Bundle;
import android.widget.ListView;

import com.ty.demo.R;
import com.ty.demo.adapter.AnsycTaskAdapter;
import com.ty.demo.base.BaseActivity;

/**
 * Created by Administrator on 2015/7/30.
 */
public class AnsyTaskActivity  extends BaseActivity{

    private ListView mListView;

    private AnsycTaskAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ansyctask);

        initView();

        //this is test
    }

    @Override
    public void initView() {

        mListView= (ListView) findViewById(R.id.ansyctask_list);
        mAdapter=new AnsycTaskAdapter(baseContext);

        mListView.setAdapter(mAdapter);
    }
}
