package com.wanxiang.www.myapp;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class MyService extends Service {


	private String data = null;
	private boolean running = false;

	public MyService() {
	}

	public class MyBinder extends Binder {
		void setData(String data) {
			MyService.this.data = data;
		}
	}

	@Override
	public IBinder onBind(Intent intent) {
		return new MyBinder();
	}

	@Override
	public void onCreate() {
		super.onCreate();
		System.out.println("onCreate");

		running = true;

		new Thread() {
			@Override
			public void run() {
				super.run();
				while (running) {
					if (data != null) {
						System.out.println("data: " + data);
					} else {
						System.out.println("data is null");
					}
					try {
						sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}.start();


	}

	@Override
	public void onDestroy() {
		System.out.println("onDestroy");
		running = false;
		super.onDestroy();
	}

}
