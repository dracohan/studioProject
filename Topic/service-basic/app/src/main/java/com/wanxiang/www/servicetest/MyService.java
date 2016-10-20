package com.wanxiang.www.servicetest;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

/**
 * Created by JM on 2016/8/16.
 */
public class MyService extends Service {
	private static String TAG = "MyService";

	private DownloadBinder mBinder = new DownloadBinder();

	class DownloadBinder extends Binder {

		public void startDownload(){
			Log.d(TAG, "startDownload");
		}

		public int getProgress(){
			Log.d(TAG, "getProgress");
			return 0;
		}
	}
	@Override
	public IBinder onBind(Intent intent){
		Log.d(TAG, "onBind");
		return mBinder;
	}

	@Override
	public void onCreate(){
		super.onCreate();

		Log.d("MyService", "attemped to start Foreground notification");
		Notification.Builder builder = new Notification.
				Builder(getApplicationContext());
		builder.setContentTitle("This is tilte");
		builder.setContentText("This is content");
		builder.setSmallIcon(R.drawable.desert);

		Intent[] intent = {new Intent(this, MainActivity.class)};
		PendingIntent pi = PendingIntent.getActivities(this, 0, intent, 0);
		builder.setContentIntent(pi);
		Notification notification = builder.getNotification();
		startForeground(1, notification);

		Log.d(TAG ,"onCreate");
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId){
		Log.d(TAG ,"onStartCommand");
		// work logic
		new Thread(new Runnable() {
			@Override
			public void run() {
				Log.d(TAG, "run");
//				stopSelf();
				Log.d(TAG, "stop");

			}
		}).start();
		return START_STICKY;
	}

	@Override
	public void onDestroy(){
		super.onDestroy();
		Log.d(TAG, "onDestroy");

	}
}
