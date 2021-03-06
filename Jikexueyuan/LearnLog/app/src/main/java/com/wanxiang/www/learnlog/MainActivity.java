package com.wanxiang.www.learnlog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

	private static final String TAG = "MainActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
//		System.out.println("普通日志");
//		System.err.println("错误日志");

		Log.e(TAG, "错误信息");
		Log.w(TAG, "警告信息");
		Log.i(TAG, "普通信息");
		Log.d(TAG, "调试信息");
		Log.v(TAG, "无用信息");

		Log.e("MSG", "其他信息");

	}
}
