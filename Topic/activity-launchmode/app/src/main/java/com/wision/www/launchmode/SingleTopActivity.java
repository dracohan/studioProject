package com.wision.www.launchmode;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SingleTopActivity extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_single_top);


		Button startStandardActivity = (Button) findViewById(R.id.start_normal_activity);

		startStandardActivity.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(SingleTopActivity.this, StandardActivity.class);
				startActivity(intent);
			}
		});

		Button startSingleTopActivity = (Button) findViewById(R.id.start_singleTop_activity);

		startSingleTopActivity.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(SingleTopActivity.this, SingleTopActivity.class);
				startActivity(intent);
			}
		});

		Button startMainActivity = (Button) findViewById(R.id.start_main_activity);

		startMainActivity.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(SingleTopActivity.this, MainActivity.class);
				startActivity(intent);
			}
		});
	}
}
