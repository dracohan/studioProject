package com.wanxiang.www.applicationcontext;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Main1 extends Activity {

	private TextView tv;

	private EditText et;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		Log.d("App", "Main1 onCreate");

		setContentView(R.layout.layout_main1);

		tv = (TextView) findViewById(R.id.textView);
		et = (EditText) findViewById(R.id.editText);

		tv.setText("Main1共享的数据是：" + getApp().getTextData().toString());

		findViewById(R.id.btnSave).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				((App)getApplicationContext()).setTextData(et.getText().toString());
				tv.setText("共享的数据是：" + et.getText().toString());
			}
		});


	}
	public App getApp(){
			return (App)getApplicationContext();
	}
}
