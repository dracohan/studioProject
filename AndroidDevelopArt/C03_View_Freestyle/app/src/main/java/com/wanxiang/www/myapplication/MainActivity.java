package com.wanxiang.www.myapplication;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	public static final String TAG = "MainActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				float xdpi = getResources().getDisplayMetrics().widthPixels;
				float ydpi = getResources().getDisplayMetrics().heightPixels;
				Log.d(TAG, "xdpi is " + xdpi);
				Log.d(TAG, "ydpi is " + ydpi);

				//相对于父级容器
				TextView tv = (TextView) findViewById(R.id.tv);
				Button btn = (Button) findViewById(R.id.btn);
				Log.d(TAG, "getTop() is " + tv.getTop());
				Log.d(TAG, "getLeft() is " + tv.getLeft());
				Log.d(TAG, "getBottom() is " + tv.getBottom());
				Log.d(TAG, "getRight() is " + tv.getRight());

				//本身的高度宽度
				Log.d(TAG, "getWidth() is " + tv.getWidth());
				Log.d(TAG, "getHeight() is " + tv.getHeight());

				//最小滑动距离
				int ts = ViewConfiguration.get(MainActivity.this).getScaledTouchSlop();
				Log.d(TAG, "最小滑动距离是：" + ts );

				//滑动
//				findViewById(R.id.tv).scrollBy(0, 0);
//				Log.d(TAG, "getScrollX() is " + tv.getScrollX());
//				Log.d(TAG, "getScrollY() is " + tv.getScrollY());

				//动画
				ObjectAnimator.ofFloat(tv, "translationX", 0, 50)
						.setDuration(100).start();
				ObjectAnimator.ofFloat(btn, "translationX", 0, 300)
						.setDuration(100).start();



			}
		});
	}

	@Override
	protected void onResume() {
		super.onResume();

	}


	@Override
	public boolean onTouchEvent(MotionEvent event) {
		Log.d(TAG, "MainActivity onTouchEvent");
		return super.onTouchEvent(event);
	}



}
