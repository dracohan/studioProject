package com.wanxiang.www.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.os.Process;
import android.view.View;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Data.data++;
		Log.d("MainActivity", String.valueOf(Data.data));

		Log.d("MainActivity", String.valueOf(Process.myPid()));


		findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent i = new Intent(MainActivity.this, Main2Activity.class);
				startActivity(i);
			}
		});

	}
}
