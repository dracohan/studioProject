package com.weiready.www.fragmentbestpractice;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.Window;

public class MainActivity extends FragmentActivity
		implements NewsTitleFragment.OnHeadlineSelectedListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);

		if (findViewById(R.id.fragment_container) != null) {
			//one-panel mode, must add first fragment
			if (savedInstanceState != null) {
				return;
			}

			NewsTitleFragment newsTitleFragment = new NewsTitleFragment();
			newsTitleFragment.setArguments(getIntent().getExtras());
			getSupportFragmentManager().beginTransaction()
					.add(R.id.fragment_container, newsTitleFragment).commit();
		}
	}

	@Override
	public void onArticleSelected(int position) {

		Fragment newsContentFragment = getSupportFragmentManager()
				.findFragmentById(R.id.news_content_fragment);

		if (newsContentFragment != null) {
			//two-panel mode
			newsContentFragment.updateArticleView(position);
		}
	}
}
