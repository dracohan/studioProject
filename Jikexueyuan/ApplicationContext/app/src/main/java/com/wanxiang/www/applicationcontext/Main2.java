package com.wanxiang.www.applicationcontext;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by JM on 2016/8/18.
 */
public class Main2 extends Activity {
	private TextView tv;
	private EditText et;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d("App", "Main2 onCreate");

		setContentView(R.layout.layout_main2);

		tv = (TextView) findViewById(R.id.textView);
		et = (EditText) findViewById(R.id.editText);

		tv.setText("Main2共享的数据是：" + getApp().getTextData().toString());

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
