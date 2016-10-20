package com.wision.www.launchmode;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SingleInstanceActivity extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_single_instance);


		Button startStandardActivity = (Button) findViewById(R.id.start_normal_activity);

		startStandardActivity.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(SingleInstanceActivity.this, StandardActivity.class);
				startActivity(intent);
			}
		});

		Button startSingleInstanceActivity = (Button) findViewById(R.id.start_singleInstance_activity);

		startSingleInstanceActivity.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(SingleInstanceActivity.this, SingleInstanceActivity.class);
				startActivity(intent);
			}
		});

		Button startMainActivity = (Button) findViewById(R.id.start_main_activity);

		startMainActivity.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(SingleInstanceActivity.this, MainActivity.class);
				startActivity(intent);
			}
		});
	}


}
