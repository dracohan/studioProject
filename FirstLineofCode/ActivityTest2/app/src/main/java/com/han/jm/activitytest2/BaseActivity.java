package com.han.jm.activitytest2;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by JM on 2016/4/25.
 */
public class BaseActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedinstanceState) {
		super.onCreate(savedinstanceState);
		Log.d("BaseActivity", getClass().getSimpleName());
	}
}
