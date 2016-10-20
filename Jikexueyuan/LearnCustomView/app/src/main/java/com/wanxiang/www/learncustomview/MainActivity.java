package com.wanxiang.www.learncustomview;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {

	private MyRect myRect;
//	private LinearLayout ll;
//
//
//	private View.OnClickListener myRectOnclickListener = new View.OnClickListener() {
//		@Override
//		public void onClick(View view) {
//			Button button = new Button(MainActivity.this);
//			button.setText("New add");
//
//			ll.addView(button);
//		}
//	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);


	}
}
