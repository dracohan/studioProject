package com.wanxiang.www.smstest;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.TextView;

/**
 * Created by JM on 2016/8/15.
 */
public class MainActivity extends Activity {

	private TextView sender;

	private TextView content;

	private IntentFilter receiveFilter;

	private MessageReceiver messageReceiver;

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		sender = (TextView)findViewById(R.id.sender);
		content = (TextView)findViewById(R.id.content);
		receiveFilter = new IntentFilter();
		receiveFilter.addAction("android.provider.Telephony.SMS_RECEIVED");
		messageReceiver = new MessageReceiver();
		registerReceiver(messageReceiver, receiveFilter);
	}

	@Override
	protected void onDestroy(){
		super.onDestroy();
		unregisterReceiver(messageReceiver);
	}

	class MessageReceiver extends BroadcastReceiver{
		@Override
		public void onReceive(Context context,Intent intent){
			Bundle bundle = intent.getExtras();
			Object[] pdus = (Object[])bundle.get("pdus");
			SmsMessage[] messages = new SmsMessage[pdus.length];
			for (int i = 0; i < messages.length; i++){
				messages[i] = SmsMessage.createFromPdu((byte[])pdus[i]);
			}
			String address = messages[0].getOriginatingAddress();
			String fullMessage = "";
			for(SmsMessage message : messages){
				fullMessage += message.getMessageBody();
			}
			sender.setText(address);
			content.setText(fullMessage);
		}
	}
}
