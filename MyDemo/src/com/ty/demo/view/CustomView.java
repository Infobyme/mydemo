package com.ty.demo.view;

import java.util.Date;

import com.ty.demo.utils.MeasureUtil;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class CustomView extends View implements Runnable{

	private Paint mPatin;
	
	private Paint mTxtPatin;

	private Context mContext;
	
	private int mRadiu;
	
	private int year=2015;
	private int month=5;
	
	private int y=50;

	public CustomView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	public CustomView(Context context, AttributeSet attr) {
		super(context, attr);
		initPaint();
		mContext = context;
	}

	private void initPaint() {
		// ʵ�������ʲ���ʼ��
		mPatin = new Paint(Paint.ANTI_ALIAS_FLAG);
		mTxtPatin=new Paint(Paint.ANTI_ALIAS_FLAG);

		/**
		 * ���ʷ�Ϊ����: Paint.Style.STROKE:��� Paint.Style.FILL:���
		 * Paint.Style.FILL_AND_STROKE:��߲����
		 */

		mPatin.setStyle(Paint.Style.STROKE);
		/**
		 * ������������ɫ
		 */
		mPatin.setColor(Color.LTGRAY);
		mTxtPatin.setColor(Color.BLACK);

		/**
		 * ���û��ʵĿ��
		 */
		mPatin.setStrokeWidth(10);
		mTxtPatin.setStrokeWidth(10);
		mTxtPatin.setTextSize(15);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);

		// canvas.drawArc(MeasureUtil.getScreenSize((Activity) mContext)[0] / 2,
		// startAngle, sweepAngle, useCenter, paint);

		canvas.drawCircle(
				MeasureUtil.getScreenSize((Activity) mContext)[0] / 2,
				MeasureUtil.getScreenSize((Activity) mContext)[1] / 2, mRadiu,
				mPatin);
		
		int i=0;
		int width=(MeasureUtil.getScreenSize((Activity) mContext)[0])/7;
		while(i<7){
			canvas.drawText("星期"+i, width*i+40, y, mTxtPatin);
			i++;
		}
		
		int weekday=time();
		int k=weekday;
		y+=40;
		for (int j = 1; j <= 31; j++) {
			canvas.drawText(""+j, width*weekday+40,y, mTxtPatin);
			weekday++;
			if ((j+k)%7==0) {
				y+=40;
				weekday=0;
			}
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (mRadiu<200) {
			mRadiu+=10;
			if (mRadiu==200) {
				mRadiu=0;
			}
			try {
				Thread.sleep(40);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			postInvalidate();
		}
	}
	
	public int time(){
		boolean isRun = false;

		// �ж�����Ƿ�������
		if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
			isRun = true;
		}

		// ������������¶�Ӧ��������
		int days = 0;// ��ŵ��µ�������
		switch (month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			days = 31;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			days = 30;
			break;
		case 2:
			days = isRun ? 29 : 28;
			break;
		default:
			System.out.println("������·���Ч��");

		}
		int sum1 = 0;
		for (int i = 1900; i < year; i++) {
			if (i % 4 == 0 && i % 100 != 0 || i % 400 == 0)
				sum1 += 366;
			else
				sum1 += 365;
		}

		// ������ݵĵ�һ����������·�֮ǰ������
		int sum2 = 0;
		for (int i = 1; i < month; i++) {
			int dd = 0;
			switch (i) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				dd = 31;
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				dd = 30;
				break;
			case 2:
				dd = isRun ? 29 : 28;
				break;
			}
			sum2 += dd;
		}

		// ����������
		int sumDays = sum1 + sum2;

		// ���������·ݵĵ�һ�������ڼ�
		int weekday = sumDays % 7 + 1;
		if (weekday == 7) {
			weekday = 0;
		}
//		// ѭ���������
//				Date date = new Date();
//				int mm = date.getMonth() + 1;
//				int dd = date.getDate();
//
//				for (int i = 1; i <= days; i++) {
//					if (month == mm && dd == i) {
//						System.out.print("[" + i + "]" + "\t");
//					} else {
//						System.out.print(i + "\t");
//					}
//					if ((i + weekday) % 7 == 0) {
//						System.out.print("\n");
//					}
//				}
		return weekday;
		
	}
	
//	public synchronized void setRadiu(int radiu){
//		this.mRadiu=radiu;
//		
//		invalidate();
//	}

}
