package com.wanxiang.www.app1;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
	public static final String ACTION = "com.wanxiang.www.launchmode.ACTION";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		findViewById(R.id.btnStartApp).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				try {
					startActivity(new Intent(MainActivity.ACTION, Uri.parse("app://hello")));
				} catch (Exception e){
					Toast.makeText(MainActivity.this, "无法启动指定的Action", Toast.LENGTH_SHORT).show();
				}
			}
		});
	}
}
