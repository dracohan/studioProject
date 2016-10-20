package com.wanxiang.www.learnrv;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends Activity {

	private RecyclerView rv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		rv = new RecyclerView(this);

		setContentView(rv);

//		rv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true));
		rv.setLayoutManager(new GridLayoutManager(this, 4));
		rv.setAdapter(new MyAdapter());

	}

}
