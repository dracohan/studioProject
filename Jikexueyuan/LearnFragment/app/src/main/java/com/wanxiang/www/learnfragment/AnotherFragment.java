package com.wanxiang.www.learnfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by JM on 2016/8/25.
 */
public class AnotherFragment extends android.support.v4.app.Fragment{

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		System.out.println("onCraete");
	}

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

		System.out.println("onCreateView");

		View root = inflater.inflate(R.layout.fragment_another, container, false);

		root.findViewById(R.id.btnBack).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				getFragmentManager().popBackStack();
			}
		});
		return root;
	}

	@Override
	public void onPause() {
		System.out.println("onPause");
		super.onPause();
	}

	@Override
	public void onDestroy() {
		System.out.println("onDestroy");
		super.onDestroy();
	}
}
