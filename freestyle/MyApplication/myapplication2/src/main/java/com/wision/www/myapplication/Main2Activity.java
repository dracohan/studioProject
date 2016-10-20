package com.wision.www.myapplication;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main2);

		Button btn = (Button) findViewById(R.id.btn);
		btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				switch (v.getId()) {
					case R.id.btn:
						SecondFragment secondFragment = new SecondFragment();
						FragmentManager fragmentManager = getFragmentManager();
						FragmentTransaction transaction = fragmentManager.beginTransaction();
						transaction.replace(R.id.frame_container, secondFragment);
						transaction.addToBackStack(null);
						transaction.commit();
						break;
					default:
						break;


				}
			}
		});
	}
}
