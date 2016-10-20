package com.wanxiang.www.nofificationtest;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by JM on 2016/8/15.
 */
public class MainActivity extends Activity implements View.OnClickListener {

	private Button sendNotice;

	@Override
	protected void onCreate(Bundle savedInstanceBundle){
		super.onCreate(savedInstanceBundle);
		setContentView(R.layout.activity_main);
		sendNotice = (Button)findViewById(R.id.send_notice);
		sendNotice.setOnClickListener(this);
	}

	@Override
	public void onClick(View v){
		switch (v.getId()){
			case R.id.send_notice:
				NotificationManager manager = (NotificationManager)
						getSystemService(NOTIFICATION_SERVICE);
				Notification.Builder builder = new Notification.
						Builder(getApplicationContext());
				builder.setContentTitle("This is tilte");
				builder.setContentText("This is content");
				builder.setSmallIcon(R.drawable.bw84);

				//PendingIntent
				Intent[] intent = {new Intent(this, NotificationActivity.class)};
				PendingIntent pi = PendingIntent.getActivities(this, 0, intent,
						PendingIntent.FLAG_CANCEL_CURRENT);
				builder.setContentIntent(pi);
				Notification notification = builder.getNotification();

				//Vibrate
				//no wait, vibrate 1s, no vibrate 1s, vibrate 1s, no 2s, v 2s..
				//long[] vibrates = {0, 1000, 1000, 1000,2000,2000};
				//notification.vibrate = vibrates;

				//LED
				notification.ledARGB = Color.RED;
				notification.ledOnMS = 1000;
				notification.ledOffMS = 1000;
				notification.flags = Notification.FLAG_SHOW_LIGHTS;

				manager.notify(10, notification);

		}
	}
}
