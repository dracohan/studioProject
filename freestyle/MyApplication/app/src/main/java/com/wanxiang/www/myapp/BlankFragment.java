package com.wanxiang.www.myapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {


	public BlankFragment() {
		// Required empty public constructor
	}


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                         Bundle savedInstanceState) {


		// Inflate the layout for this fragment
		View rootView = inflater.inflate(R.layout.fragment_blank, container, false);
		rootView.findViewById(R.id.btnStartFrag2).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				getFragmentManager().beginTransaction()
						.addToBackStack(null)
						.replace(R.id.container, new BlankFragment2())
						.commit();
			}
		});
		return rootView;
	}

}
