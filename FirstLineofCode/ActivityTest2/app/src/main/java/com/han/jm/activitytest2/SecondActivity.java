package com.han.jm.activitytest2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

/**
 * Created by JM on 2016/4/16.
 */
public class SecondActivity extends BaseActivity {
	@Override
	protected void onCreate(Bundle savedinstanceState) {
		super.onCreate(savedinstanceState);
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

}

