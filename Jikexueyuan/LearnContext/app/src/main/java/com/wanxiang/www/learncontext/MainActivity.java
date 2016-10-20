package com.wanxiang.www.learncontext;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

	private TextView tv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//		tv = new TextView(this);
////		tv.setText("Hello Android");
//		tv.setText(R.string.str);
//		System.out.println(getResources().getText(R.string.str));
//		setContentView(tv);
		ImageView iv = new ImageView(this);
		iv.setImageResource(R.mipmap.ic_launcher);
		setContentView(iv);
	}
}
