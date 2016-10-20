package com.wanxiang.www.myapplication;

/**
 * Created by JM on 2016/9/9.
 */

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Button;

public class CustomButton extends Button{

	private static final String TAG = "MotionEventDispatch";

	public CustomButton(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	// 位于textview里面
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		switch (event.getAction()) {
			case MotionEvent.ACTION_DOWN:
				Log.i(TAG, "CustomButton-onTouchEvent-ACTION_DOWN");
				break;
			case MotionEvent.ACTION_UP:
				Log.i(TAG, "CustomButton-onTouchEvent-ACTION_UP");
				break;
			default:
				break;
		}
		return super.onTouchEvent(event);
	}

	// 位于view里面
	@Override
	public boolean dispatchTouchEvent(MotionEvent event) {
		switch (event.getAction()) {
			case MotionEvent.ACTION_DOWN:
				Log.i(TAG, "CustomButton-dispatchTouchEvent-ACTION_DOWN");
				break;
			case MotionEvent.ACTION_UP:
				Log.i(TAG, "CustomButton-dispatchTouchEvent-ACTION_UP");
				break;
			default:
				break;
		}
		return super.dispatchTouchEvent(event);
	}


}
