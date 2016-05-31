package com.han.jm.activitytest2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;

/**
 * Created by JM on 2016/4/16.
 */
public class SecondActivity extends BaseActivity{
	@Override
	protected void onCreate(Bundle savedinstanceState){
		super.onCreate(savedinstanceState);
		Log.d("SecondActivity", this.toString());
		Log.d("SecondActivity", "Task id is " + getTaskId());
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.second_layout);

		//transfer data
		//Intent intent = getIntent();
		//String data = intent.getStringExtra("extra_data");
		//Log.d("SecondActivity", data);

		//get result
		Button button2 = (Button) findViewById(R.id.button_2);
		button2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
/*				Intent intent = new Intent();
				intent.putExtra("data_return", "Hello FirstActivity!");
				setResult(RESULT_OK, intent);
				finish();*/
				Intent intent = new Intent(SecondActivity.this, FirstActivity.class);
				startActivity(intent);
			}
		});
	}

	@Override
	protected void onRestart() {
		super.onRestart();
		Log.d("SecondActivity", "onRestart");
	}

	@Override
	protected void onStart() {
		super.onStart();
		Log.d("SecondActivity", "onStart");
	}

	@Override
	protected void onResume() {
		super.onResume();
		Log.d("SecondActivity", "onResume");
	}

	@Override
	protected void onPause() {
		super.onPause();
		Log.d("SecondActivity", "onPause");
	}

	@Override
	protected void onStop() {
		super.onStop();
		Log.d("SecondActivity", "onStop");
	}
	@Override
	protected void onDestroy() {
		super.onDestroy();
		Log.d("SecondActivity", "onDestroy");
	}
}
