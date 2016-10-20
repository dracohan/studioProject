package com.wanxiang.www.alphaanimation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
//				AlphaAnimation aa = new AlphaAnimation(0, 1);
//				aa.setDuration(1000);
//				view.startAnimation(aa);

				Animation a = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.aa);
				a.setAnimationListener(new Animation.AnimationListener() {
					@Override
					public void onAnimationStart(Animation animation) {

					}

					@Override
					public void onAnimationEnd(Animation animation) {

					}

					@Override
					public void onAnimationRepeat(Animation animation) {

					}
				});
				view.startAnimation(a);
			}
		});

	}
}
