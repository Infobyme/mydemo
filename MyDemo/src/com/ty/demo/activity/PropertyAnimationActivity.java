package com.ty.demo.activity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;
import android.widget.Toast;

import com.nineoldandroids.animation.AnimatorSet;
import com.nineoldandroids.animation.ObjectAnimator;
import com.nineoldandroids.animation.PropertyValuesHolder;
import com.ty.demo.R;
import com.ty.demo.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/8/26.
 */
public class PropertyAnimationActivity extends BaseActivity implements View.OnClickListener{


    private ImageView imageview;

    private int[] res={R.id.image8,R.id.image1,R.id.image2,R.id.image3,R.id.image4,R.id.image5,R.id.image6,R.id.image7};
    private List<ImageView> imageList=new ArrayList<ImageView>();

    private boolean flag=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_propertyanimation);//简单的Animator 的运用
        setContentView(R.layout.activity_propertyanimationz_menu);//实现AcrMenu
        initView();
    }

    @Override
    public void initView() {

        imageview = (ImageView) findViewById(R.id.animation_imageview);

        for (int i = 0; i <res.length; i++) {

            ImageView image= (ImageView) findViewById(res[i]);
            image.setOnClickListener(this);
            imageList.add(image);
        }

    }

    public void move(View view) {
//        Toast.makeText(baseContext,"click",Toast.LENGTH_SHORT).show();
        ObjectAnimator a1 = ObjectAnimator.ofFloat(imageview, "translationY", 0f, 200f);
        ObjectAnimator a2 = ObjectAnimator.ofFloat(imageview, "translationX", 0f, 200f);
        ObjectAnimator a3 = ObjectAnimator.ofFloat(imageview, "rotation", 0f, 360f);

//        PropertyValuesHolder p1=PropertyValuesHolder.ofFloat("translationY",0f,200f);
//        PropertyValuesHolder p2=PropertyValuesHolder.ofFloat("translationX",0f,200f);
//        PropertyValuesHolder p3=PropertyValuesHolder.ofFloat("rotation",0f,360f);
//        ObjectAnimator.ofPropertyValuesHolder(imageview,p1,p2,p3).setDuration(1000).start();

        AnimatorSet set = new AnimatorSet();

//        set.play(a3).after(a1).after(a2);
        set.playSequentially(a3, a2, a1);//一个一个的执行
//        set.playTogether(a1,a2,a3);//一起执行
        set.setDuration(2000);
//        set.setInterpolator(new BounceInterpolator());
        set.start();


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.image8:
                if (flag){
                    startAnimation();
                }else{
                    closeAnimation();
                }
                break;
            default:
                Toast.makeText(baseContext,"click="+v.getId(),Toast.LENGTH_SHORT).show();
                break;
        }

    }

    private void closeAnimation() {
        for (int i = 1; i < imageList.size(); i++) {
            ObjectAnimator animator = ObjectAnimator.ofFloat(imageList.get(i), "translationY", i*100, 0);
            animator.setDuration(200);
            animator.setStartDelay(i * 200);
            animator.setInterpolator(new OvershootInterpolator());
            animator.start();
        }
        flag=true;
    }

    private void startAnimation() {

        for (int i = 1; i < imageList.size(); i++) {
           ObjectAnimator animator = ObjectAnimator.ofFloat(imageList.get(i), "translationY", 0, i * 100);
            animator.setDuration(200);
            animator.setStartDelay(i * 200);
//            animator.setInterpolator(new OvershootInterpolator());
            animator.start();

//            ObjectAnimator animator1= ObjectAnimator.ofFloat(imageList.get(i), "translationX", 0, 30);
//            animator1.setDuration(200);
//            animator1.setStartDelay(i * 200);
////            animator.setInterpolator(new OvershootInterpolator());
//            animator1.start();
        }
        flag=false;
    }
}
