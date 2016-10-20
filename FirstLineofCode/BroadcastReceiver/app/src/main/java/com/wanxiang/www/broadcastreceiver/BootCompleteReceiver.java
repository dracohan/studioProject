package com.wanxiang.www.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by JM on 2016/8/13.
 */
public class BootCompleteReceiver extends BroadcastReceiver {
	//static registered in AndroidManifest.xml
	@Override
	public void onReceive(Context context, Intent intent) {
		Toast.makeText(context, "Boot Complete", Toast.LENGTH_SHORT).show();
	}
}
