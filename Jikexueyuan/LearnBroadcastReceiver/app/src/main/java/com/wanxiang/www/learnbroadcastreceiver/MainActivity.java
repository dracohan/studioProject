package com.wanxiang.www.learnbroadcastreceiver;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		findViewById(R.id.btnSendMsg).setOnClickListener(this);
		findViewById(R.id.btnRegister).setOnClickListener(this);
		findViewById(R.id.btnUnRegister).setOnClickListener(this);
	}

	@Override
	public void onClick(View view) {
		switch (view.getId()){
			case R.id.btnSendMsg:
//				sendBroadcast(new Intent(this, MyReceiver.class).putExtra("data", "内容"));
				Intent i = new Intent(MyReceiver.ACTION);
				i.putExtra("data", "jikexueyuan");
				sendOrderedBroadcast(i, null);
				break;
			case R.id.btnRegister:
				if (myReceiver == null){
					myReceiver = new MyReceiver();
					registerReceiver(myReceiver, new IntentFilter(MyReceiver.ACTION));
				}
				break;
			case R.id.btnUnRegister:
				if (myReceiver != null){
					unregisterReceiver(myReceiver);
					myReceiver =null;
				}
				break;
			default:
				break;
		}
	}

	private MyReceiver myReceiver = null;
}
