package com.wanxiang.www.androidthreadtest;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by JM on 2016/8/15.
 */
public class MainActivity extends Activity implements View.OnClickListener {

	public static final int UPDATE_TEXT = 1;

	private TextView text;

	private Button changeText;

	private Handler handler = new Handler(){
		public void handleMessage(Message msg){
			switch (msg.what){
				case UPDATE_TEXT:
					text.setText("Nice to meet you");
					break;
				default:
					break;
			}
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceBundle){
		super.onCreate(savedInstanceBundle);
		setContentView(R.layout.activity_main);
		text = (TextView)findViewById(R.id.text);
		changeText = (Button) findViewById(R.id.change_text);
		changeText.setOnClickListener(this);
	}

	@Override
	public void onClick(View v){
		switch (v.getId()){
			case R.id.change_text:
				new Thread(new Runnable() {
					@Override
					public void run() {
						//call crash
						//text.setText("Nice to meet you");
						Message message = new Message();
						message.what = UPDATE_TEXT;
						handler.sendMessage(message);
					}
				}).start();
				break;
			default:
				break;
		}
	}
}
