package com.wanxiang.www.launchmode;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

	public static final String ACTION = "com.wanxiang.www.launchmode.ACTION";
	private TextView tv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main2);

		tv = (TextView) findViewById(R.id.textview);
		tv.setText(String.format("TaskID: %d\n Current Activity ID: %s", getTaskId(), toString()));

		findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent i = new Intent(Main2Activity.this, MainActivity.class);
				startActivity(i);
			}
		});
	}
}
