package com.wanxiang.www.serialization;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

	private TextView textview;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		textview = (TextView)findViewById(R.id.textview);

		findViewById(R.id.startAty).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent = new Intent(MainActivity.this, ActivityAnotherAty.class);
				intent.putExtra("user", new User("jikexueyuan", 2));
				startActivityForResult(intent,0);
			}
		});

	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		textview.setText("另一个Activity传回的数据是："+data.getStringExtra("data"));
	}
}
