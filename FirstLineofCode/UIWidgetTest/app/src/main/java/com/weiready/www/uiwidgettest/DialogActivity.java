package com.weiready.www.uiwidgettest;

/**
 * Created by JM on 2016/8/10.
 */
import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

public class DialogActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.dialog_layout);
	}
}