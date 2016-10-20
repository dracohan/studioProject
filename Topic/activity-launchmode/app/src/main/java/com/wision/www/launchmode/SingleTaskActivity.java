package com.wision.www.launchmode;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SingleTaskActivity extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_single_task);


		Button startStandardActivity = (Button) findViewById(R.id.start_normal_activity);

		startStandardActivity.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(SingleTaskActivity.this, StandardActivity.class);
				startActivity(intent);
			}
		});

		Button startSingleTaskActivity = (Button) findViewById(R.id.start_singleTask_activity);

		startSingleTaskActivity.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(SingleTaskActivity.this, SingleTaskActivity.class);
				startActivity(intent);
			}
		});

		Button startMainActivity = (Button) findViewById(R.id.start_main_activity);

		startMainActivity.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(SingleTaskActivity.this, MainActivity.class);
				startActivity(intent);
			}
		});
	}

}
