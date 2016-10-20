package com.wanxiang.www.servicebestpractice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by JM on 2016/8/16.
 */
public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceBundle){
		super.onCreate(savedInstanceBundle);
		Intent intent = new Intent(this, LongRunningService.class);
		startService(intent);
	}
}
