package com.wanxiang.www.myapplication;


import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class CustomButtonTestActivity extends Activity implements View.OnTouchListener{

	private static final String TAG = "MotionEventDispatch";
	private CustomButton button;
	private CustomLayout layout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_custom_button_test);
		button = (CustomButton) findViewById(R.id.button1);
		layout = (CustomLayout) findViewById(R.id.linearlayout_test);
		button.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Log.i(TAG, "CustomButton--onClick");

			}
		});

		button.setOnTouchListener(new View.OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				switch (event.getAction()) {
					case MotionEvent.ACTION_DOWN:
						Log.i(TAG, "CustomButton-onTouch-ACTION_DOWN");
						break;
					case MotionEvent.ACTION_UP:
						Log.i(TAG, "CustomButton-onTouch-ACTION_UP");
						break;
					default:
						break;
				}
				return false;
			}
		});

		layout.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Log.i(TAG, "CustomLayout---onClick");

			}
		});

		layout.setOnTouchListener(new View.OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				switch (event.getAction()) {

					case MotionEvent.ACTION_DOWN:
						Log.i(TAG, "CustomLayout-onTouch-ACTION_DOWN");
						break;
					case MotionEvent.ACTION_UP:
						Log.i(TAG, "CustomLayout-onTouch-ACTION_UP");
						break;

					default:
						break;

				}
				return false;
			}
		});
	}


	@Override
	public boolean dispatchTouchEvent(MotionEvent ev) {
		switch (ev.getAction()) {
			case MotionEvent.ACTION_DOWN:
				Log.i(TAG, "MainActivity-dispatchTouchEvent-ACTION_DOWN");
				break;
			case MotionEvent.ACTION_UP:
				Log.i(TAG, "MainActivity-dispatchTouchEvent-ACTION_UP");
				break;
			default:
				break;
		}
		return super.dispatchTouchEvent(ev);
	}


	@Override
	public boolean onTouchEvent(MotionEvent event) {
		switch (event.getAction()) {
			case MotionEvent.ACTION_DOWN:
				Log.i(TAG, "MainActivity-onTouchEvent-ACTION_DOWN");
				break;
			case MotionEvent.ACTION_UP:
				Log.i(TAG, "MainActivity-onTouchEvent-ACTION_UP");
				break;
			default:
				break;
		}
		return super.onTouchEvent(event);
	}


	@Override
	public boolean onTouch(View view, MotionEvent motionEvent) {
		return false;
	}
}


