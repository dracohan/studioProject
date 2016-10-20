package com.wanxiang.www.myapplication;

/**
 * Created by JM on 2016/9/9.
 */

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

public class CustomLayout extends LinearLayout {
	private final static String TAG = "MotionEventDispatch";

	public CustomLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		switch (event.getAction()) {

			case MotionEvent.ACTION_DOWN:

				Log.i(TAG, "CustomLayout-onTouchEvent-ACTION_DOWN");
				break;
			case MotionEvent.ACTION_UP:
				Log.i(TAG, "CustomLayout-onTouchEvent-ACTION_UP");
				break;
			default:
				break;

		}
		return super.onTouchEvent(event);
	}

	@Override
	public boolean dispatchTouchEvent(MotionEvent ev) {
		switch (ev.getAction()) {

			case MotionEvent.ACTION_DOWN:
				Log.i(TAG, "CustomLayout-dispatchTouchEvent-ACTION_DOWN");
				break;

			case MotionEvent.ACTION_UP:
				Log.i(TAG, "CustomLayout-dispatchTouchEvent-ACTION_UP");
				break;

			default:
				break;

		}
		return super.dispatchTouchEvent(ev);
	}

	@Override
	public boolean onInterceptTouchEvent(MotionEvent ev) {
		switch (ev.getAction()) {

			case MotionEvent.ACTION_DOWN:
				Log.i(TAG, "CustomLayout-onInterceptTouchEvent-ACTION_DOWN");
				break;

			case MotionEvent.ACTION_UP:
				Log.i(TAG, "CustomLayout-onInterceptTouchEvent-ACTION_UP");
				break;

			default:
				break;

		}
		return super.onInterceptTouchEvent(ev);
	}

}


