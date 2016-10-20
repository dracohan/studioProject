package com.wanxiang.www.servicetest;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * Created by JM on 2016/8/16.
 */
public class MainActivity extends Activity implements View.OnClickListener {

	private static String TAG = "MainActivity";
	private Button startService;

	private Button stopService;

	private Button bindService;

	private Button unbindService;
	private Button startIntentService;

	private MyService.DownloadBinder downloadBinder;

	private ServiceConnection connection = new ServiceConnection() {
		@Override
		public void onServiceConnected(ComponentName componentName, IBinder service) {
			Log.d(TAG, "onServiceConnected");
			downloadBinder = (MyService.DownloadBinder) service;
			downloadBinder.startDownload();
			downloadBinder.getProgress();
		}

		@Override
		public void onServiceDisconnected(ComponentName componentName) {
			Log.d(TAG, "onServiceDisconnected");
		}
	};
	private Button startUndeadService;

	protected void onCreate(Bundle savedInstanceBundle){
		super.onCreate(savedInstanceBundle);
		setContentView(R.layout.activity_main);
		startService = (Button) findViewById(R.id.start_service);
		stopService = (Button) findViewById(R.id.stop_service);
		bindService = (Button) findViewById(R.id.bind_service);
		unbindService = (Button) findViewById(R.id.unbind_service);
		startIntentService = (Button) findViewById(R.id.start_intent_service);
		startUndeadService = (Button) findViewById(R.id.start_undead_service);
		startService.setOnClickListener(this);
		stopService.setOnClickListener(this);
		bindService.setOnClickListener(this);
		unbindService.setOnClickListener(this);
		startIntentService.setOnClickListener(this);
		startUndeadService.setOnClickListener(this);
	}

	@Override
	public void onClick(View v){
		switch(v.getId()){
			case R.id.start_service:
				Intent startIntent = new Intent(this, MyService.class);
				//Intent has to be explicit to start Service
//				Intent startIntent = new Intent("com.han.jm.activitytest.ACTION_START");
//				startIntent.addCategory("com.han.jm.activitytest.MY_CATEGORY");
				startService(startIntent);
				break;
			case R.id.stop_service:
				Intent stopIntent = new Intent(this, MyService.class);
				stopService(stopIntent);
				break;
			case R.id.bind_service:
				Intent bindIntent = new Intent(this, MyService.class);
				bindService(bindIntent, connection, BIND_AUTO_CREATE);
				break;
			case R.id.unbind_service:
				unbindService(connection);
				break;
			case R.id.start_intent_service:
				Log.d("MainActivity", "Thread id is " + Thread.currentThread().getId());
				Intent intentService = new Intent(this, MyIntentService.class);
				startService(intentService);
				break;
			case R.id.start_undead_service:
				Log.d("MainActivity", "Thread id is " + Thread.currentThread().getId());
				ServiceUtils.startAllService(this);
				break;
			default:
				break;
		}
	}
}
