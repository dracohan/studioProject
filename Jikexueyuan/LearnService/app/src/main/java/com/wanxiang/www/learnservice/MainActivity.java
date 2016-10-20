package com.wanxiang.www.learnservice;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;

public class MainActivity extends Activity implements View.OnClickListener, ServiceConnection {

	private Intent intent;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		System.out.println("Activity onCreate");

		intent = new Intent(MainActivity.this, MyService.class);
		findViewById(R.id.btnStartService).setOnClickListener(this);
		findViewById(R.id.btnStopService).setOnClickListener(this);
		findViewById(R.id.btnBindService).setOnClickListener(this);
		findViewById(R.id.btnUnbindService).setOnClickListener(this);
	}

	@Override
	public void onClick(View view) {
		switch (view.getId()){
			case R.id.btnStartService:
				startService(intent);
				break;
			case R.id.btnStopService:
				stopService(intent);
				break;
			case R.id.btnBindService:
				bindService(intent, this, BIND_AUTO_CREATE);
				break;
			case R.id.btnUnbindService:
				unbindService(this);
				break;
			default:
				break;
		}
	}

	@Override
	public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
		System.out.println("服务连接成功");
	}

	@Override
	public void onServiceDisconnected(ComponentName componentName) {
		System.out.println("服务断开成功");

	}
}
