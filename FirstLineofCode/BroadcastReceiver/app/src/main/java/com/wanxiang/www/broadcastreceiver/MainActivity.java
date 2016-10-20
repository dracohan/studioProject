package com.wanxiang.www.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by JM on 2016/8/13.
 */
public class MainActivity extends BaseActivity{
	private IntentFilter intentFilter;

	private  NetworkChangeReceiver networkChangeReceiver;

	@Override
	protected void onCreate(Bundle savedinstanceState) {
		super.onCreate(savedinstanceState);
		setContentView(R.layout.activity_main);
		//dynamic register
		intentFilter = new IntentFilter();
		intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
		networkChangeReceiver = new NetworkChangeReceiver();
		registerReceiver(networkChangeReceiver, intentFilter);

		//MyBroadcastReceiver
		Button button = (Button)findViewById(R.id.send);
		button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent = new Intent("com.wanxiang.www.broadcastreceiver.MY_BROADCAST");
				sendOrderedBroadcast(intent,null);
			}
		});
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		unregisterReceiver(networkChangeReceiver);
	}



	class NetworkChangeReceiver extends BroadcastReceiver{
		@Override
		public void onReceive(Context context, Intent intent) {
			ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
			NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
			if(networkInfo != null && networkInfo.isAvailable())
				Toast.makeText(context, "network state is available", Toast.LENGTH_SHORT).show();
			else
				Toast.makeText(context, "network state isn't available", Toast.LENGTH_SHORT).show();
		}
	}
}


