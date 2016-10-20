package com.wanxiang.www.myapp;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.view.ViewGroup;

public class Main4Activity extends Activity implements View.OnClickListener, ServiceConnection {

	private MyService.MyBinder b;
	private int i = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main4);

		findViewById(R.id.btnStartService).setOnClickListener(this);
		findViewById(R.id.btnStopService).setOnClickListener(this);
		findViewById(R.id.btnBindService).setOnClickListener(this);
		findViewById(R.id.btnUnBindService).setOnClickListener(this);
		findViewById(R.id.btnUpdateService).setOnClickListener(this);

		System.out.println(System.getProperty("java.vm.version"));
		System.out.println("SDK version:" + Build.VERSION.SDK_INT);

		ViewGroup content = (ViewGroup) findViewById(android.R.id.content);
		System.out.println("0: " + content);
		System.out.println("1-0: " + content.getChildAt(0));
		System.out.println("1-1: " + content.getChildAt(1));
		System.out.println("1-2: " + content.getChildAt(2));
		System.out.println("1-3: " + content.getChildAt(3));
		System.out.println("2: " + findViewById(R.id.btnStartService));



	}

	@Override
	public void onClick(View view) {

		switch (view.getId()){
			case R.id.btnStartService:
				startService(new Intent(Main4Activity.this,MyService.class));
				break;
			case R.id.btnStopService:
				stopService(new Intent(Main4Activity.this,MyService.class));
				break;
			case R.id.btnBindService:
				bindService(new Intent(Main4Activity.this,MyService.class), this, BIND_AUTO_CREATE);
				break;
			case R.id.btnUnBindService:
				unbindService(this);
				break;
			case R.id.btnUpdateService:
				String s = "msg";
				b.setData(s+i++);
				break;
			default:
				break;
		}
	}

	@Override
	public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
		System.out.println("onServiceConnected()");
		b = (MyService.MyBinder) iBinder;


	}

	@Override
	public void onServiceDisconnected(ComponentName componentName) {

	}
}
