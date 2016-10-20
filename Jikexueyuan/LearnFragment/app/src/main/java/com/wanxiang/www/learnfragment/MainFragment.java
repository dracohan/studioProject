package com.wanxiang.www.learnfragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MainFragment extends Fragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                         Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		View rootView = inflater.inflate(R.layout.fragment_main, container, false);

		rootView.findViewById(R.id.btnShowAnotherFragment).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				getFragmentManager().beginTransaction()
						.addToBackStack(null)
						.replace(R.id.container, new AnotherFragment())
						.commit();
			}
		});

		rootView.findViewById(R.id.btnStartSliderActivity).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				startActivity(new Intent(getActivity(), SliderActivity.class));
			}
		});

		rootView.findViewById(R.id.btnStartTabedActivity).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				startActivity(new Intent(getActivity(), Tabs.class));
			}
		});

		return rootView;
	}


	@Override
	public void onPause() {
		System.out.println("A onPause");
		super.onPause();
	}

	@Override
	public void onDestroy() {
		System.out.println("A onDestroy");
		super.onDestroy();
	}

	@Override
	public void onDestroyView() {
		System.out.println("A onDestroyView");
		super.onDestroyView();
	}
}
