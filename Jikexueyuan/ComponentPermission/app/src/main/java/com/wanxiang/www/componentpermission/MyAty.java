package com.wanxiang.www.componentpermission;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MyAty extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_my_aty);
		Log.d("MyAty", "Task ID is " + getTaskId());
	}
}
