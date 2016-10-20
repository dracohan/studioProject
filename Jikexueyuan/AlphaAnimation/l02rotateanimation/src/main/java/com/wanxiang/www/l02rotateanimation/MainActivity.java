package com.wanxiang.www.l02rotateanimation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AnimationUtils;

public class MainActivity extends AppCompatActivity {

//	private RotateAnimation ra;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
//
//		ra = new RotateAnimation(0, 360,500,500);
//		ra.setDuration(1000);

		findViewById(R.id.btnRotateMe).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				view.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.ra));
			}
		});

	}
}
