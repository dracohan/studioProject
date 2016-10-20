package com.wanxiang.www.servicebestpractice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by JM on 2016/8/16.
 */
public class AlarmReceiver extends BroadcastReceiver {
	@Override
	public void onReceive(Context context, Intent intent){
		Intent i = new Intent(context, LongRunningService.class);
		context.startService(i);
	}
}
