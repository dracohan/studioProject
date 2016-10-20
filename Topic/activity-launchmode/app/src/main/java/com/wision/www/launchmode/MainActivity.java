package com.wision.www.launchmode;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Button startNormalActivity = (Button) findViewById(R.id.start_normal_activity);
		Button startsingleTopActivity = (Button) findViewById(R.id.start_singleTop_activity);
		Button startsingleTaskActivity = (Button) findViewById(R.id.start_singleTask_activity);
		Button startsingleInstanceActivity = (Button) findViewById(R.id.start_singleInstance_activity);

		startNormalActivity.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, StandardActivity.class);
				startActivity(intent);
			}
		});
		startsingleTopActivity.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, SingleTopActivity.class);
				startActivity(intent);
			}
		});
		startsingleTaskActivity.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, SingleTaskActivity.class);
				startActivity(intent);
			}
		});
		startsingleInstanceActivity.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, SingleInstanceActivity.class);
				startActivity(intent);
			}
		});

	}
}
