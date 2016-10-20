package com.wanxiang.www.serialization;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ActivityAnotherAty extends AppCompatActivity {

	private TextView tv;
	private EditText et;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_activity_another_aty);
		Intent i = getIntent();
//		User b = (User)i.getSerializableExtra("user");
		User b = i.getParcelableExtra("user");
		tv = (TextView)findViewById(R.id.tv);
		et = (EditText)findViewById(R.id.editText);
		tv.setText(String.format("User=%s, Age=%d", b.getName(), b.getAge()));

		findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent = new Intent();
				intent.putExtra("data", et.getText().toString());
				setResult(1, intent);
				finish();
			}
		});
	}
}
