package com.wanxiang.www.startservicefromanotherapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		System.out.println("Activity onCreate");
//		startService(new Intent(MainActivity.this, AppService.class));
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		System.out.println("Activity onDestroy");
//		stopService(new Intent(MainActivity.this, AppService.class));
	}


}
