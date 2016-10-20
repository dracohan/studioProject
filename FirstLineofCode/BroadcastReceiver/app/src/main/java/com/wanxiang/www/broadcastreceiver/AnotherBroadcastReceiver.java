package com.wanxiang.www.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by JM on 2016/8/13.
 */
public class AnotherBroadcastReceiver extends BroadcastReceiver {
	@Override
	public void onReceive(Context context, Intent intent) {
		Toast.makeText(context, "Received in AnotherBroadcastReceiver", Toast.LENGTH_SHORT).show();
	}
}
