package com.wanxiang.www.myapplication;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by JM on 2016/9/9.
 */
public class Customview extends View {

	private static final String TAG = "Customview";
	private int mLastX;
	private int mLastY;

	public Customview(Context context, AttributeSet attrs) {
		super(context, attrs);

		TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.Customview);
		int color = ta.getColor(R.styleable.Customview_rect_color, 0xff0000ff);
		setBackgroundColor(color);
		ta.recycle();
	}

	public Customview(Context context) {
		super(context);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		Log.d(TAG, "CustomView onTouchEvent");
		int x = (int) event.getRawX();
		int y = (int) event.getRawY();
		switch (event.getAction()) {
			case MotionEvent.ACTION_DOWN: {
				break;
			}
			case MotionEvent.ACTION_MOVE: {
				int deltaX = x - mLastX;
				int deltaY = y - mLastY;
//				Log.d(TAG, "move, deltaX:" + deltaX +
//						" deltaY:" + deltaY);
				int translationX = (int) (getTranslationX() + deltaX);
				int translationY = (int) (getTranslationY() + deltaY);
				setTranslationX(translationX);
				setTranslationY(translationY);
				break;
			}
			default:
				break;
		}
		mLastX = x;
		mLastY = y;
		return true;
	}





}
