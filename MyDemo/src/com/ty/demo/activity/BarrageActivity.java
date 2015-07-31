package com.ty.demo.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Layout;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.ty.demo.R;
import com.ty.demo.base.BaseActivity;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Administrator on 2015/7/29.
 */
public class BarrageActivity extends BaseActivity {

    private ListView mListView;
    private RelativeLayout rootLayout;

    private List<String> mData, mBarrageData;

    private int i = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_barrage);
        initView();
    }

    @Override
    public void initView() {

        mBarrageData = new ArrayList<String>();
        mBarrageData.add("这是个弹幕");
        mBarrageData.add("祝福啊 ");
        mBarrageData.add("hello world");
        mBarrageData.add("这是个弹幕1");
        mBarrageData.add("这是个弹幕2");
        mBarrageData.add("这是个弹幕3");
        mData = new ArrayList<String>();
        mData.add(" 1");
        mData.add(" 1");
        mData.add(" 1");
        mData.add(" 1");
        mData.add(" 1");
        mData.add(" 1");
        mData.add(" 1");
        mData.add(" 1");
        mData.add(" 1");
        mData.add(" 1");
        mData.add(" 1");
        mData.add(" 1");
        mData.add(" 1");
        mData.add(" 1");
        mData.add(" 1");
        mData.add(" 1");
        mData.add(" 1");
        mData.add(" 1");
        mData.add(" 1");

        mListView = (ListView) findViewById(R.id.barrage_list);
        rootLayout = (RelativeLayout) findViewById(R.id.barrage_root);

        mListView.setAdapter(new ArrayAdapter<String>(baseContext, android.R.layout.simple_list_item_1, mData));

//        addBarrage();
        mHandler.postDelayed(mRunnable, 1000);
    }

    Runnable mRunnable=new Runnable() {
        @Override
        public void run() {
            addBarrage();
            mHandler.postDelayed(mRunnable, 1000);
        }
    };


    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };


    /**
     * 添加弹幕
     */
    private void addBarrage() {
        if (i<mBarrageData.size()) {
            TextView tv = new TextView(baseContext);

            ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

            tv.setLayoutParams(lp);

            tv.setTranslationY(new Random().nextInt(getScreenSize()[1]));

            tv.setTranslationX(getScreenSize()[0]);

            tv.setText(mBarrageData.get(i));

            rootLayout.addView(tv);

            textViewAnimation(tv);
            i++;
        }
    }

    /**
     * 添加动画效果
     * @param tv
     */
    private void textViewAnimation(final TextView tv) {

        float curTranslationX = tv.getTranslationX();
        ObjectAnimator animator = ObjectAnimator.ofFloat(tv, "translationX", curTranslationX, -500f);
        animator.setDuration(5000);
        animator.start();

        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                rootLayout.removeView(tv);
            }
        });

    }

}
