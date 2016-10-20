package com.wanxiang.www.learnbroadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class MyReceiver extends BroadcastReceiver {

	public static final String ACTION = "com.wanxiang.www.learnbroadcastreceiver.intent.action.myReceiver";

	public MyReceiver() {
	}

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO: This method is called when the BroadcastReceiver is receiving
		// an Intent broadcast.
		System.out.println("MyReceiver接受到了消息");
//		System.out.println("消息内容是：" + intent.getStringExtra("data"));
	}
}
