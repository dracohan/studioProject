package com.wanxiang.www.connectservice;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, ServiceConnection {
	private static final int UPDATE_TEXT = 1;
	private EditText etData;
	private TextView tvOut;
	private MyService.MyBinder myBinder;

	private Handler handler = new Handler(){
		@Override
		public void handleMessage(Message msg) {
				tvOut.setText(msg.getData().getString("data"));
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		etData = (EditText) findViewById(R.id.etData);
		tvOut = (TextView) findViewById(R.id.tvOut);

		findViewById(R.id.btnStartService).setOnClickListener(this);
		findViewById(R.id.btnStopService).setOnClickListener(this);
		findViewById(R.id.btnBindService).setOnClickListener(this);
		findViewById(R.id.btnUnbindService).setOnClickListener(this);
		findViewById(R.id.btnSyncData).setOnClickListener(this);
	}



	@Override
	public void onClick(View view) {
		switch (view.getId()){
			case R.id.btnStartService:
				Intent startIntent = new Intent(MainActivity.this, MyService.class);
				startIntent.putExtra("data", etData.getText().toString());
				startService(startIntent);
				break;
			case R.id.btnStopService:
				Intent stopIntent = new Intent(MainActivity.this, MyService.class);
				stopService(stopIntent);
				break;
			case R.id.btnBindService:
				bindService(new Intent(this, MyService.class), this, BIND_AUTO_CREATE);
				break;
			case R.id.btnUnbindService:
				unbindService(this);
				break;
			case R.id.btnSyncData:
				if (myBinder != null)
					myBinder.setData(etData.getText().toString());
				break;
			default:
				break;

		}
	}

	@Override
	public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
		myBinder = (MyService.MyBinder)iBinder;

		myBinder.getService().setCallBack(new MyService.CallBack() {
			@Override
			public void callBackFunc(String str) {
				Message message = new Message();
				Bundle b = new Bundle();
				b.putString("data", str);
				message.setData(b);
				handler.sendMessage(message);
			}
		});

	}

	@Override
	public void onServiceDisconnected(ComponentName componentName) {

	}
}
