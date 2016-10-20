package com.wanxiang.www.learncustomview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by JM on 2016/8/27.
 */
public class MyRect extends View {
	public MyRect(Context context, AttributeSet attrs) {
		super(context, attrs);

		TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.MyView);


		int color = ta.getColor(R.styleable.MyView_rect_color, 0xff00ffff);


		setBackgroundColor(color);


		ta.recycle();

	}


	public MyRect(Context context) {
		super(context);
	}
}
