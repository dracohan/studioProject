package com.han.jm.activitytest2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;

/**
 * Created by JM on 2016/4/12.
 */
public class FirstActivity extends BaseActivity {
	@Override
	protected void onCreate(Bundle savedinstanceState){
		super.onCreate(savedinstanceState);
		Log.d("FirstActivity", this.toString());
		Log.d("FirstActivity", "Task id is " + getTaskId());
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.first_layout);
		Button button1 = (Button) findViewById(R.id.button_1);
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				//Toast text
				//Toast.makeText(FirstActivity.this, "You clicked Button 1",
				//		Toast.LENGTH_SHORT).show();

				//Explicit Intent
				Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
				startActivity(intent);

				//Implicit Intent
				//Intent intent = new Intent("com.han.jm.activitytest2.ACTION_START");
				//intent.addCategory("com.han.jm.activitytest2.MY_CATEGORY");
				//startActivity(intent);

				//More implicit intent
				//Intent intent = new Intent(Intent.ACTION_VIEW);
				//intent.setData(Uri.parse("http://www.baidu.com"));
				//intent.setData(Uri.parse("tel:10086"));
				//startActivity(intent);

				//transfer data
				//String data = "Hello SecondActivity";
				//Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
				//intent.putExtra("extra_data", data);
				//startActivity(intent);

				//get result
				//Intent intent = new Intent(FirstActivity.this, FirstActivity.class);
				//startActivityForResult(intent, 1);


			}
		});

	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		switch (requestCode) {
			case 1:
				if (resultCode == RESULT_OK) {
					String returnedData = data.getStringExtra("data_return");
					Log.d("FirstActivity", returnedData);
				}
				break;
			default:
		}
	}

	@Override
	protected void onRestart() {
		super.onRestart();
		Log.d("FirstActivity", "onRestart");
	}

	@Override
	protected void onStart() {
		super.onStart();
		Log.d("FirstActivity", "onStart");
	}

	@Override
	protected void onResume() {
		super.onResume();
		Log.d("FirstActivity", "onResume");
	}

	@Override
	protected void onPause() {
		super.onPause();
		Log.d("FirstActivity", "onPause");
	}

	@Override
	protected void onStop() {
		super.onStop();
		Log.d("FirstActivity", "onStop");
	}
	@Override
	protected void onDestroy() {
		super.onDestroy();
		Log.d("FirstActivity", "onDestroy");
	}


}
