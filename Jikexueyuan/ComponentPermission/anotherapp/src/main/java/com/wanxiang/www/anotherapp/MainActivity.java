package com.wanxiang.www.anotherapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		findViewById(R.id.btnStartMyAty).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				startActivity(new Intent("com.wanxiang.www.componentpermission.intent.action.MyAty"));
				Log.d("MainActivity", "Task ID is " + getTaskId());
			}
		});
	}
}
