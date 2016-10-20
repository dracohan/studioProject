package com.wanxiang.www.myapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Base.main(null);
	}

	public void startAty(View view) {
		Intent i = new Intent("com.wanxiang.www.myapp.ACTION.STARTATY");
		startActivity(i);
//		String title = getResources().getString(R.string.title);
//		Intent chooser = Intent.createChooser(i, title);

//		if (i.resolveActivity(getPackageManager()) != null){
//			startActivity(chooser);
//		} else {
//			Toast.makeText(this, "There is no Activity to handle this action",
//					Toast.LENGTH_SHORT).show();
//		}
	}
}
