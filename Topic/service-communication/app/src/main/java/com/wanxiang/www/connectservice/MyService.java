package com.wanxiang.www.connectservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class MyService extends Service {
	private boolean running = false;
	private String data = "这是Service中提供的默认信息";

	public MyService() {
	}


	public class MyBinder extends android.os.Binder{

		public void setData(String data){
			MyService.this.data = data;
		}

		public MyService getService(){
			return MyService.this;
		}

	}

	@Override
	public IBinder onBind(Intent intent) {
		// TODO: Return the communication channel to the service.
		System.out.println("Service.onBind()");
		return new MyBinder();
	}

	@Override
	public void onCreate() {
		super.onCreate();

		running = true;

		new Thread(){
			@Override
			public void run() {
				super.run();

				int i = 0;

				while (running){

					i++;

					System.out.println(data + i);

					String str = data + i;

					if(callBack != null)
						callBack.callBackFunc(str);

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
		super.onDestroy();
		System.out.println("onDestroy");
		running = false;
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		System.out.println("Service.onStartCommand()");

		data = intent.getStringExtra("data");
		return super.onStartCommand(intent, flags, startId);
	}

	private CallBack callBack;

	public CallBack getCallBack() {
		return callBack;
	}

	public void setCallBack(CallBack callBack) {
		this.callBack = callBack;
	}

	public interface CallBack{
		void callBackFunc(String str);
	}
}
